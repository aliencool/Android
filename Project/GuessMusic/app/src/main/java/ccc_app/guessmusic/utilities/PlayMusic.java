package ccc_app.guessmusic.utilities;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.Serializable;

import ccc_app.guessmusic.model.IGetMediaForWFV;
import ccc_app.guessmusic.ui.R;

/**
 * Created by Think on 2015/1/13.
 */
public class PlayMusic {
    private static MediaPlayer mMediaPlayerForMusic;
    private static MediaPlayer mediaPlayerForNextAndCost;
    private WaveFormView mWaveFormView;
    private IGetMediaForWFV mIGetMediaForWFV;
    private Context mContext;
    private String mFileName;
    private Handler handler;

    public PlayMusic(Context context,IGetMediaForWFV iGetMediaForWFV, String fileName,Handler handler) {
        this.mIGetMediaForWFV = iGetMediaForWFV;
        this.mContext = context;
        this.mFileName = fileName;
        this.handler = handler;
        mWaveFormView = new WaveFormView(context);
    }

    public  void playMusic()
    {
        if ( mMediaPlayerForMusic == null  )
        {
            mMediaPlayerForMusic = new MediaPlayer();
        }

        mMediaPlayerForMusic.reset();
        try {
            //Get File Attribute
            AssetManager assetManager = mContext.getAssets();
            AssetFileDescriptor assetFileDescriptor =
                    assetManager.openFd(mFileName);

            mMediaPlayerForMusic.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());

            mMediaPlayerForMusic.prepare();

            handler.post(new Runnable() {
                @Override
                public void run() {

                    //Set and Send message
                    Message message = handler.obtainMessage();

                    Bundle bundle = new Bundle();
                    //initial view
                    getDataForWF();
                    //set
                    if( mWaveFormView != null)
                    bundle.putSerializable("View",mWaveFormView);

                    message.setData(bundle);

                    handler.sendMessage(message);
                }
            });

            mIGetMediaForWFV.getMedia(mMediaPlayerForMusic);

            mMediaPlayerForMusic.start();

        }catch (IOException io)
        {
        }
    }

    public  void playMusicNextAndCost()
    {
        if ( mediaPlayerForNextAndCost == null  )
        {
            mediaPlayerForNextAndCost = MediaPlayer.create(mContext, R.raw.coin);
        }
            mediaPlayerForNextAndCost.start();
    }



    private  void getDataForWF()
    {

        if( mMediaPlayerForMusic != null &&  mContext!= null)
        {
            Visualizer visualizer = new Visualizer(mMediaPlayerForMusic.getAudioSessionId());

            //Close engine
            visualizer.setEnabled(false);

            //set sample
            visualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);

            //set Listener
            visualizer.setDataCaptureListener(new Visualizer.OnDataCaptureListener() {
                @Override
                public void onWaveFormDataCapture(Visualizer visualizer,byte[] waveform, int samplingRate)
                {

                }

                @Override
                public void onFftDataCapture(Visualizer visualizer, byte[] fft, int samplingRate) {
                    mWaveFormView.upData(fft);
                    mWaveFormView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                }
            }, Visualizer.getMaxCaptureRate() / 2, false, true);

            visualizer.setEnabled(true);
        }
    }

   public class WaveFormView extends View implements Serializable
    {
        private Paint mPaint;
        private byte [] mDataByte;
        private float [] mlocation;
        private Rect mRect ;
        private final int mSpectrumNum = 48;
        WaveFormView(Context context) {
             super(context);
             mDataByte = null;
             mPaint = new Paint();
             mRect = new Rect();

            mPaint.setStrokeWidth(8f);
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.RED);
        }

      public void  upData(byte []bytes) {

          byte[] model = new byte[bytes.length / 2 + 1];

          model[0] = (byte) Math.abs(bytes[0]);
          for (int i = 2, j = 1; j < mSpectrumNum;)
          {
              model[j] = (byte) Math.hypot(bytes[i], bytes[i + 1]);
              i += 2;
              j++;
          }
          this.mDataByte = model;
          invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            if( mDataByte == null )
            {
                return;
            }

            //point
            if ( mlocation == null || mlocation.length < mDataByte.length * 4)
            {
                mlocation = new float[mDataByte.length * 4];
            }

            mRect.set(0, 0, getWidth(), getHeight());

            //绘制频谱
            final int baseX = mRect.width()/mSpectrumNum;
            final int height = mRect.height();

            for (int i = 0; i < mSpectrumNum ; i++)
            {
                if (mDataByte[i] < 0)
                {
                    mDataByte[i] = 127;
                }

                final int xi = baseX * i + baseX / 2;

                mlocation[i * 4] = xi;
                mlocation[i * 4 + 1] = height;

                mlocation[i * 4 + 2] = xi;
                mlocation[i * 4 + 3] = height - mDataByte[i];
            }

            canvas.drawLines(mlocation,mPaint);

        }
    }

    public static void stopMusic()
    {
        if( mMediaPlayerForMusic !=null && mMediaPlayerForMusic.isPlaying())
            mMediaPlayerForMusic.stop();
    }

    public static void releaseMusic()
    {
        if( mMediaPlayerForMusic !=null && mMediaPlayerForMusic.isPlaying())
            mMediaPlayerForMusic.release();
        if( mediaPlayerForNextAndCost !=null && mediaPlayerForNextAndCost.isPlaying())
            mediaPlayerForNextAndCost.release();
    }
}
