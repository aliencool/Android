package com.example.activity_01;
/**
 * I learned a fifth class of android
 * Kernel:
 * 1:I learned  How the Tablelayout was used 
 */
import android.app.Activity;
import android.os.Bundle;
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
	
		
		
	}
	
}
