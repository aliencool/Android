package com.example.autocompletetest;
/**
 *  sept 16 2014
 *  I learn how to use of AutoCompleteText
 * */
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	private AutoCompleteTextView mAutoCompleteTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoComplete);
		
		List<CharSequence> _list = new ArrayList<CharSequence>();		
		_list.add("bbb1");
		_list.add("bbb2");
		_list.add("bbb3");
		_list.add("bbb4");
		_list.add("bbb5");
		
		ArrayAdapter<CharSequence> _Adapter = 
				new ArrayAdapter<CharSequence>(this, R.layout.theotheractivity, R.id.mytestview1,_list);
		mAutoCompleteTextView.setAdapter(_Adapter);
		
		
	}


}
