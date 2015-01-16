package com.example.android.activity.lanunch.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.LiveFolders;
import android.util.Log;

public class LiveFolder_test extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Intent 
		Intent _Intent = new Intent();
		
		_Intent.setData(People.CONTENT_URI);
		_Intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_DISPLAY_MODE, LiveFolders.DISPLAY_MODE_LIST);
		_Intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_NAME, "MyLiveFolder");
		_Intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_ICON,Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher));
		_Intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_BASE_INTENT,new Intent(this,MainActivity.class));
		setResult(RESULT_OK, _Intent);
	}
	
}
