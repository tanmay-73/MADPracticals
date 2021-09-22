package com.example.practical8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper
{
    private static String key_name="name";
    private static String key_email="email";
    private static String key_table="user_table";

    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME
                + " TEXT, " + Params.KEY_PHONE + " TEXT" + ")";
        Log.d("Practical8", "Query being run is : "+ create);
        db.execSQL(create);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, contact.getName());
        values.put(Params.KEY_PHONE, contact.getNum());
        db.insert(Params.TABLE_NAME, null, values);
        Log.d("Practical8", "Successfully inserted");
        db.close();
    }
    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setid(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setNum(cursor.getString(2));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }
}
