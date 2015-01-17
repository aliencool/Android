package com.aaassistant;

import utility.RegexTool;
import com.aaassistant.adapter.AppendGridView;
import com.aaassistant.adapter.AppendUserListView;
import com.aaassistant.base.ActivityFrame;
import com.aaassistant.bean.BeanUser;
import com.aaassistant.business.BusinessUser;
import com.aaassistant.R;
import control.SlideMenuView.OnSlideMenuListener;
import controlbase.SlideMenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AccountActivity extends ActivityFrame implements OnSlideMenuListener{
	private ListView mListView;
	private AppendUserListView mAppendUserListView;
	private BusinessUser mBusinessUser;
	private String mtitle;
	private EditText mEditText;
	private View mView;
	private BeanUser mBeanUser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addMainLayout(R.layout.assistant_user_activity);
		initVariable();
		initView();
		bindData();
		initListener();
		createSlideMeny(R.array.assistant_user_function_name);
	}

	private void initVariable()
	{
		mBusinessUser = new BusinessUser(this);
		mListView = (ListView)findViewById(R.id.userListView);
	}
	
	private void initView()
	{
		
	}

	private void bindData() {
		// TODO Auto-generated method stub
		mAppendUserListView = new AppendUserListView(null,this);
		mListView.setAdapter(mAppendUserListView);
	}
	
	private void initListener()
	{
		registerForContextMenu(mListView);
	}

	@Override
	public void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem) {
		// TODO Auto-generated method stub
		if( pSlideMenuItem.getmSlideId() == 0)
		{
			showDialogForUser(null);
		}
		else
		{
			showMessage("Opening");
		}
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		AdapterContextMenuInfo _AdapterContextMenuInfo = (AdapterContextMenuInfo)menuInfo;
		ListAdapter _ListAdapter = mListView.getAdapter();
		
		mBeanUser = (BeanUser) _ListAdapter.getItem(_AdapterContextMenuInfo.position);
		
		menu.setHeaderTitle(mBeanUser.getUserName());
		menu.setHeaderIcon(R.drawable.user_big_icon);
		
		CreateMenu(menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		SlideMenuToggle();
		switch(item.getItemId())
		{
			case 1:
				showDialogForUser(mBeanUser);
				break;
			case 2:
				CreateAlertDialogForDelete(mBusinessUser,mBeanUser,new clickListenerForDelete());
				break;
		}
		
		
		return super.onContextItemSelected(item);
	}
	
	
	
	public void showDialogForUser(BeanUser mBeanUser)
	{
		
		if(mBeanUser == null)
		{
				mtitle = this.getResources().getStringArray(R.array.assistant_user_function_name)[0];
		}
		else
		{
			   mtitle = this.getResources().getStringArray(R.array.assistant_user_function_name)[1];
		}
		
		mView = getView(R.layout.assistant_user_add_or_edit);
		mEditText = (EditText) mView.findViewById(R.id.etUserName);
		
		AlertDialog _AlertDialog = new   AlertDialog.Builder(this)
										.setView(mView)
										.setTitle(mtitle).setIcon(R.drawable.user_big_icon)
										.setNegativeButton("Cancel", new DialogListener(mBeanUser,false,mEditText))
										.setPositiveButton("Save", new DialogListener(mBeanUser,true,mEditText))
										.show();
	}
	
	class DialogListener implements DialogInterface.OnClickListener
	{
		private BeanUser mBeanUser;
		private boolean  mIsSave = true;
		private EditText mEditText;
		
		public DialogListener(BeanUser mBeanUser, boolean mIsSave,
				EditText mEditText) {
			super();
			this.mBeanUser = mBeanUser;
			this.mIsSave = mIsSave;
			this.mEditText = mEditText;
		}

		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			
			//mIsSave is canceled to indicate to close
			if(mIsSave == false)
			{
				openOrCloseDialog(arg0, true);
				return;
			}
			
			if( mBeanUser == null)
			{
				mBeanUser = new BeanUser();
			}
			
			String inputMessage = mEditText.getText().toString().trim();
			
			if( !RegexTool.matchName(inputMessage) )
			{
				showMessage("Error!Please,Check!");
				openOrCloseDialog(arg0, false);
				return;
			}
			
			
			
			if( mBusinessUser.IsExistUserByUserName(inputMessage, mBeanUser.getUserID()) )
			{
				showMessage("Repeat!Please,Check!");
				openOrCloseDialog(arg0, false);
				return;
			}
			mBeanUser.setUserName(inputMessage);
			
			boolean _Flag;
			//0:indicate to be updated
			if(mBeanUser.getUserID() == 0)
			{
				_Flag = mBusinessUser.InsertUser(mBeanUser);
			}
			else
			{
				_Flag = mBusinessUser.UpdateUserByUserID(mBeanUser);
			}
			
			if(_Flag)
			{
				bindData();
				return;
			}
			else
			{
				showMessage("Sorry,can't save");
			}
			
		}
		
	}
	

	
	private class clickListenerForDelete implements DialogInterface.OnClickListener
	{

		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			mBusinessUser.HideUserByUserID(mBeanUser.getUserID());
			showMessage("Success");
			bindData();
		}
		
	}

}
