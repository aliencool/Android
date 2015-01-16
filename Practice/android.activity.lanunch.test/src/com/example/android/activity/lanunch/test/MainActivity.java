package com.example.android.activity.lanunch.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent _Intent = new Intent();
		_Intent.setAction("android.intent.action.CREATE_SHORTCUT");
		_Intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Myshortcut");
		_Intent.putExtra(Intent.EXTRA_SHORTCUT_ICON,Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher));
		_Intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,new Intent(this,MainActivity.class));
		sendBroadcast(_Intent);
	}



}
