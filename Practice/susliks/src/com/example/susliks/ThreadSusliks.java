package com.example.susliks;

import java.util.Random;

import android.os.Handler;
import android.os.Message;

public class ThreadSusliks extends Thread {
	private Handler mHandler;
	//get location length for location
	private int mWidth;
	private int mHeight;
	
	private SusliksVo mSusliksVo;
	
	//Random location
	private Random mRandom = new Random();



	public ThreadSusliks(Handler mHandler, int mWidth, int mHeight) {
		super();
		this.mHandler = mHandler;
		this.mWidth = mWidth;
		this.mHeight = mHeight;
		mSusliksVo = new SusliksVo();
	}







	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			
			int _PositionX = mRandom.nextInt(mWidth);
			int _PositionY = mRandom.nextInt(mHeight);
			// equal mWidth to try again
			while(_PositionX + 69 > mWidth && _PositionY + 78 > mHeight)
			{
				_PositionX = mRandom.nextInt(mWidth);
				_PositionY = mRandom.nextInt(mHeight);
				
				System.out.println(_PositionX+" "+_PositionX);
			}
			
			
			//set location
			mSusliksVo.setmX(_PositionX);
			mSusliksVo.setmY(_PositionY);
			//send
			Message _Message = mHandler.obtainMessage();
			
			_Message.obj = mSusliksVo;
			
			
			mHandler.sendMessage(_Message);
			
			//wait for minute
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
