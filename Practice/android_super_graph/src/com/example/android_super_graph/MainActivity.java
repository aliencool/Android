package com.example.android_super_graph;
/**
 * 2014Äê12ÔÂ1ÈÕ14:08:20
 * change skins
 * */
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mButton_Red;
	private Button mButton_Green;
	private int mLayOut_Id = 0;
	private static final String FLAG="LayOut_id";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent _Intent = getIntent();
		if(_Intent != null)
		{
			int mId = _Intent.getIntExtra(FLAG, 0);
			Log.i("Hello", FLAG+":eeeeeeeeeeeeeeeeeeeeee");
			if( mId != 0)
			{
				Log.i("Hello", mId+":eeeeeeeeeeeeeeeeeeeeee");
				setTheme(mId);
			}
		}
		
		setContentView(R.layout.activity_main);
		mButton_Red = (Button)findViewById(R.id.button1);
		mButton_Green = (Button)findViewById(R.id.button2);
		
		
		mButton_Red.setOnClickListener(new OnThemeChoice(R.style.MyColorRed));
		mButton_Green.setOnClickListener(new OnThemeChoice(R.style.MyColorGreen));
		
	}
	
	class OnThemeChoice implements OnClickListener
	{
		private int mLayout_Id;
		
		public OnThemeChoice(int Layout_Id)
		{
//			Log.i("Hello", Layout_Id+"Layout_Id");
			this.mLayout_Id = Layout_Id;
//			Log.i("Hello", mLayout_Id+"mLayout_Id");
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MainActivity.this,MainActivity.class);
//			Log.i("Hello", mLayout_Id+"mLayout_Id");
			intent.putExtra(FLAG, mLayOut_Id);
			startActivity(intent);
			//close this
			finish();
			
		}}

	
}
