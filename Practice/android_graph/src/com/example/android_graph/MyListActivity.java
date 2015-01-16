package com.example.android_graph;
/**
 * 2014年11月20日22:43:06
 * practise the listview
 * */
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Adapter;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListActivity extends ListActivity{
	private EditText mEditText;
	private List<String> _Ldata;
	private ArrayAdapter<String> _Adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		registerForContextMenu(getListView());
		mEditText = (EditText)findViewById(R.id.editTextlist);
		_Ldata = new ArrayList<String>();
		_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,_Ldata);
		setListAdapter(_Adapter);
		
		mEditText.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
				if(arg2.getKeyCode() == KeyEvent.KEYCODE_ENTER && arg2.getAction() ==KeyEvent.ACTION_UP)
				{
					_Ldata.add(((TextView)arg0).getText().toString());
					mEditText.setText("");
					_Adapter.notifyDataSetChanged();
				}
				
				return false;
			}
		});
		
		
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		AlertDialog _AlertDialog =new AlertDialog.Builder(this).setSingleChoiceItems(getResources().getStringArray(R.array.array), 1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MyListActivity.this, ""+arg1,300).show();
			}
		}).setIcon(R.drawable.ic_launcher)
				.setNegativeButton("取消", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						arg0.dismiss();
					}
				})
				.setPositiveButton("确定", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				}).show();
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AdapterContextMenuInfo _Info = (AdapterContextMenuInfo)item.getMenuInfo();
		Toast.makeText(this, _Info.position+"..", 3000).show();
		return super.onContextItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		Log.i("Hello", "23");
		getMenuInflater().inflate(R.menu.menu_bg, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	
	
	
	
}
