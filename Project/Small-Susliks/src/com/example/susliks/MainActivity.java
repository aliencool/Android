package com.example.susliks;
/**
 * step 5 14
 *  I made my first project that is hit susliks
 *  
 *  step 1:
 *         ImageViews must be proficiency
 *  step 2:
 *   	   What is OnTouch ? it is different from Onclick ?
 *   		Look at:http://blog.csdn.net/guolin_blog/article/details/9097463
 * */
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity { 
	
	private TextView mTextView;
	private ImageView mImageView_1;
	private ImageView mImageView_2;
	//hit susliks count
	private int mCount = 0;
	//handle susliks
	private Handler mHandler_1 = new Handler(){

		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@SuppressLint("NewApi")
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			//get location
			SusliksVo _Index = (SusliksVo)msg.obj;
			//set
			
			mImageView_1.setX(_Index.getmX());
			mImageView_1.setY(_Index.getmY());
			
			mImageView_1.setVisibility(View.VISIBLE);
		}
		
	};
	
	private Handler mHandler_2 = new Handler(){

		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@SuppressLint("NewApi")
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			//get location
			SusliksVo _Index = (SusliksVo)msg.obj;
			//set
			
			mImageView_2.setX(_Index.getmX());
			mImageView_2.setY(_Index.getmY());
			
			mImageView_2.setVisibility(View.VISIBLE);
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get location
		WindowManager _WindowManager = getWindowManager();
		Display _Display = _WindowManager.getDefaultDisplay();
		
		int _Width = _Display.getWidth();
		int _Height = _Display.getHeight();
		
		mImageView_1 = (ImageView)findViewById(R.id.susliks_1);
		mImageView_2 = (ImageView)findViewById(R.id.susliks_2);
		mTextView = (TextView)findViewById(R.id.score);
		
		//initialization
		mTextView.setText(":X"+mCount);
		
		
		mImageView_1.setOnTouchListener(new OnTouchListener()
		{
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				
				mImageView_1.setVisibility(View.GONE);
				
				//set Count
				mCount++;
				
				mTextView.setText(":X"+mCount);
				
				return false;
			}
			
		});
		
		mImageView_2.setOnTouchListener(new OnTouchListener()
		{
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				
				mImageView_2.setVisibility(View.GONE);
				
				//set Count
				mCount++;
				
				mTextView.setText(":X"+mCount);
				
				return false;
			}
			
		});
		
		new ThreadSusliks(mHandler_1, _Width,_Height).start();
		new ThreadSusliks(mHandler_2, _Width,_Height).start();
	}

	

}
