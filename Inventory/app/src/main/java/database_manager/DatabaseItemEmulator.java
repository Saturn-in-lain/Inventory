package database_manager;

/**
 * Created by saturn on 08.11.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseItemEmulator extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
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
                    FIELD_16 + " TEXT );";

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
        values.put(FIELD_16, item.image);


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
                ItemDescription item = new ItemDescription();
                // init fields
                itemList.add(item);
            } while (cursor.moveToNext());
        }
        return itemList;
    }

    public void initializeDefaultDataBase()
    {
        onDropTable();
        ItemDescription item1 = new ItemDescription();
        addItem(item1);
        ItemDescription item2 = new ItemDescription();
        addItem(item2);
    }

    public void typeAllDataBaseCredentials()
    {
//        List<ItemDescription> contacts = getAllCredentials();
//        for (UserCredentials cn : contacts)
//        {
//            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Pwd: " + cn.getPassword();
//            Log.d("Name: ", log);
//        }
    }
}
