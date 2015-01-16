package com.example.android_graph;
/**
 * 2014Äê11ÔÂ20ÈÕ09:44:50
 * this is myadapter.
 * 
 * */
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter<T> extends BaseAdapter {
	private Context mContext;
	private List<T> mlist;
	
	
	public MyAdapter(Context mContext, List<T> mlist) {
		super();
		this.mContext = mContext;
		this.mlist = mlist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlist.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mlist.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View _View = null;
		//inflate   LayoutInflater
		if(arg1 == null)
		{
			 _View = LayoutInflater.from(mContext).inflate(R.layout.myadaptercontrol, null);
		}
		
		TextView _Tview1 = (TextView)_View.findViewById(R.id.textView1);
		_Tview1.setText(((UserBean)mlist.get(arg0)).getName());
		TextView _Tview2 = (TextView)_View.findViewById(R.id.textView2);
		_Tview2.setText(((UserBean)mlist.get(arg0)).getAddress());
		
		return _View;
	}

}
