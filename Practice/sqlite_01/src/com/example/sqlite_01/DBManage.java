package com.example.sqlite_01;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author Think
 * @time oct 4 2014
 * This manage the SQLite
 * */
public class DBManage {
	private Context mContext;
	private String mTableName;
	private int mVersion;
	private DBHelper mDBHelper;
	private SQLiteDatabase mSqLiteDatabase;
	
	public DBManage(Context mContext, String mTableName, int mVersion) {
		super();
		this.mContext = mContext;
		this.mTableName = mTableName;
		this.mVersion = mVersion;
		
		mDBHelper = new DBHelper(mContext, mTableName, null, mVersion);
		
		mSqLiteDatabase = mDBHelper.getReadableDatabase();
		
	}
	
	public void onInsert()
	{
		System.out.println("Insert");
		
		ContentValues _ContentValues = new ContentValues();
		_ContentValues.put("id", 1);
		_ContentValues.put("name", "Liming");
		
		mSqLiteDatabase.insert("usert", null, _ContentValues);
	}
	
	public ArrayList<HashMap<String, String>> onSelect(PersonFiled personFiled)
	{
		System.out.println("Select");
		
		Cursor _Cursor = mSqLiteDatabase.query("usert", null, null, null,null, null,null);
		
		//get value to put the arraylist!
		ArrayList<HashMap<String, String>> _ArrayList = new ArrayList<HashMap<String, String>>();
		
		
		//Warning: must new a HashMap and add
		while(_Cursor.moveToNext())
		{
			HashMap<String, String> _HashMap = new HashMap<String, String>();
			
			_HashMap.put("id", _Cursor.getInt(_Cursor.getColumnIndex("id"))+"");
			
			_HashMap.put("name", _Cursor.getString(_Cursor.getColumnIndex("name")));
			
			_ArrayList.add(_HashMap);
		}
		
	     
	     
	     return _ArrayList;
	    
	}
	
	public void onUpdate()
	{
		System.out.println("Update");
		
		ContentValues _ContentValues = new ContentValues();
		_ContentValues.put("id", 2);
		_ContentValues.put("name", "XiaoWang");
		
		mSqLiteDatabase.update("usert", _ContentValues, "id=?",new String[]{"1"});
		
	}
	
	public void onDelete(PersonFiled personFiled)
	{
		System.out.println("Delete");
		
		mSqLiteDatabase.delete("usert", "id=?",new String[]{personFiled.getmPid()+""});
	}
	
	
	
}
