package com.example.activity_01;
/**
 * I learned a first class of android
 * Kernel:
 * How to create activity
 * 1:extend activity
 * 2:override oncreate(this is first to excute)
 * 3:delopy layout and androidmainifest
 */
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
/**
 * @time:Aug twenty-eighth 14
 * @author chaochencai
 * my first used android development
 * */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//This is first to excute
		setContentView(R.layout.activity_main);
		//achieved button and textview
		Button _button=(Button)findViewById(R.id.mytestbutton);
		TextView _textView=(TextView)findViewById(R.id.mytestview);
		//set both of text
		_button.setText("FirstButton");
		_textView.setText("FirstTextView");
	}

	

}
