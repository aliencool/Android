package courtier_music.painter.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import java.util.logging.Handler;

import courtier_music.painter.R;

/**
 * Created by Think on 2016/3/12.
 */
public class PainterStartActivity extends BaseActivity{
    private final static int TIME2FINISH = 0X11;
    private android.os.Handler mHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == TIME2FINISH) {
               startMainActivity();
               finish();
            }
        }
    };

    private void startMainActivity() {
        Intent intent = new Intent(this,PainterMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painter_start);
        mHandler.sendEmptyMessageDelayed(TIME2FINISH, 3000);
    }
}
