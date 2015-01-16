package com.example.contentprovidertest;
/**
 * 	 STP 9 2014
 *   Today , I learn one of four android's  elements to be the contentprovider
 *   1:what is the content provider?
 *   The content provider will support the application's data to others android's application
 *   
 *   
 *   2:Many content providers in the android system is how to differentiate?
 *     we can use the uri to differentiate and have many datas in the content provider that we 
 *     can use the urimacher that to differentiate  is single or multiple!
 *     /# match integer numbers
 *     /* match strings
 *     
 *   3:Operation step:
 *   step 1: you must register the content provider in our main.xml (android:name and android:authorities)
 *   step 2: you must remember the style of uri ,that is very important
 *   step 3: you must create the urimatcher to match the data which is single or multiple
 *   step 4: just like before i used the sqlhelper as well
 * */


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	//define a contentResolvers 
	private ContentResolver mContentResolver;
	//define a Uri
	private Uri mUri;
	private Button mBtnUda;
	private Button mBtnSel;
	private Button mBtnDel;
	private Button mBtnIns;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// this is the content providers
		mContentResolver = getContentResolver();
		
		
		mBtnUda = (Button)findViewById(R.id.btnUdate);
		mBtnSel = (Button)findViewById(R.id.btnSelect);
		mBtnDel = (Button)findViewById(R.id.btnDelete);
		mBtnIns = (Button)findViewById(R.id.btnInsert);
		
		
		mBtnIns.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mUri = Uri.parse("content://com.example.contentprovidertest.ContentProviderB/student");
				ContentValues _ContentValues = new ContentValues();
				
				_ContentValues.put("name", "zhangsan");
				_ContentValues.put("name", "Lisi");
				
				mContentResolver.insert(mUri, _ContentValues);
			}
			
		});
		
		mBtnDel.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			
			}
			
		});
		
		mBtnUda.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				
			}
			
		});
		
		mBtnSel.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mUri = Uri.parse("content://com.example.contentprovidertest.ContentProviderB/student/1");
				Cursor _Cursor = mContentResolver.query(mUri, null, null, null, null);
				
				while(_Cursor.moveToNext())
				{
					System.out.println("name"+"--->"+_Cursor.getString(_Cursor.getColumnIndex("name")));
				}
				
			}
			
		});
		
	
	}
}
	
