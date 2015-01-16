package com.example.android_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class View1 extends View{

	public View1(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint _Paint = new Paint();
		_Paint.setColor(Color.RED);
		
		canvas.drawRect(60,70, 60, 70, _Paint);
		
		
		
	}
	
	

}
