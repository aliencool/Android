package com.example.android_graph;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

/**
 * 	2014Äê11ÔÂ21ÈÕ19:01:20
 *  TabHost
 * */
public class TabHostActivity_test extends TabActivity implements OnTabChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//GetHost
		TabHost _TabHost = getTabHost();
		//Sec
		TabSpec _Spec = _TabHost.newTabSpec("Tab1").setIndicator("Tab1", 
					getResources().getDrawable(android.R.drawable.ic_dialog_email)).setContent(new Intent(this,ExpandActivity_list.class));
		
		//add
		_TabHost.addTab(_Spec);

		//Sec
		TabSpec _Spec1 = _TabHost.newTabSpec("Tab2").setIndicator("Tab2", 
					getResources().getDrawable(android.R.drawable.ic_dialog_info)).setContent(new Intent(this,SlidingDrawer_activity.class));
				
		//add
		_TabHost.addTab(_Spec1);
		
	}

	@Override
	public void onTabChanged(String arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arg0, 3000).show();
	}
	
}
