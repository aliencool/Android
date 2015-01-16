package com.example.android_graph;
/**
 * 2014Äê11ÔÂ21ÈÕ16:41:34 
 * SildingDrawer
 * */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Toast;

public class SlidingDrawer_activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sildingactivity);
		
		SlidingDrawer _Drawer = (SlidingDrawer)findViewById(R.id.slidingDrawer1);
		_Drawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {
			
			@Override
			public void onDrawerClosed() {
				// TODO Auto-generated method stub
				Toast.makeText(SlidingDrawer_activity.this, "close", 3000).show();
			}
		});
		
		_Drawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {
	

			@Override
			public void onDrawerOpened() {
				// TODO Auto-generated method stub
				Toast.makeText(SlidingDrawer_activity.this, "Open", 3000).show();
			}
		});
	}
	
	
		
	

}
