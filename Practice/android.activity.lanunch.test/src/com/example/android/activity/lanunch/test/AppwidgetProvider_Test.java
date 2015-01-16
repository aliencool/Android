package com.example.android.activity.lanunch.test;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViews.RemoteView;

public class AppwidgetProvider_Test extends AppWidgetProvider{

	//deleting invoke
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		Log.i("Hello", "Delete");
	}
	
	//the last of appwidget was invoke by deleting
	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
		Log.i("Hello", "Disabled");
	}
	
	//the first of appwidget was invoke by adding
	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		Log.i("Hello", "Enabled");
	}
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		Log.i("Hello", "Receive");
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);

		for(int i = 0;i < appWidgetIds.length;i++)
		{
			Log.i("Hello", context.getPackageName());
			RemoteViews _Views = new RemoteViews(context.getPackageName(), R.layout.appwidget_layout);
			
			
			Intent _intent = new Intent(context, Appwidget_Test.class);
			PendingIntent _Pintent = PendingIntent.getActivity(context, 0, _intent, 0);
			
			_Views.setOnClickPendingIntent(R.id.btn, _Pintent);
			
			appWidgetManager.updateAppWidget(appWidgetIds[i], _Views);
			
		}
	}
	
}
