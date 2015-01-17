package com.aaassistant.business;

import java.util.Date;

public class BusinessAccount {
	//ID
	private int mAccountBookID;
	//Name
	private String mAccountBookName;
	//Date
	private Date mCreateDate = new Date();
	//flag 0:invalid 1:start
	private int mState = 1;
	//Default 0:No 1:Yes
	private int mIsDefault;
	
	public int GetAccountBookID() {
		return mAccountBookID;
	}
	
	public void SetAccountBookID(int pAccountBookID) {
		this.mAccountBookID = pAccountBookID;
	}
	
	public String GetAccountBookName() {
		return mAccountBookName;
	}
	
	public void SetAccountBookName(String pAccountBookName) {
		this.mAccountBookName = pAccountBookName;
	}
	
	public Date GetCreateDate() {
		return mCreateDate;
	}
	/**
	 * Ìí¼ÓÈÕÆÚ
	 */
	public void SetCreateDate(Date pCreateDate) {
		this.mCreateDate = pCreateDate;
	}
	
	public int GetState() {
		return mState;
	}

	public void SetState(int pState) {
		this.mState = pState;
	}
	
	public int GetIsDefault() {
		return mIsDefault;
	}

	public void SetIsDefault(int pIsDefault) {
		this.mIsDefault = pIsDefault;
	}
}
