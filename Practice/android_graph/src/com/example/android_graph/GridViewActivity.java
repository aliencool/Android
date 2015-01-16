package com.example.android_graph;
/**
 * 2014Äê11ÔÂ21ÈÕ16:08:24
 * GridView
 * */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewActivity extends Activity {
	private final int [] IMG_LIST = {
			android.R.drawable.ic_lock_lock,
			android.R.drawable.alert_dark_frame,
			android.R.drawable.button_onoff_indicator_off,
			android.R.drawable.dialog_holo_light_frame,
			android.R.drawable.ic_dialog_email,
			android.R.drawable.presence_away
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView _GridView = (GridView)findViewById(R.id.gridView1);
		_GridView.setAdapter(new Image_Adapte());
		
	}
	
	//adapter
	class Image_Adapte extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return IMG_LIST.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return IMG_LIST[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView _ImageView = new ImageView(GridViewActivity.this);
			_ImageView.setImageResource(IMG_LIST[arg0]);
			return _ImageView;
		}
		
	}
	
}
