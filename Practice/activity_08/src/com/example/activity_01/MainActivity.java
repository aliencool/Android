package com.example.activity_01;
/**
 * I learned a sixth class of android
 * Kernel:
 * 1:I learned  How the RadioGroup and checkbox was used 
 */
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
/**
 * @time:Aug thirty 14
 * @author chaochencai
 * my first used android development
 * */

public class MainActivity extends Activity {
	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton1;
	private RadioButton mRadioButton2;
	private CheckBox mSwim;
	private CheckBox mPiano;
	private CheckBox mBasketBall;
	private CheckBox mEnglish;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		//step This is first to execute
		setContentView(R.layout.activity_main);
	    
		//step 1:set every one to controls
		mRadioGroup=(RadioGroup)findViewById(R.id.radiogroup);
		mRadioButton1=(RadioButton)findViewById(R.id.radio1);
		mRadioButton2=(RadioButton)findViewById(R.id.radio2);
		
		mBasketBall=(CheckBox)findViewById(R.id.basketballs);
		mPiano=(CheckBox)findViewById(R.id.piano);
		mSwim=(CheckBox)findViewById(R.id.swim);
		mEnglish=(CheckBox)findViewById(R.id.english);
		
		//step 2:set listen 
		mRadioGroup.setOnCheckedChangeListener(new MyRadioGroup());
		
		mBasketBall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(arg1)
				{
					System.out.println("BasketBall is checked");
				}
				else
				{
					System.out.println("BasketBall is unchecked");
				}
			}
		});
	}
	
	//listen
	class MyRadioGroup implements RadioGroup.OnCheckedChangeListener
	{

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			if(mRadioButton1.getId()==arg1)
			{
				Toast.makeText(MainActivity.this, "male", Toast.LENGTH_LONG).show();
			}else
			{
				Toast.makeText(MainActivity.this, "fmale", Toast.LENGTH_LONG).show();
			}
		}
		
	}
	


}
