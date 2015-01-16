package com.example.animationtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView mImageView;
	private Button mButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mImageView = (ImageView)findViewById(R.id.image);
		mButton = (Button)findViewById(R.id.btn);
		
		mButton.setOnClickListener(new clicklistener());
	}

	class clicklistener implements OnClickListener
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			AnimationSet _Set = new AnimationSet(true);
			
			//gradual
			AlphaAnimation _AlphaAnimation = new AlphaAnimation(1, 0);
			//rotate
			RotateAnimation _RotateAnimation = new RotateAnimation(0, 180,
					Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
			//scale
			ScaleAnimation _ScaleAnimation = new ScaleAnimation(1.0F, 0.1F, 1.0F, 0.1F, 
									Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
			//Translate
			TranslateAnimation _TranslateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 1F, Animation.RELATIVE_TO_PARENT, 0.5F);
			
			
			
			
			_Set.setDuration(1000);
			
			_Set.addAnimation(_TranslateAnimation);
			
			mImageView.setAnimation(_Set);
			
		}
		
	}

}
