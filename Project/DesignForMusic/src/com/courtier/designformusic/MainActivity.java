package com.courtier.designformusic;


import java.util.ArrayList;

import com.courtier.designformusic.Bean.MusicBean;
import com.courtier.designformusic.utilities.HttpDownLoader;
import com.courtier.designformusic.utilities.VariableStatic;
import com.courtier.designformusic.utilities.XMLParse;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	private Button mButton;
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			Bundle bundle = msg.getData();
			XMLParse parse = new XMLParse();
			try {
				ArrayList<MusicBean> arrayList = parse.getMusicList(bundle.getString("path"));
				for (MusicBean mBean: arrayList)
				{
					Toast.makeText(MainActivity.this, 
							mBean.getId()+"", Toast.LENGTH_LONG).show();
					Toast.makeText(MainActivity.this, mBean.getMp3Name()+"",
							Toast.LENGTH_LONG).show();
					Toast.makeText(MainActivity.this, mBean.getLrcName(), 
							Toast.LENGTH_LONG).show();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.handleMessage(msg);
		}
		
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mButton = (Button)findViewById(R.id.button1);
        
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HttpDownLoader downLoader = new HttpDownLoader(handler, "http://172.16.142.24:8080/MusicServe/MusicList.xml", 0x123);
				downLoader.execute(VariableStatic.MUSICLIST);
			}
		});
    }

    
    
}
