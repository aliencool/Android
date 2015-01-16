package com.example.activity_01;
/**
 * I learned a seventh class of android
 * Kernel:
 * 1:I learned  How the ListView was used
 * 
 * Remember:
 * 1:need two xmls,one is listviews,the other is to show value 
 * 2:SimpleAdapter param
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
/**
 * @time Aug thirty-First 14
 * @author Think
 *
 */


public class TheOtherActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//step 1 :set everything filed
		setContentView(R.layout.theotheractivity);
		
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		HashMap<String, String> hashMap3 = new HashMap<String, String>();
		
		hashMap.put("Name", "Li");
		hashMap.put("Ip", "192.168.0.1");
		
		hashMap2.put("Name", "Wang");
		hashMap2.put("Ip", "192.168.0.2");
		
		hashMap3.put("Name", "Zhang");
		hashMap3.put("Ip", "192.168.0.3");
		
		arrayList.add(hashMap);
		arrayList.add(hashMap2);
		arrayList.add(hashMap3);
		
		//step 2:Set Adapters
		SimpleAdapter adapter=new SimpleAdapter(this, arrayList, R.layout.showinlistviews,
				new String[]{"Name","Ip"},new int[]{R.id.Name,R.id.Ip} );
		
		setListAdapter(adapter);
		
	}

	

	
}
