package com.example.android_graph;
/**
 * 2014Äê11ÔÂ21ÈÕ15:42:33 
 * study expandablelistactivity 
 * */
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpConnection;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class ExpandActivity_list extends ExpandableListActivity{

	//click child
	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		return super.onChildClick(parent, v, groupPosition, childPosition, id);
	
	}
	
	//collapse
	@Override
	public void onGroupCollapse(int groupPosition) {
		// TODO Auto-generated method stub
		super.onGroupCollapse(groupPosition);
		Toast.makeText(this, "C:"+groupPosition, 3000).show();
	}
	
	//expand
	@Override
	public void onGroupExpand(int groupPosition) {
		// TODO Auto-generated method stub
		super.onGroupExpand(groupPosition);
		Toast.makeText(this, "E:"+groupPosition, 3000).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//parent source
		List<HashMap<String,String>> _Parent = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> _PMap = new HashMap<String, String>();
		_PMap.put("GROUP", "GROUP1");
		_Parent.add(_PMap);
		
		_PMap = new HashMap<String, String>();
		_PMap.put("GROUP", "GROUP2");
		_Parent.add(_PMap);
		
		_PMap = new HashMap<String, String>();
		_PMap.put("GROUP", "GROUP3");
		_Parent.add(_PMap);
		
		//child source
		List<List<HashMap<String,String>>> _Child  = new  ArrayList<List<HashMap<String,String>>>();
		
		List<HashMap<String,String>> _ChildItem1 = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> _CMap = new HashMap<String, String>();
		_CMap.put("child", "child1");
		_ChildItem1.add(_CMap);
		
		_CMap = new HashMap<String, String>();
		_CMap.put("child", "child2");
		_ChildItem1.add(_CMap);
		
		
		_CMap = new HashMap<String, String>();
		_CMap.put("child", "child3");
		_ChildItem1.add(_CMap);
		
		_Child.add(_ChildItem1);//corresponding parent1
		_Child.add(_ChildItem1);//corresponding parent2
		_Child.add(_ChildItem1);//corresponding parent3
		
		SimpleExpandableListAdapter _Adapter = new SimpleExpandableListAdapter(this, _Parent, android.R.layout.simple_expandable_list_item_1,
				android.R.layout.simple_expandable_list_item_1, new String[]{"GROUP"}, new int[]{android.R.id.text1}, 
				_Child, android.R.layout.simple_expandable_list_item_2, new String[]{"child"}, new int[]{android.R.id.text1});
		
		
		//set adapter
		setListAdapter(_Adapter);
		
	}
	
	
}
