package com.example.activity_01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
/**
 * Aug 28 14
 * @author Think
 *
 */


public class TheOtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Remember this,Because it is important that it would haven't started
		setContentView(R.layout.theotheractivity);
		
		TextView _textView=(TextView)findViewById(R.id.mytestview2);
		
		//The first number was added 
		String value=getIntent().getStringExtra("first");
		//The Second number was added 
		String value1=getIntent().getStringExtra("second");
		
		//To add
		
		_textView.setText(Integer.parseInt(value)+Integer.parseInt(value1)+"");
		
		
		
	}
	
}
