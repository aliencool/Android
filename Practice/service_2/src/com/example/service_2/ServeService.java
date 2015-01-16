package com.example.service_2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServeService extends Service{
	//1:implement 
	IBinder mIB = new Myservice();
	//2:create a function
	class Myservice extends Binder
	{
		public ServeService getServeService()
		{
			return ServeService.this;
		}
		
		
		
		public void hello_name(String name)
		{
			for(int i = 0;i < 20;i++)
			Log.i("Hello",name);	
		}
	}
	//3:return a IBinder
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return mIB;
	}
	
	//other
	public void hello_name(String name)
	{
		for(int i = 0;i < 20;i++)
		Log.i("Hello",name);
		
	}

}
