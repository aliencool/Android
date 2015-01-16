package com.example.android_super_graph;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class AndroidFrameAction  extends Activity{
	private Button mBtn;
	private ImageView mView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frameanimation_test);
		
		mBtn = (Button)findViewById(R.id.action);
		mView = (ImageView)findViewById(R.id.imageViewActio);
		mBtn.setOnClickListener(new OnClickListener() {
		    @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mView.setBackgroundResource(R.drawable.framedrawable);
				AnimationDrawable _Animation = (AnimationDrawable) mView.getBackground();
				_Animation.setOneShot(false);
				_Animation.start();
			}
		});
	}
}
