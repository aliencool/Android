package com.example.contentprovidertest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelperA extends SQLiteOpenHelper{
	private static final int VERSION = 1;

	public DBhelperA(Context context, String name) {
		super(context, name, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		// TODO Auto-generated method stub
		//create tables
		System.out.println("create tables");
		sqLiteDatabase.execSQL("create table student(id integer primary key autoincrement," +
				"name varchar(60) not null);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
