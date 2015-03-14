package com.courtier.designformusic.utilities;

import java.io.File;

import android.os.Environment;

public class VariableStatic {
	public static final String LOCATION=  Environment.getExternalStorageDirectory()
    		.getAbsolutePath();
	public static final String LOCATIONOFMP3=  Environment.getExternalStorageDirectory()
    		.getAbsolutePath() + File.separator + "mp3";
	public static final String URLFORLIST = "http://172.16.142.24:8080/MusicServe/MusicList.xml";
	public static final String URLFORPATH = "http://172.16.142.24:8080/MusicServe/";
	public static final String MUSICLIST = "MusicList.xml";
}
