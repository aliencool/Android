package com.example.android_graph;
/**
 * 2014Äê11ÔÂ14ÈÕ14:16:59 
 * Drawable: simplify its canvas
 * */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class View3 extends View{
		private BitmapDrawable mB;
		
	
	
		public View3(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mB = (BitmapDrawable)context.getResources().getDrawable(R.drawable.ic_launcher);
		//set its boundary
		mB.setBounds(12,33, 50, 60);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		mB.draw(canvas);
		
		}
	
	

}
