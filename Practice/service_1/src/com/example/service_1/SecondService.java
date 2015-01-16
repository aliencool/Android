package com.example.service_1;
/**
 *  2014Äê11ÔÂ5ÈÕ21:34:24
 *  What is the Intentservice?
 *  The oncreate have created a handleThread
 * */
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class SecondService extends IntentService{

	
	public SecondService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public SecondService() {
		super("hello");
		// TODO Auto-generated constructor stub
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
	
		
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
	
		for (int i = 0; i < 10; i++) {
			Log.i("chaochen", String.valueOf(i));
		}
	}
	
	
	

}
