package com.example.sqlite_01;
/**
 *  I learned SQLiteOpenHelper on oct 4 2014
 *  This is to show to user
 * */
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.app.ListActivity;


public class MainActivity extends Activity {
	private Button mBtnUda;
	private Button mBtnSel;
	private Button mBtnDel;
	private Button mBtnIns;
	
	private ListView mLis;
	private DBManage mDBManage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mDBManage = new DBManage(this, "usert", 3);
		
		mBtnUda = (Button)findViewById(R.id.btnUdate);
		mBtnSel = (Button)findViewById(R.id.btnSelect);
		mBtnDel = (Button)findViewById(R.id.btnDelete);
		mBtnIns = (Button)findViewById(R.id.btnInsert);
		
		mLis = (ListView)findViewById(R.id.list);
		
		
		
		mBtnIns.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				mDBManage.onInsert();
			}
			
		});
		
		mBtnDel.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				PersonFiled _PersonFiled = new PersonFiled();
				_PersonFiled.setmPid(1);
				
				mDBManage.onDelete(_PersonFiled);
			}
			
		});
		
		mBtnUda.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				mDBManage.onUpdate();
			}
			
		});
		
		//Show data into View 
		SimpleAdapter _Adapter = new SimpleAdapter(this,mDBManage.onSelect(null) , 
				R.layout.showinlistviews, new String[]{"id","name"}, new int[]{R.id.id,R.id.name});
		 
		 mLis.setAdapter(_Adapter);		
	}



}
