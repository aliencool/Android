package com.example.sqlite_01;
/**
 *  I learned SQLiteOpenHelper on oct 4 2014
 * */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	
	/**
	 * @author Think
	 * @Time  Oct 4 2014
	 * @param context:it's enviroment
	 * @param name:it's table name
	 * @param factory:it's null
	 * @param version:it's version
	 * */
	private static final int VERSION=1;
	private static final String STR_TABLE = "student";
	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, STR_TABLE, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	/**
	 * it's the first to use for creating the table
	 * this is a callback method
	 */
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		Log.v("This is the first to creating the database",1+"");
		arg0.execSQL("create table usert(id int primary key,name varchar not null);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		System.out.print("Upgrade");
	}

}
