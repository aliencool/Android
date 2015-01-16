package com.example.android.activity.lanunch.test;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

public class Appwidget_Configuration extends Activity {
	private int mId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appwidget_configurations);
		Button _Button = (Button)findViewById(R.id.btn2);
		//get appwidget-id
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null) {
		    mId = extras.getInt(
		            AppWidgetManager.EXTRA_APPWIDGET_ID, 
		            AppWidgetManager.INVALID_APPWIDGET_ID);
		}

		
		
		Log.i("Hello", "id:"+mId);
		_Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		
				
				//get appwidgetManager
				AppWidgetManager _AppWidgetManager =AppWidgetManager.getInstance(Appwidget_Configuration.this);
				
				//update
				RemoteViews _Views = new RemoteViews(getPackageName(), R.layout.appwidget_layout);
				_Views.setTextViewText(R.id.btn, "hahahsfsw");
				_AppWidgetManager.updateAppWidget(mId, _Views);
				
				//Intent
				Intent _Intent = new Intent();
				_Intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mId);
				
				setResult(RESULT_OK, _Intent);
			}
		});
	}
	
}
