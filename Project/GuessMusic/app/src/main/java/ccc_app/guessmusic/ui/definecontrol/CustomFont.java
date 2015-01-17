package ccc_app.guessmusic.ui.definecontrol;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Think on 2015/1/11.
 */
public class CustomFont extends TextView{
    public CustomFont(Context context) {
        super(context);
        init(context);
    }

    public CustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void  init(Context context)
    {
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager,"font/Scriptina Pro.ttf");
        setTypeface(typeface);
    }

}
