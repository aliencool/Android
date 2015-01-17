package com.aaassistant.adapter;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aaassistant.adapter.base.AdapterBase;
import com.aaassistant.bean.BeanUser;
import com.aaassistant.business.BusinessUser;
import com.aaassistant.business.BusinessAccount;
import com.aaassistant.R;

import controlbase.SlideMenuItem;

public class AppendAccountListView extends AdapterBase {	
	class SaveMsg
	{
		ImageView mIcon;
		TextView mName;
		TextView mTotal;
		TextView mMoney;
	}

	public AppendAccountListView(List mList, Context mContext) {
		super(mList, mContext);
		// TODO Auto-generated constructor stub
//		BusinessUser _BusinessUser =new BusinessUser(mContext);
//		List _List =_BusinessUser.GetNotHideUser();
//		setList(_List);
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		SaveMsg _SaveMsg = null;
		if( arg1 == null )
		{
			arg1 = getView(R.layout.account_book_list_item);
			
			_SaveMsg = new SaveMsg();
			_SaveMsg.mIcon = (ImageView)arg1.findViewById(R.id.ivAccountBookIcon);
			_SaveMsg.mName = (TextView)arg1.findViewById(R.id.tvAccountBookName);
			_SaveMsg.mTotal = (TextView)arg1.findViewById(R.id.tvTotal);
			_SaveMsg.mMoney = (TextView)arg1.findViewById(R.id.tvMoney);
			arg1.setTag(_SaveMsg);
		}else
		{
			_SaveMsg = (SaveMsg)arg1.getTag();
		}
		
		BusinessAccount _AccountBook = (BusinessAccount)getItem(arg0);
		if(_AccountBook.GetIsDefault() == 1)
		{
			_SaveMsg.mIcon.setImageResource(R.drawable.account_book_default);
		}
		else {
			_SaveMsg.mIcon.setImageResource(R.drawable.account_book_big_icon);
		}
		


		return arg1;
	}

}
