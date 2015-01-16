package com.example.activity_01;
/**
 * I learned a third class of android
 * Kernel:
 * How to use do activity to calculate and learned component
 * 1:getText().String
 * 2:The menu is different,It was for two step  
 *        First:onCreatOptionMenu
 *        Second:onOptionalSelected
 */
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
/**
 * @time:Aug twenty-ninth 14
 * @author chaochencai
 * my first used android development
 * */

public class MainActivity extends Activity {
	private EditText mEditText;
	private EditText mEditText1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//septThis is first to execute
		setContentView(R.layout.activity_main);
		//achieved button,edit and textview
		Button _button = (Button)findViewById(R.id.mybutton);
		TextView _textView = (TextView)findViewById(R.id.mytestview);
		TextView _textView2 = (TextView)findViewById(R.id.mytestview1);
		
		mEditText = (EditText)findViewById(R.id.myedit);
		mEditText1 = (EditText)findViewById(R.id.myedit1);
		
		//set both of text
		_button.setText("Calulate");
		_textView.setText("First Number");
		_textView2.setText("SecondNumber");
		//step 4:binding a to click
		_button.setOnClickListener(new MyButtonClick());
	}
	
	/**
	 * menu was learned 
	 * @author Think
	 * */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0,1,1,"¹ØÓÚ");
		menu.add(0,2,2,"ÍË³ö");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId()==2)
		{
			finish();
		}
		
		return super.onOptionsItemSelected(item);
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
			_intent.putExtra("first",mEditText.getText().toString());
			_intent.putExtra("second",mEditText1.getText().toString());
			
			//step 3:started activitys
			startActivity(_intent);
		}
    	
    }
	

}
