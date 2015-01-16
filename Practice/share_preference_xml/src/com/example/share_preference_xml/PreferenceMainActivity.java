package com.example.share_preference_xml;
/***
 *  2014Äê11ÔÂ9ÈÕ14:28:06 
 *  I learn the preferencexml
 *  */
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;

public class PreferenceMainActivity extends PreferenceActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.myfirstpreference);
		
		//get preference of control
		Preference _Pre = findPreference("etp");
		
		//set listener
		_Pre.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			
			@Override
			public boolean onPreferenceClick(Preference arg0) {
				// TODO Auto-generated method stub
//				Intent _In = new Intent();
//				_In.setAction("android.settings.SETTINGS");
//				PreferenceMainActivity.this.addPreferencesFromIntent(_In);
//				
				Log.i("Hello", arg0.getKey());
				return true;
			}
		});
		
	}
	
}
	

