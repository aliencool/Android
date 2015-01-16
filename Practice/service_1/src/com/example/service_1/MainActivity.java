package com.example.service_1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent _intent = new Intent();
		
		_intent.setClass(this, SecondService.class);
		
		startService(_intent);
		

	}


}
