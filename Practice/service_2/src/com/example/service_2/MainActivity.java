package com.example.service_2;
/**
 * 2014Äê11ÔÂ7ÈÕ13:21:43
 * what is the boundservice and how to use?
 * 1: you must implement a iboundler for services
 * 2: you must return the boundler(onbind)
 * 3: you must know what the bindservice of parameter
 * */
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;

public class MainActivity extends Activity {
	private ServiceConnection mConn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			// TODO Auto-generated method stub
			((ServeService.Myservice)arg1).getServeService().hello_name("ccc");
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent _Intent = new Intent(MainActivity.this,ServeService.class);	
		
		bindService(_Intent, mConn, Service.BIND_AUTO_CREATE);
	}

	

}
