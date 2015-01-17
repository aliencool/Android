package ccc_app.guessmusic.model;

/**
 * Created by Think on 2015/1/3.
 */
public class SongModel {
    private String mSongName;
    private String mSongFileName;
    private int mSongLength;

    public SongModel(String mSongName, String mSongFileName, int mSongLength) {
        this.mSongName = mSongName;
        this.mSongFileName = mSongFileName;
        this.mSongLength = mSongLength;
    }

    public SongModel()
    {

    }
    //get SongName for char
    public char[] getSongNameForChar()
    {
        return  mSongName.toCharArray();
    }

    public String getSongName() {
        return mSongName;
    }

    public void setSongName(String mSongName) {
        this.mSongName = mSongName;
    }

    public String getSongFileName() {
        return mSongFileName;
    }

    public void setSongFileName(String mSongFileName) {
        this.mSongFileName = mSongFileName;
    }

    public int getSongLength() {
        return mSongName.length();
    }

}
