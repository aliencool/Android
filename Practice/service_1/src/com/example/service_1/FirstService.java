package com.example.service_1;
/**
 *  2014Äê11ÔÂ5ÈÕ21:34:24
 *  What is the service's lifecycle?
 *  1:startService
 *         oncreate ---- onstartcommand ---- ondestory
 *  2:BindService
 *         oncreate ---- onbind ---- onunbind ---- ondestory
 * */
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service{

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
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					Log.i("chaochen", String.valueOf(i));
				}
			}
		}).start();
		
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}
	
	
	

}
