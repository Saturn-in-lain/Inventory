package database_manager;

/**
 * Created by saturn on 08.11.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class DatabaseItemEmulator extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "inventory";
    private static final String DICTIONARY_TABLE_NAME = "inventory_items";

    private static final String FIELD_1 = "item_id";

    private static final String FIELD_2 = "model";
    private static final String FIELD_3 = "manufacturer";
    private static final String FIELD_4 = "creator";
    private static final String FIELD_5 = "version";
    private static final String FIELD_6 = "modificationDate";
    private static final String FIELD_7 = "owner";
    private static final String FIELD_8 = "serialNumber";
    private static final String FIELD_9 = "barcode";
    private static final String FIELD_10 = "location";
    private static final String FIELD_11 = "state";
    private static final String FIELD_12 = "guaranteeExpiration";
    private static final String FIELD_13 = "office";
    private static final String FIELD_14 = "accountingInventoryCode";
    private static final String FIELD_15 = "comments";

    private static final String FIELD_16 = "image";


    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" +
                    FIELD_1 + " INTEGER PRIMARY KEY, " +
                    FIELD_2 + " TEXT, " +
                    FIELD_3 + " TEXT, " +
                    FIELD_4 + " TEXT, " +
                    FIELD_5 + " TEXT, " +
                    FIELD_6 + " TEXT, " +
                    FIELD_7 + " TEXT, " +
                    FIELD_8 + " TEXT, " +
                    FIELD_9 + " TEXT, " +
                    FIELD_10 + " TEXT, " +
                    FIELD_11 + " TEXT, " +
                    FIELD_12 + " TEXT, " +
                    FIELD_13 + " TEXT, " +
                    FIELD_14 + " TEXT, " +
                    FIELD_15 + " TEXT, " +
                    FIELD_16 + " BLOB );";

    /**
     * Constructor
     * @param context The Context within which to work, used to create the DB
     */
    public DatabaseItemEmulator(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * onCreate
     * @param db - SQL data base class
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    public void onDropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DICTIONARY_TABLE_NAME);
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }
    /**
     * onUpgrade
     * @param
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + DICTIONARY_TABLE_NAME);
        onCreate(db);
    }

    /**
     * Check if the database exist and can be read.
     *
     * @return true if it exists and can be read, false if it doesn't
     */
    public boolean checkDataBase(Context context)
    {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }

    /**
     * addContact
     * @param
     */
    void addItem(ItemDescription item)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIELD_2, item.model);
        values.put(FIELD_3, item.manufacturer);
        values.put(FIELD_4, item.creator);
        values.put(FIELD_5, item.version);
        values.put(FIELD_6, item.modificationDate.toString());
        values.put(FIELD_7, item.owner);
        values.put(FIELD_8, item.serialNumber);
        values.put(FIELD_9, item.barcode);
        values.put(FIELD_10, item.location);
        values.put(FIELD_11, item.state);
        values.put(FIELD_12, item.guaranteeExpiration.toString());
        values.put(FIELD_13, item.office);
        values.put(FIELD_14, item.accountingInventoryCode);
        values.put(FIELD_15, item.comments);
        //values.put(FIELD_16, item.image);


        db.insert(DICTIONARY_TABLE_NAME, null, values);
        db.close();
    }

    public List<ItemDescription> getAllFields()
    {
        List<ItemDescription> itemList = new ArrayList<ItemDescription>();
        String selectQuery = "SELECT  * FROM " + DICTIONARY_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                ItemDescription item = new ItemDescription(cursor.getString(1),
                                                           cursor.getString(2),
                                                           cursor.getString(3),
                                                           cursor.getString(4),
                                                           cursor.getString(5),
                                                           cursor.getString(6),
                                                           cursor.getString(7),
                                                           cursor.getString(8),
                                                           cursor.getString(9),
                                                           cursor.getString(10),
                                                           cursor.getString(11),
                                                           cursor.getString(12),
                                                           cursor.getString(13),
                                                           cursor.getString(14));
                // init fields
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        return itemList;
    }

    public void initializeDefaultItemDataBase()
    {
        onDropTable();
        ItemDescription item1 = new ItemDescription("Model1",
                                                    "Manufacturer:1",
                                                    "Creator:1",
                                                    "Version:1",
                                                    "ModificationDate:1",
                                                    "Owner:1",
                                                    "SerialNumber:1",
                                                    "barcode:1",
                                                    "Location:1",
                                                    "State:1",
                                                    "GuaranteeExpiration:1",
                                                    "Office:1",
                                                    "AccountingInventoryCode:1",
                                                    "Comments:1"               );
        addItem(item1);
        ItemDescription item2 = new ItemDescription("Model2",
                                                    "Manufacturer:2",
                                                    "Creator:2",
                                                    "Version:2",
                                                    "ModificationDate:2",
                                                    "Owner:2",
                                                    "SerialNumber:2",
                                                    "barcode:2",
                                                    "Location:2",
                                                    "State:2",
                                                    "GuaranteeExpiration:2",
                                                    "Office:2",
                                                    "AccountingInventoryCode:2",
                                                    "Comments:2"               );
        addItem(item2);
    }

    /**
     * typeAllDataBaseCredentials
     * @param
     */
    public void typeAllDataBaseCredentials()
    {
        List<ItemDescription> items = getAllFields();
        for (ItemDescription item : items)
        {
            Log.d("DatabaseItemEmulator: ", "-------------------------------------------------");
            Log.d("DatabaseItemEmulator: ",                 item.toString());
            Log.d("DatabaseItemEmulator: ", "-------------------------------------------------");
        }
    }

    //#############################################################################################
    // Starting from here we creating stub methods to get information from database.
    // TODO: Upgrade below if needed
    //#############################################################################################

    /**
     * getAllDataBaseItems
     * @param
     */
    public List<ItemDescription> getAllDataBaseItems()
    {
        return getAllFields();
    }

    /**
     * getAllModelNames
     * @param
     */
    public List<String> getAllModelNames()
    {
        List<ItemDescription> items = getAllFields();
        List<String> models =  new ArrayList<String>();

        for (ItemDescription item : items)
        {
            models.add(item.model);
        }
        return models;
    }

    /**
     * getImageOfModel
     * @param
     */
    public void getImageOfModel(String ModelName)
    {

    }

    /**
     * setImageOfModel
     * @param
     */
    public void setImageOfModel(Bitmap imageBitmap, String ModelName)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        // Convert to byte array
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        cv.put(FIELD_16,byteArray);
        //cv.put(FIELD_3, "Manufact");


        db.beginTransaction();
        try
        {
            try
            {
                //db.update(DICTIONARY_TABLE_NAME, cv, FIELD_1+"=0", null);

                db.update(DICTIONARY_TABLE_NAME, cv, FIELD_2 + " = ?",
                        new String[] { String.valueOf(ModelName) });
                db.setTransactionSuccessful();
            }
            catch (Exception e)
            {
                Log.e("LOG","Error of SQL database call !!!!");
                Log.e("LOG",e.toString());
            }
        }
        finally
        {
            db.endTransaction(); // commit or rollback
            Log.e("LOG","Transaction finished");
        }
        //db.close();
    }
}
