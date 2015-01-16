package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receive_B extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
			
			Log.i("Hello", arg1.getAction());
		
	}

}
