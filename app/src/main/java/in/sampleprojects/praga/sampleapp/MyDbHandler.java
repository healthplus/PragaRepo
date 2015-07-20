package in.sampleprojects.praga.sampleapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;


/**
 * Created by praga on 7/18/2015.
 */

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sampleDB.db";
    public static final String USERS_REGISTERED = "users_master";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";


    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + USERS_REGISTERED + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_REGISTERED);
        onCreate(db);
    }

    //Add a new user to the database
    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, user.get_useremail());
        values.put(COLUMN_PASSWORD, user.get_userpwd());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(USERS_REGISTERED, null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteProduct(String useremail){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + USERS_REGISTERED + " WHERE " + COLUMN_EMAIL + "=\"" + useremail + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + USERS_REGISTERED + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("email")) != null) {
                dbString += c.getString(c.getColumnIndex("email"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
