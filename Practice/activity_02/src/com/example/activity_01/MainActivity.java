package com.example.activity_01;
/**
 * I learned a Second class of android
 * Kernel:
 * How to use do activity to the other
 * 1:transmit activity
 * 2:what is the intent
 * 3:relationship of activity
 */
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
/**
 * @time:Aug twenty-ninth 14
 * @author chaochencai
 * my first used android development
 * */

public class MainActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int aa;
		super.onCreate(savedInstanceState);
		//step :This is first to execute
		setContentView(R.layout.activity_main);
		//achieved button and textview
		Button _button=(Button)findViewById(R.id.mybutton);
		TextView _textView=(TextView)findViewById(R.id.mytestview);
		//set both of text
		_button.setText("FirstButton");
		_textView.setText("FirstTextView");
		
		//step 4:binding a to click
		_button.setOnClickListener(new MyButtonClick());
	}
	
	/**
	 * @author Think
	 * @used forward to the other
	 */
    class MyButtonClick implements OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//step 1:created a Intent
			Intent _intent = new Intent();
			//step 2:set the other 
			_intent.setClass(MainActivity.this, TheOtherActivity.class);
			
			
			//step other:
			_intent.putExtra("first","a first message of mine");
			
			//step 3:started activitys
			startActivity(_intent);
		}
    	
    }
	

}
