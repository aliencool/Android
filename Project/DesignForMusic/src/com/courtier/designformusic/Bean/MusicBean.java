package com.courtier.designformusic.Bean;

/**
 * 存放MP3的实体
 * Created by Think on 2015/3/12.
 */
public class MusicBean {
    private int id;
    private String mp3Name;
    private int mp3Size;
    private String lrcName;
    private int lrcSize;

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

    public int getMp3Size() {
        return mp3Size;
    }

    public void setMp3Size(int mp3Size) {
        this.mp3Size = mp3Size;
    }

    public String getLrcName() {
        return lrcName;
    }

    public void setLrcName(String lrcName) {
        this.lrcName = lrcName;
    }

    public int getLrcSize() {
        return lrcSize;
    }

    public void setLrcSize(int lrcSize) {
        this.lrcSize = lrcSize;
    }
}
