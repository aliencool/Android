package ccc_app.guessmusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import ccc_app.guessmusic.base.ActivityBase;

/**
 * Created by Think on 2015/1/15.
 */
public class HomeInterFace extends ActivityBase {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gm_home_page);
        //5s jump to game
        Delay();
    }

    private void Delay()
    {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                skip();
            }
        };

        timer.schedule(timerTask,2 * 1000);

    }

    private  void skip()
    {
        Intent intent =  new Intent(this,GameInterface.class);
        startActivity(intent);
        this.finish();
    }
}
