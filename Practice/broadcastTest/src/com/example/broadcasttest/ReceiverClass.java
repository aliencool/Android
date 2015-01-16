package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReceiverClass extends BroadcastReceiver{
	//The function of onReceive was finished, it was dead!
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		System.out.println("I am listen to the Broadcast");
	}

}
