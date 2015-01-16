package com.example.androidwiget2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

public class AppwidgetT extends AppWidgetProvider{

	

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if( intent.getAction().equals("com.myandroid.myappwidget"))
		{
			System.out.println("com.myandroid.myappwidget");
		}
		
		super.onReceive(context, intent);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// circulate
		for (int i = 0; i < appWidgetIds.length; i++) {
			//generate the intent
			Intent _Intent = new Intent();
			_Intent.setAction("com.myandroid.myappwidget");
			//generate the PendIntent
			PendingIntent _PendingIntent = PendingIntent.getBroadcast(context, 0, _Intent, 0);
			//generate the remote view
			RemoteViews _RemoteViews = new RemoteViews(context.getPackageName(), R.layout.appwidgetlayout);
			//set on clicks
			_RemoteViews.setOnClickPendingIntent(R.id.btn, _PendingIntent);
			//update 
			appWidgetManager.updateAppWidget(appWidgetIds[i], _RemoteViews);
		}
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
}
