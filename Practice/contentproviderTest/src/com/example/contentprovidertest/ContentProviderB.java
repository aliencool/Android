package com.example.contentprovidertest;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ContentProviderB extends ContentProvider{
	//look at MainActivity
	private static UriMatcher mUriMatcher;
	//Define the item or multiple
	private static final int MSTUDENT = 1;
	private static final int MSTUDENT_MULTIPLE = 2;
	//get SQLiteDataBase
	private SQLiteDatabase mSqLiteDatabase;
	//register the uri
	static
	{
		mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		//add the uri to mach 
		mUriMatcher.addURI("com.example.contentprovidertest.ContentProviderB",
				"student/#", MSTUDENT);
		
		mUriMatcher.addURI("com.example.contentprovidertest.ContentProviderB", "student"
				, MSTUDENT_MULTIPLE);
	}
	
	
	
	
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		//get uri for delete 
		int flag = 0;
		//judge(distinguished)
		switch (mUriMatcher.match(arg0)) 
		{
		case MSTUDENT:
			long _id = ContentUris.parseId(arg0);
			
			String _Where_Value = _id + arg1;
			
			flag = mSqLiteDatabase.delete("student", _Where_Value, arg2);

			break;

		case MSTUDENT_MULTIPLE:
			flag = mSqLiteDatabase.delete("student", arg1, arg2);
			
			break;
		}
		
		
		
		return flag;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		//get uri to match being was single?multiple?
		switch (mUriMatcher.match(uri)) {
		case MSTUDENT:
			return "vnd.android.cursor.item/student";
		case MSTUDENT_MULTIPLE:
			return "vnd.android.cursor.dir/student";
		default:
			throw new IllegalArgumentException("Not was the uri" + uri.toString());
		}
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		System.out.println("Insert");
		//step 1 : judge the uri being single or multiple?
		//get a uri for insert
		Uri uri = null;

		long id = mSqLiteDatabase.insert("student", null, arg1);
		
		if(id > 0)
		{
				uri = ContentUris.withAppendedId(arg0, id);
		}
		
		return uri;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		//get 
		mSqLiteDatabase = new DBhelperA(this.getContext(), "student").getWritableDatabase();
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) 
	{
		// TODO Auto-generated method stub
		
		//define a cursor
		Cursor _Cursor = null;
		//judge 
		switch (mUriMatcher.match(arg0)) 
		{
		case MSTUDENT:
			long _id = ContentUris.parseId(arg0);
			String _Where_Value = "";
			
			if(arg2 != null && arg3.equals(""))
			_Where_Value = _id + arg2;
			
			_Cursor = mSqLiteDatabase.query("student", null, _Where_Value, arg3, null, null, arg4);
		
			break;

		case MSTUDENT_MULTIPLE:
			
			_Cursor = mSqLiteDatabase.query("student", null, arg2, arg3, null, null, null);
			
			break;
		}
		return _Cursor;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		//get uri for delete 
		int flag = 0;
		//judge(distinguished)
		switch (mUriMatcher.match(arg0)) 
		{
		case MSTUDENT:
			long _id = ContentUris.parseId(arg0);
			
			String _Where_Value = _id + arg2;
			
			flag = mSqLiteDatabase.update("student", arg1, _Where_Value, arg3);

			break;

		case MSTUDENT_MULTIPLE:
			flag = mSqLiteDatabase.update("student", arg1, arg2, arg3);
			
			break;
		}
		
		return flag;
	}

}
