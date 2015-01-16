package com.example.contentprovider;
/**
 *  2014Äê11ÔÂ11ÈÕ15:07:25
 *  1: why does the contentprovide need the uri?
 *     1:The client  transport the uri to be single ,For distinguishing the command to be single or multiple
 *     2:The app has many contentprovider
 *  2: gettype()
 *     1:for the intent-filter start the activity 
 * */
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;



public class ContentProvider_Test extends android.content.ContentProvider {
	//the default is no match
	private static UriMatcher mUr = new UriMatcher(UriMatcher.NO_MATCH); 
	//single
	private final static int MSTUDENT = 1;
	//multiple
	private final static int MSTUDENTS = 2;
	//register
	static
	{
		mUr.addURI("com.example.contentprovider", "student/#", MSTUDENT);
		mUr.addURI("com.example.contentprovider", "student", MSTUDENTS);
	}
	
	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		int _Flag = mUr.match(arg0);
		
		switch (_Flag) {
		case MSTUDENT:
			return "vnd.android.cursor.item/student";
		case MSTUDENTS:
			return "vnd.android.cursor.dir/student";
//		default:
//			throw new IllegalArgumentException("Not was the uri" + uri.toString());
		}
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		// TODO Auto-generated method stub
		int _Flag = mUr.match(arg0);
		
		switch(_Flag)
		{
			case MSTUDENT:
				int _Id = (int) ContentUris.parseId(arg0);
				return null;
		
		}
		
		
		
		
		
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
