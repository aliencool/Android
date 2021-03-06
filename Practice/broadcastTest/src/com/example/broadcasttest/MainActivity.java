package com.example.broadcasttest;
/**
 * Two ways realize the broadcast function
 * 1 : set the androidMainifest
 * 2 : weave codes in the class 
 * */

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mBtn;
	private Button mCancelBtn;
	private ReceiverClass mReceiverClass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		
		mBtn = (Button)findViewById(R.id.btn);
		mCancelBtn =  (Button)findViewById(R.id.cancelbtn);
		
//		mBtn.setOnClickListener(new OnClickListener()
//		{
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				// produce intents
//				Intent _Intent = new Intent();
//				
//				_Intent.setAction("android.intent.action.EDIT");
//				
//				MainActivity.this.sendBroadcast(_Intent);				
//			}
//			
//		});
		
		mBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// create BroadcastReceivers
				mReceiverClass = new ReceiverClass();
				// create IntentFilters
				IntentFilter _IntentFilter = new IntentFilter();
				_IntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
				
				MainActivity.this.registerReceiver(mReceiverClass, _IntentFilter);
			}
			
		});
		
		//unregister
		mCancelBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				MainActivity.this.unregisterReceiver(mReceiverClass);
			}
			
		});
		
		
	}


}
