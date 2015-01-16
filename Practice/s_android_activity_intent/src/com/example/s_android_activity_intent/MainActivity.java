package com.example.s_android_activity_intent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mBtn = (Button)findViewById(R.id.btnid);
		
		mBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent _itn = new Intent();
				_itn.setAction(Intent.ACTION_DIAL);
				_itn.setData(Uri.parse("tel:15800025052"));
				startActivity(_itn);
			}});
		
	}



}
