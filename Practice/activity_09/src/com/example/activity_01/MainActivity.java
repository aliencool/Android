package com.example.activity_01;
/**
 * I learned a seventh class of android
 * Kernel:
 * 1:I learned  How the Progress was used 
 * 
 * Remember:
 * 1:must set visibility
 * 2:The style don't need android prefix
 * 3:need prefix "progress"
 */
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.DialogInterface;



/**
 * @time:Aug thirty-First 14
 * @author chaochencai
 * my first used android development
 * */

public class MainActivity extends Activity {
	private ProgressBar mHorizotalProgress;
	private ProgressBar mBaseProgress;
	private Button bt;
	//set the progress value
	private int mFlag=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//stepThis is first to execute
		setContentView(R.layout.activity_main);
		
		//step 1:set filed
		mHorizotalProgress=(ProgressBar)findViewById(R.id.Horizontal);
		mBaseProgress=(ProgressBar)findViewById(R.id.BaseStyle);
		bt=(Button)findViewById(R.id.Btn);
		
		//step 2:click event
		bt.setOnClickListener(new MyBtnClickListen());
	}
	
	class MyBtnClickListen implements OnClickListener
	{

		@Override
		public void onClick(View arg0)
		{
			// TODO Auto-generated method stub
			if(mFlag == 0)
			{
				mHorizotalProgress.setVisibility(View.VISIBLE);
				mBaseProgress.setVisibility(View.VISIBLE);
			}
			else if(mFlag < mHorizotalProgress.getMax())
			{
				mHorizotalProgress.setProgress(mFlag);
				mHorizotalProgress.setSecondaryProgress(mFlag+20);
			}
			else
			{
				mHorizotalProgress.setVisibility(View.GONE);
				mBaseProgress.setVisibility(View.GONE);
				mFlag = 0;
			}
			
			mFlag=mFlag+10;
			
		}

		
		
	}
	


}
