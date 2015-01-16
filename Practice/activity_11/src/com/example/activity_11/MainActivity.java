package com.example.activity_11;
/**
 * Oct third 14
 * I learned HandlerThread that was used,Because if the handler have much responsibility,the
 * activity will be stopped,So we  create the HandlerThread to solve problems!
 * 
 * Step 1:create HandleThread and start it
 * step 2:give HandleThread's Looper to the other activity of entending Handler 
 * Step 3:Who to create Message that was used by handler
 */
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.app.Activity;
import android.content.res.Configuration;

public class MainActivity extends Activity {
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
			Log.i("LANDSCAPE", "LANDSCAPE");
		}
		else
		{
			Log.i("LANDSCAPE", "OTHER");
			
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		Log.v("ThreadId", Thread.currentThread().getId()+"");
		setContentView(R.layout.activity_main);
		
		//Step 1:  create HandlerThread for the other Handler
		HandlerThread _HandlerThread=new HandlerThread("Provide Looper");
		//Step 2:  The kernel is to start
		_HandlerThread.start();
		//Step 3:  create new class to extend Handler and its construction will be Looper
		MyNewHandle _MyNewHandle = new MyNewHandle(_HandlerThread.getLooper());
		//Step 4:  get a Message for MyNewHandle to used
		Message _Message = _MyNewHandle.obtainMessage();
		
		
		Bundle _Bundle = new Bundle();
		_Bundle.putString("1", "2");
		_Bundle.putChar("2", '2');
		
		_Message.setData(_Bundle);
		_Message.sendToTarget();
		
			
	}

    class MyNewHandle extends Handler
    {
    	MyNewHandle()
    	{
    		
    	}
    	
    	MyNewHandle(Looper looper)
    	{
    		super(looper);
    	}

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			
			Log.v("Bundle",msg.getData().getString("1"));
			Log.v("ThreadId", Thread.currentThread().getId()+"");
		}
    	
    }

}
