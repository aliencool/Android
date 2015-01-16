package com.example.expandablelistarraytest;
/**
 *  September 16 2014
 *  I learn how to use of expandablelistarray
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends ExpandableListActivity {
	private ExpandableListView mExpandableListActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mExpandableListActivity = (ExpandableListView)findViewById(android.R.id.list);
		
		// Parents of the data
		List<Map<String,String>> _PList = new ArrayList<Map<String,String>>();
		
		Map<String,String> _Map1 = new HashMap<String, String>();
		_Map1.put("group","group1");
		
		Map<String,String> _Map2 = new HashMap<String, String>();
		_Map2.put("group","group2");
		
		Map<String,String> _Map3 = new HashMap<String, String>();
		_Map3.put("group","group3");
		
		_PList.add(_Map1);
		_PList.add(_Map2);
		_PList.add(_Map3);
		
		// children of the data
		List<Map<String,String>> _CList = new ArrayList<Map<String,String>>();
		
		Map<String,String> _CMap1 = new HashMap<String, String>();
		_CMap1.put("child","child1");
		Map<String,String> _CMap2 = new HashMap<String, String>();
		_CMap2.put("child","child2");
		_CList.add(_CMap1);
		_CList.add(_CMap2);
		
		List<Map<String,String>> _CList2 = new ArrayList<Map<String,String>>();
		Map<String,String> _CMap3 = new HashMap<String, String>();
		_CMap3.put("child","child11");
		_CList2.add(_CMap3);
		
		List<Map<String,String>> _CList3 = new ArrayList<Map<String,String>>();
		
		Map<String,String> _CMap4 = new HashMap<String, String>();
		_CMap4.put("child","child44");
		
		_CList3.add(_CMap4);
		
		// All of children
		
		List<List<Map<String,String>>> _AllList = new ArrayList<List<Map<String,String>>>();
		_AllList.add(_CList);
		_AllList.add(_CList2);
		_AllList.add(_CList3);
		
		SimpleExpandableListAdapter _Adapter = new SimpleExpandableListAdapter(this,_PList, R.layout.master, new String[]{"group"}, new int[]{R.id.master}, 
											_AllList, R.layout.child, new String[]{"child"}, new int[]{R.id.child});
		
		mExpandableListActivity.setAdapter(_Adapter);
	}

}
