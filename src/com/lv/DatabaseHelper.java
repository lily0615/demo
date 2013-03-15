package com.lv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	static final String dbName="demoDB77";
	static final String name="";
	static final String contactTable="contacts";

	public DatabaseHelper(Context context) {
		super(context, dbName, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+contactTable+" (_id INTEGER PRIMARY KEY AUTOINCREMENT,Pname text not null , Pphone text not null,Pemail text not null,Paddress text not null)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		db.execSQL("DROP TABLE IF EXISTS "+contactTable);
	}
	
	
	 Cursor getAllContacts()
	 {
		 SQLiteDatabase db=this.getWritableDatabase();
		 
		 Cursor cur= db.rawQuery("SELECT * FROM "+contactTable,null);
		 return cur;
		 
	 }
	 
	 void AddContacts(Contacts Con)
		{
			 
		    SQLiteDatabase db= this.getWritableDatabase();
			 
			ContentValues cv=new ContentValues();
			
			cv.put("Pname", Con.get_name());
			cv.put("Pphone", Con.get_phone());
			cv.put("Pemail", Con.get_email());
			cv.put("Paddress", Con.get_address());
			
			db.insert(contactTable, "Pname", cv);


		}
	 
	 int getCount(){
		    SQLiteDatabase db=this.getWritableDatabase();
			Cursor cur= db.rawQuery("Select * from "+contactTable, null);
			int x= cur.getCount();
			return x;
	 }

}
