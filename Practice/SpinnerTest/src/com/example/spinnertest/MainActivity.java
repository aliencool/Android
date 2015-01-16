package com.example.spinnertest;
/**
 *  Sept 16 2914
 *  I learned how to use which is a Spinner!
 *  
 *   it have two function for filling the data
 *   1:String-array
 *   2:arrayAdapter
 * */
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private Spinner mSpinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSpinner = (Spinner)findViewById(R.id.mySpinner);
		
		ArrayAdapter<CharSequence> _ArrayAdapter;
		
		//1
		List<CharSequence> _list = new ArrayList<CharSequence>();		
		_list.add("b1");
		_list.add("b2");
		_list.add("b3");
		_list.add("b4");
		_list.add("b5");
		
		_ArrayAdapter = new ArrayAdapter<CharSequence>(this, R.layout.theotheractivity,R.id.mytestview1, _list);
		
		
		
		//2
	
		
//		_ArrayAdapter = ArrayAdapter.createFromResource(this, R.array.First_Fill,
//			android.R.layout.simple_spinner_item);
//		
//		_ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(_ArrayAdapter);
		
		mSpinner.setOnItemSelectedListener(new SpinnerListener());
		
	}
	
	class SpinnerListener implements OnItemSelectedListener
	{
		//2:it is position
		//3: it is a identification
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String _Sp_Name = arg0.getItemAtPosition(arg2).toString();
			
			System.out.println(_Sp_Name + "   "  + arg3);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	

}
