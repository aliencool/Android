package com.example.contentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ContentResolver _Cr = getContentResolver();
		
		Uri _Ur = Uri.parse("content://com.example.contentprovider/student/");
		
		
	}


}
