package com.example.android_graph;
/**
 * 2014年11月22日23:01:20
 * notificatio 
 * */
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

public class Notification_Test extends Activity {
	private NotificationManager mManager; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//NotificationManager
		mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//Notification
		Notification _Notification = new Notification(R.drawable.ic_launcher, "您有一条小心", System.currentTimeMillis());
		PendingIntent _Intent = PendingIntent.getActivity(this, 0, new Intent(this,SlidingDrawer_activity.class), 0);
//		_Notification.setLatestEventInfo(this, "新消息", "genius or idiot", _Intent);
		
		
//		RemoteViews _Views = new RemoteViews(getPackageName(), R.layout.myadaptercontrol);
		_Notification.contentView = new RemoteViews(getPackageName(), R.layout.myadaptercontrol);
		_Notification.contentIntent = _Intent;
		
		//notify
		mManager.notify(2332, _Notification);
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		mManager.cancel(2332);
		super.onStop();
	}
	
}
