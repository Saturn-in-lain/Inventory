package database_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOpenHelper extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "inventory";
    private static final String DICTIONARY_TABLE_NAME = "credentials";

    private static final String FIELD_1 = "user_id";
    private static final String FIELD_2 = "username";
    private static final String FIELD_3 = "password";
    private static final String FIELD_4 = "role";

    private static final String DICTIONARY_TABLE_CREATE =
                                    "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" +
                                            FIELD_1 + " INTEGER PRIMARY KEY, " +
                                            FIELD_2 + " TEXT, " +
                                            FIELD_3 + " TEXT, " +
                                            FIELD_4 + " TEXT );";

    /**
     * Constructor
     * @param context The Context within which to work, used to create the DB
     */
    public DatabaseOpenHelper(Context context)
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
        //Log.i("Inventory DB","onCreate");
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    public void onDropTable() {
        //Log.i("Inventory DB","onDropTable");
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
     * All CRUD(Create, Read, Update, Delete) Operations
     */


    /**
     * addContact
     * @param contact
     */
    void addUser(UserCredentials contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIELD_2, contact.getName());
        values.put(FIELD_3, contact.getPassword());
        values.put(FIELD_4, contact.getRole());
        // Inserting Row
        db.insert(DICTIONARY_TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    /**
     * getCredentials
     * @param id
     */
    public UserCredentials getCredentials(int id)
    {
        UserCredentials contact = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, new String[]
                { FIELD_1, FIELD_2, FIELD_3, FIELD_4 }, FIELD_1 + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
          }
        else{
            Log.e("Inventory DB","Inventory database error of cursor");
        }
        Log.d("Inventory DB count",String.valueOf(cursor.getCount()));

        if(cursor.getCount() > 0)
        {
            contact = new UserCredentials(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
        }
        else
        {
            Log.e("Inventory DB","Inventory database fields read issue");
        }
        return contact;
    }

    public UserCredentials getCredentialsByName(String name, String password)
    {
        UserCredentials contact = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, new String[]
                        { FIELD_1, FIELD_2, FIELD_3, FIELD_4 }, FIELD_2 + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        else{
            Log.e("Inventory DB","Inventory database error of cursor");
        }
        Log.d("Inventory DB count",String.valueOf(cursor.getCount()));

        if(cursor.getCount() > 0)
        {
             contact = new UserCredentials(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
        }
        return contact;
    }

    /**
     * getAllCredentials
     */
    public List<UserCredentials> getAllCredentials()
    {
        List<UserCredentials> contactList = new ArrayList<UserCredentials>();
        String selectQuery = "SELECT  * FROM " + DICTIONARY_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do {
                UserCredentials contact = new UserCredentials();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1),cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    /**
     * updateContact
     * @param contact
     */
    public int updateContact(UserCredentials contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIELD_2, contact.getName());
        values.put(FIELD_3, contact.getPassword());

        // updating row
        return db.update(DICTIONARY_TABLE_NAME, values, FIELD_1 + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    /**
     * deleteContact
     * @param contact
     */
    public void deleteContact(UserCredentials contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DICTIONARY_TABLE_NAME, FIELD_1 + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

    /**
     * getContactsCount
     */
    public int getContactsCount()
    {
        String countQuery = "SELECT  * FROM " + DICTIONARY_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public void initializeDefaultDataBase()
    {
        onDropTable();
        UserCredentials user1 = new UserCredentials(0,"stas.savinov","123456","admin");
        addUser(user1);
        UserCredentials user2 = new UserCredentials(1,"tester.tester","123456","user");
        addUser(user2);
    }

    public void typeAllDataBaseCredentials()
    {
        List<UserCredentials> contacts = getAllCredentials();
        for (UserCredentials cn : contacts)
        {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Pwd: " + cn.getPassword();
            Log.d("Name: ", log);
        }
    }
}