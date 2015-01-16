package com.example.dialogautocompletetest;
/**
 * sept 16 2014
 *  DatePickerDialog notice:
 *  1: onCreateDialog is parent's method;
 *  2: return (this,listener,year,month,day);
 * */
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.Menu;
import android.widget.DatePicker;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		showDialog(1);
	}
	
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		return new DatePickerDialog(this,mDateSetListener,2014,1,1);
	}


	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			System.out.println(arg1 +" "+ arg2+" "+ arg3);
		}
		
		
		
	}; 

	
}
