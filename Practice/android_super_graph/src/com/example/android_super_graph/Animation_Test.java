package com.example.android_super_graph;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Animation_Test extends Activity{
	private Button mAlpaBtn;
	private Button mRotateBtn;
	private Button mTranslateBtn;
	private Button mScaleBtn;
	private Button mComplexBtn;
	private ImageView mImageView;
	private int mFlag = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation_test);
		
		mAlpaBtn = (Button)findViewById(R.id.alpha);
		mRotateBtn = (Button)findViewById(R.id.rotate);
		mScaleBtn = (Button)findViewById(R.id.scale);
		mTranslateBtn = (Button)findViewById(R.id.translate);
		mComplexBtn = (Button)findViewById(R.id.complex);
		mImageView = (ImageView)findViewById(R.id.imageView1);
		
		mAlpaBtn.setOnClickListener(new OnAnimationclick(0));
		mRotateBtn.setOnClickListener(new OnAnimationclick(1));
		mScaleBtn.setOnClickListener(new OnAnimationclick(2));
		mTranslateBtn.setOnClickListener(new OnAnimationclick(3));
		mComplexBtn.setOnClickListener(new OnAnimationclick(4));
	}
	
	class OnAnimationclick implements OnClickListener
	{
		private final int mFlag; 
		public OnAnimationclick(int flag)
		{
			mFlag = flag;
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(mFlag)
			{
			case 0:
				AlphaAnimation _AlphaAnimation = new AlphaAnimation(0, 1.0f);
				_AlphaAnimation.setDuration(300);
				_AlphaAnimation.setRepeatCount(3);
				mImageView.startAnimation(_AlphaAnimation);
				break;
			case 1:
				RotateAnimation _RotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//				_RotateAnimation.setRepeatCount(3);
				_RotateAnimation.setDuration(2000);
				mImageView.startAnimation(_RotateAnimation);
				break;
			case 2:
				Log.i("Hello", ""+mFlag);
				ScaleAnimation _ScaleAnimation = new ScaleAnimation(0f,1f,0f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);  
//				_ScaleAnimation.setRepeatCount(3);
				_ScaleAnimation.setDuration(2000);   
				mImageView.startAnimation(_ScaleAnimation);
				break;
			case 3:
				TranslateAnimation _TranslateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f);
				_TranslateAnimation.setDuration(2000);
//				_TranslateAnimation.setInterpolator()
				mImageView.startAnimation(_TranslateAnimation);
				break;
			default:
				AnimationSet _AnimationSet = new AnimationSet(false);
				ScaleAnimation _ScaleAnimation1 = new ScaleAnimation(0f,1f,0f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);  
				_ScaleAnimation1.setDuration(2000); 
				_AnimationSet.addAnimation(_ScaleAnimation1);
				
				
				AlphaAnimation _AlphaAnimation1 = new AlphaAnimation(0, 1.0f);
				_AlphaAnimation1.setDuration(2000);
				_AlphaAnimation1.setRepeatCount(3);
				_AnimationSet.addAnimation(_AlphaAnimation1);
				
//				Animation _Animation = AnimationUtils.loadAnimation(Animation_Test.this, R.anim.alpha_a);
//				
//				mImageView.startAnimation(_Animation);
				
				mImageView.startAnimation(_AnimationSet);
				break;
			
			}
		}
	}
	
	
}
