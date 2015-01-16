package com.example.share_preference_xml;
/***
 *  2014Äê11ÔÂ9ÈÕ10:08:06 
 *  I learn the share_preference
 *  Step:
 *   	1:getpreference
 *   	2:edit
 *   	3:commit
 *   The share_preference is XML's DB, It is always to use to set the system configuration
 * */
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//1:create     auto to create
		SharedPreferences _Sp = getSharedPreferences("CCC", MODE_PRIVATE);
		
		if( _Sp !=null  )
		{
			Log.i("Hello", _Sp.getString("CCCC", "1"));
		}
		//2:edit
		SharedPreferences.Editor _Se = _Sp.edit();
		_Se.putString("CCCC", "1");
		_Se.putString("AAAA", "2");
		
		//3: commit
		_Se.commit();
		
		
		
		
		
	}

	

}
