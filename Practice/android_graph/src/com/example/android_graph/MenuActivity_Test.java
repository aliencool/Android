package com.example.android_graph;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

/**
 * 2014年11月22日17:07:37
 * option menu
 * */
public class MenuActivity_Test extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
//		menu.add(1, 1, 1, "添加");
//		menu.add(1, 2, 2, "删除");
//		menu.add(1, 3, 3, "修改");
//		
//		SubMenu _Menu = menu.addSubMenu("其他");
//		_Menu.add(1, 1, 1, "添加");
//		_Menu.add(1, 2, 2, "删除");
//		_Menu.add(1, 3, 3, "修改");
		Log.i("Hello", "123");
		getMenuInflater().inflate(R.menu.menu_bg, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		Toast.makeText(MenuActivity_Test.this, "GID:"+item.getGroupId()+",IID"+item.getItemId(), 3000).show();
		return super.onOptionsItemSelected(item);
	}
	
	
	
}
