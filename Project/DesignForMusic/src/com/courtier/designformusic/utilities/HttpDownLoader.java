package com.courtier.designformusic.utilities;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * 这个类主要是用于下载远程服务器端的类。
 * Created by Think on 2015/3/12.
 */
public class HttpDownLoader extends AsyncTask<String, Integer, Long> {
	private Handler mHandler = null;
	private String mUrl = null;
	private int mWhat = 0;
	
	public HttpDownLoader(Handler handler, String url, int what) {
		mHandler = handler;
		mUrl = url;
		mWhat = what;
	}
	
	@Override
	protected Long doInBackground(String... params) {
		OutputStream output = null;
		try {
			URL url = new URL(mUrl);
			// 创建一个HttpURLConnection连接  
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			InputStream input = urlConn.getInputStream();
			//文件夹
			File dir = new File(VariableStatic.LOCATION);  
			if(!dir.exists())
			{
				dir.mkdir();
			}
			//本地文件
			File file = new File(VariableStatic.LOCATION,params[0]);  
			file.createNewFile();  
			//写入本地
			output = new FileOutputStream(file);  
			byte buffer [] = new byte[1024];
			int inputSize = -1;
			while((inputSize = input.read(buffer)) != -1) {
				output.write(buffer, 0, inputSize);
			}
			output.flush();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{  
			try{  
			 if(output != null)
				 {
				 	output.close();
				 }  
			}  
			catch(Exception e){  
				e.printStackTrace();  
			}  
		}
		//发送处理
		if (mHandler != null) {
			sendResponse(mHandler, VariableStatic.LOCATION + File.separator + params[0], mWhat);
		} else {
			Log.w("TAG", "mHandler == null, what = " + mWhat);
		}
		return null;
	}
	/**
	 * @Description:发送消息到主线程
	 * */
	private void sendResponse(Handler mHandler, String path, int mWhat) 
	{
		// TODO Auto-generated method stub
		Message message = new Message();
		Bundle bundle = new Bundle();
		
		bundle.putString("path", path);
		message.setData(bundle);
		message.what = mWhat;
		
		mHandler.sendMessage(message);
	}
	
}

