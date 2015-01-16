package com.example.activity_01;
/**
 * I learned a seventh class of android
 * Kernel:
 * 1:I learned  How the Handle and Message were used 
 * 
 */
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.DialogInterface;



/**
 * @time:Aug thirty-Second 14
 * @author chaochencai
 * my first used android development
 * */

public class MainActivity extends Activity {
	private ProgressBar mHorizotalProgress;
	private Button mBt;
	private Button mBtCancel;
	//set the progress value
    private int mFlag=0;
    //new handler
	private Handler mHandler=new Handler();
	//even
	private Runnable mRunnable=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			Log.v("it was clicked","www");
			
			
			//step 2:delayed to add 
			mHandler.postDelayed(mRunnable, 3000);
			
			
			
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//stepThis is first to execute
		setContentView(R.layout.activity_main);
		
		
		
		mBt=(Button)findViewById(R.id.Btn);
		
		mBtCancel=(Button)findViewById(R.id.cancel);
		
		//click event
		mBt.setOnClickListener(new MyBtnClickListen());
		
		mBtCancel.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mHandler.removeCallbacks(mRunnable);
			}
			
		});
		
	}
	
	class MyBtnClickListen implements OnClickListener
	{

		@Override
		public void onClick(View arg0)
		{
			
			
			
			//Step 1:add runnables
			mHandler.post(mRunnable);
		}
	}
	


}
