package com.example.sqlite2;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Sqlite_Helper _Helper = new Sqlite_Helper(this);
		//insert
		UserInfo _Info = new UserInfo();
		_Info.setmUserName("CCC");
		_Info.setmUserAddress("CHINA");
		
		_Helper.insertUserInf(_Info);
		
		//update
		_Info.setmUserName("DDD");
		_Info.setmUserAddress("CHINA");
		_Helper.updateUserInfro(_Info);
		
		Cursor _Cursor = _Helper.selectUserInf();
		
		while( _Cursor.moveToNext())
		{
			Log.i("Hello", _Cursor.getString(0));
			Log.i("Hello", _Cursor.getString(1));
			Log.i("Hello", _Cursor.getString(2));
		}
		
		//delete
		_Helper.deleteUserInfro();
		
		_Cursor = _Helper.selectUserInf();
		
		while( _Cursor.moveToNext())
		{
			Log.i("Hello", _Cursor.getString(0));
			Log.i("Hello", _Cursor.getString(1));
			Log.i("Hello", _Cursor.getString(2));
		}
		
		_Helper.close();
		
	}

	

}
