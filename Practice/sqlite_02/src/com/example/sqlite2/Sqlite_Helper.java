package com.example.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
/**
 *  2014Äê11ÔÂ10ÈÕ13:32:42
 *  Create a helper for sqlite3
 *  
 *  Warning:
 *  1: movetonext 
 * */


public class Sqlite_Helper {
	private SQLiteDatabase mSqLiteDatabase;
	private String TABLE_NAME = "USERINF";
	public String COLUMN_USERNAME = "USERNAME";
	public String COLUMN_ADDRESS  = "USERADDRESS";
	
	public Sqlite_Helper(Context context)
	{
		//1:create the sqlitedatabase
		mSqLiteDatabase = context.openOrCreateDatabase(TABLE_NAME, Context.MODE_PRIVATE, null);
		
		//2: judge for existing table_name
		String _Table = mSqLiteDatabase.findEditTable(TABLE_NAME);
		
		if( _Table ==null || _Table.equals(""))
		{
			
			//3: create the table 
			mSqLiteDatabase.execSQL("create table "+TABLE_NAME+"(_id integer primary key AUTOINCREMENT,"
					+COLUMN_USERNAME+" varchar(20) NOT NULL,"+COLUMN_ADDRESS+" varchar(20) NOT NULL);");
		}
	}
	
	public long insertUserInf(UserInfo userInfo)
	{
		ContentValues _CValues = new ContentValues();
		_CValues.put(COLUMN_USERNAME, userInfo.getmUserName());
		_CValues.put(COLUMN_ADDRESS, userInfo.getmUserAddress());
		
		return mSqLiteDatabase.insert(TABLE_NAME, null, _CValues);
	}
	
	
	public Cursor selectUserInf()
	{
		return mSqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
	}
	
	public Cursor selectConditionUserInf(int id,String name)
	{
		return mSqLiteDatabase.query(TABLE_NAME, null, "_id=? and "+COLUMN_USERNAME+" =?", new String[]{"1",name}, null, null, null);
	}
	
	public void updateUserInfro(UserInfo userInfo)
	{
		ContentValues _CValues = new ContentValues();
		_CValues.put(COLUMN_USERNAME, userInfo.getmUserName());
		_CValues.put(COLUMN_ADDRESS, userInfo.getmUserAddress());
		
		mSqLiteDatabase.update(TABLE_NAME, _CValues, "_id=?", new String[]{"2"});
	}
	
	
	public void deleteUserInfro()
	{	
		mSqLiteDatabase.delete(TABLE_NAME, "_id=?", new String[]{"2"});
	}
	
	public void close()
	{
		mSqLiteDatabase.close();
	}
	
	
	
	

}
