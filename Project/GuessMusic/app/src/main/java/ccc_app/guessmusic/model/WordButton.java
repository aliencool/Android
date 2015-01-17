package ccc_app.guessmusic.model;

import android.widget.Button;

/**
 * Created by Think on 2015/1/2.
 */
public class WordButton {
     private int mIndex;
     private String mName;
     private Button mViewBtn;
     private boolean mIsVisible;




    public int getmIndex() {
        return mIndex;
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Button getmViewBtn() {
        return mViewBtn;
    }

    public void setmViewBtn(Button mViewBtn) {
        this.mViewBtn = mViewBtn;
    }

    public boolean ismIsVisible() {
        return mIsVisible;
    }

    public void setmIsVisible(boolean mIsVisible) {
        this.mIsVisible = mIsVisible;
    }
}
