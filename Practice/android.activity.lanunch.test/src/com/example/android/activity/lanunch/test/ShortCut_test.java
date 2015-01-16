package com.example.android.activity.lanunch.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 	2014Äê11ÔÂ24ÈÕ15:39:30
 *  shortcut
 * */
public class ShortCut_test extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i("Hello", getIntent().getAction());
		//Intent 
		Intent _Intent = new Intent();
		_Intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Myshortcut");
		_Intent.putExtra(Intent.EXTRA_SHORTCUT_ICON,Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher));
		_Intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,new Intent(this,MainActivity.class));
		setResult(RESULT_OK, _Intent);
	}
	
}
