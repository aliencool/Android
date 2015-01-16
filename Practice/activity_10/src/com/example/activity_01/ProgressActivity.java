package com.example.activity_01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressActivity extends Activity {

	private Button mButton;
	private ProgressBar mProgressBar;
	
	private int mFlag=0;
	
	private Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg) 
		{
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			
			
			
			mProgressBar.setProgress(msg.arg1);
			
			mHandler.post(mRunnable);
			
		}
		
	};
	
	
	private Runnable mRunnable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Message _Message = mHandler.obtainMessage();
			
			mFlag = mFlag + 10;
			
			_Message.arg1=mFlag;
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mHandler.sendMessage(_Message);
			
			if(mFlag == 200)
			{
				mHandler.removeCallbacks(mRunnable);
			}
			
			
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.theotheractivity);
		
		mButton = (Button)findViewById(R.id.start);
		
		mProgressBar = (ProgressBar)findViewById(R.id.progress);
		
		
		
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//put handler
				mHandler.post(mRunnable);
				mProgressBar.setVisibility(View.VISIBLE);
			
			}
		});
	}
	
	
}
