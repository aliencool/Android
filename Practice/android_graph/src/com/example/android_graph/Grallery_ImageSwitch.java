package com.example.android_graph;
/**
 * 2014Äê11ÔÂ21ÈÕ21:03:26
 * grallery imageSwith
 * */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class Grallery_ImageSwitch extends Activity implements ViewFactory{
	private final int [] IMG_LIST = {
			R.drawable.u1,
			R.drawable.u2,
			R.drawable.u3,
			R.drawable.u4,
			R.drawable.u5,
			R.drawable.u6
	};
	private int mindex = 0;
	private ImageSwitcher mSwitcher;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery_imageswitch);
		Gallery _Gallery =(Gallery)findViewById(R.id.gallery1);
		
		 mSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
		//important factory
		mSwitcher.setFactory(this);
		mSwitcher.setImageResource(IMG_LIST[mindex]);
		
		
		_Gallery.setAdapter(new Image_Adapte());
		_Gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(Grallery_ImageSwitch.this, ""+arg3, 300).show();
				mSwitcher.setImageResource(IMG_LIST[arg2]);
			}
		});
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
				ImageView _ImageView = new ImageView(Grallery_ImageSwitch.this);
				_ImageView.setImageResource(IMG_LIST[arg0]);
				return _ImageView;
			}
			
		}
	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		return new ImageView(this);
	}
	
}
