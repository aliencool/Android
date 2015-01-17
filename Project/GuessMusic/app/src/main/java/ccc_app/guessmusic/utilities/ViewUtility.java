package ccc_app.guessmusic.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Think on 2015/1/2.
 */
public  class ViewUtility {
    private ViewUtility(){}

    public static View getView(Context ctx,int idView)
    {
        View _View = LayoutInflater.from(ctx).inflate(idView,null);
        return _View;
    }
}
