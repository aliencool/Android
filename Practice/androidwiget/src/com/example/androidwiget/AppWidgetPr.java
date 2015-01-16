package com.example.androidwiget;
// Septmber 18 2014
/**
 * This is to learn How to use of AppWidget 
 * There was three steps!(essential)
 * 1: you must have xml file(create in the res)
 * 2: you must override AppWidgetProvider (There was four functions to include 
 * 	1: your first invoke the AppWidgetProvider  
 * 	2: your first update the AppwidgetProvider
 *  3: you invoke to delete the AppwidgetProvider
 *  4: you invoke all to delete the AppwidgetProvider
 * )
 * 3:  you must lay out android_main  to set our appwidgetprovider
 * 4:  you must have this that was showed screen of xml
 * */
import java.util.Collection;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class AppWidgetPr extends AppWidgetProvider{
	
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		System.out.println("delete");
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		System.out.println("disable");
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		System.out.println("enable");
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("recevie");
		super.onReceive(context, intent);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		System.out.println("update");
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
	
}
