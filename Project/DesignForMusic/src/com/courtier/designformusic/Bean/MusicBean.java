package com.courtier.designformusic.Bean;

import java.io.Serializable;

/**
 * 存放MP3的实体
 * Created by Think on 2015/3/12.
 */
public class MusicBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String mp3Name;
    private String mp3Authory;
    private int mp3Time;
    private String lrcName;
    private int mp3Size;
    private String mp3Path;
    
	public String getMp3Path() {
		return mp3Path;
	}
	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMp3Name() {
		return mp3Name;
	}
	public void setMp3Name(String mp3Name) {
		this.mp3Name = mp3Name;
	}
	public int getMp3Time() {
		return mp3Time;
	}
	public void setMp3Time(int mp3Time) {
		this.mp3Time = mp3Time;
	}
	public String getLrcName() {
		return lrcName;
	}
	public void setLrcName(String lrcName) {
		this.lrcName = lrcName;
	}
	public int getMp3Size() {
		return mp3Size;
	}
	public void setMp3Size(int mp3Size) {
		this.mp3Size = mp3Size;
	}
	public String getMp3Authory() {
		return mp3Authory;
	}
	public void setMp3Authory(String mp3Authory) {
		this.mp3Authory = mp3Authory;
	}
}
