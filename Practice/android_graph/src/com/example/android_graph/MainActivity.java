package com.example.android_graph;
/**
 *  2014年11月13日15:18:39 
 *  UI 
 *  1:View
 * */
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/**
		 *  动态添加：
		LinearLayout _Layout = new LinearLayout(this);
		_Layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
		Button _Btn = new Button(this);
		_Btn.setText("Test1");
		_Btn.setWidth(100);
		_Btn.setHeight(100);
		
		_Layout.addView(_Btn);
		*/
//		View1 _V = new View1(this);
//		_V.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, "1111", 1000).show();
//			}
//		});
		
//		TextView _TextView = new TextView(this);
//		_TextView.setText(Html.fromHtml("<b>Hello</b></p><b>World</b>"));
//		
//		setContentView(_TextView);
		
//		TextView _TextView = new TextView(this);
//		
//		//new create _Builder
//		SpannableStringBuilder _Builder = new SpannableStringBuilder("#大家好#,#我是第一个TEXTVIEW");
//		//set style of span
//		ImageSpan _ImageSpan = new ImageSpan(this,R.drawable.ic_launcher);
//		_Builder.setSpan(_ImageSpan, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		ClickableSpan _ClickableSpan = new ClickableSpan() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, "您刚才点击了我", 300).show();
//			}
//		};
//		_Builder.setSpan(_ClickableSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//		
//		_TextView.setText(_Builder);	
//		
//		setContentView(_TextView);
		
		setContentView(R.layout.activity_main);
		
//		ToggleButton _ToggleButton = (ToggleButton)findViewById(R.id.toggle);
//		_ToggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
//				// TODO Auto-generated method stub
//				if(arg1 == true)
//				{
//					
//					Toast.makeText(MainActivity.this, "开", 30).show();	
//				}
//			}
//		});
		
//		RadioGroup _Group = (RadioGroup)findViewById(R.id.radioGroup1);
//		
//		_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(RadioGroup arg0, int arg1) {
//				// TODO Auto-generated method stub
//				switch(arg1)
//				{
//				case R.id.radio0:
//					RadioButton _RButton = (RadioButton)findViewById(arg0.getCheckedRadioButtonId());
//					Drawable _Drawable = (Drawable)getResources().getDrawable(android.R.drawable.star_big_on);
//					_Drawable.setBounds(0, 0, _Drawable.getMinimumWidth(), _Drawable.getMinimumHeight());
//					_RButton.setCompoundDrawables(_Drawable, null, null, null);
//					Toast.makeText(MainActivity.this,arg1, 30).show();
//					break;
//				case R.id.radio1:
//					Toast.makeText(MainActivity.this,arg1, 30).show();
//					break;	
//				}
//			}
//		});
//		
		//This is first Spinner of Adapter
		//create data-resources
//		String[] _Sdata = (String[])getResources().getStringArray(R.array.array);
		//connect between data and Spinner-data 
//		ArrayAdapter<String> _ArrayAda = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _Sdata);
		//set spinner
//		Spinner _Spinner = (Spinner)findViewById(R.id.spinner1);
//		_Spinner.setAdapter(_ArrayAda);
		
//		_Spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			/**
			arg0 equal parent
			arg1 is to click the control
			arg2 is a control's position
			arg3 is a  identity 
			*/
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				if(!((TextView)arg1).getText().equals("choice"))
//				Toast.makeText(MainActivity.this, ((TextView)arg1).getText()+(arg2+""), 2000).show();
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		
//		});
		
		
		
		//This is Second Spinner of Adapter
//		UserBean _UserBean1 = new UserBean("哈哈","哈哈");
//		UserBean _UserBean2 = new UserBean("哈哈","哈哈");
//		UserBean _UserBean3 = new UserBean("哈哈","哈哈");
//		UserBean _UserBean4 = new UserBean("哈哈","哈哈");
//		List<UserBean> _lUser = new ArrayList<UserBean>();
//		
//		_lUser.add(_UserBean1);
//		_lUser.add(_UserBean2);
//		_lUser.add(_UserBean3);
//		_lUser.add(_UserBean4);
//		//connect between data and Spinner-data 
//		MyAdapter<UserBean> _MyAdapter = new MyAdapter<UserBean>(this, _lUser);
//		//set spinner
//		Spinner _Spinner = (Spinner)findViewById(R.id.spinner1);
//		_Spinner.setAdapter(_MyAdapter);
//		
//		
//		_Spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//			/**
//			arg0 equal parent
//			arg1 is to click the control
//			arg2 is a control's position
//			arg3 is a  identity 
//			*/
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1,
//					int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, ((TextView)(arg1.findViewById(R.id.textView1))).getText()+(arg2+""), 2000).show();
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		
//		});
		
//		SeekBar _SeekBar = (SeekBar)findViewById(R.id.seekBar1);
//		_SeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
//			
//			@Override
//			public void onStopTrackingTouch(SeekBar arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this,"start"+ arg0.getProgress(), 3000).show();
//			}
//			
//			@Override
//			public void onStartTrackingTouch(SeekBar arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this,"stop"+ arg0.getProgress(), 3000).show();
//			}
//			//arg0 :
//			//arg1 :change values
//			//arg2 :the user clicks
//			@Override
//			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this,"change"+ arg0.getProgress() +"--" + arg1, 3000).show();
//			}
//		});
		
//		RatingBar _RatingBar = (RatingBar)findViewById(R.id.ratingBar1);
//		_RatingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
//			
//			@Override
//			public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this,"change"+ arg0.getProgress() +"--" + arg1, 3000).show();
//			}
//		});
		
		EditText _EditText = (EditText)findViewById(R.id.editText1);
		_EditText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
				Log.i("Hello", ""+arg2.getAction());
				Log.i("Hello", arg1+"");
				return false;
			}
		});
		
		
		
		
	}

	

}
