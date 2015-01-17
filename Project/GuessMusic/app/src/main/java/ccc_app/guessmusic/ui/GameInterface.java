package ccc_app.guessmusic.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import ccc_app.guessmusic.model.IGetMediaForWFV;
import ccc_app.guessmusic.model.IHelperItem;
import ccc_app.guessmusic.model.ISelectMusic;
import ccc_app.guessmusic.model.IWordButtonClick;
import ccc_app.guessmusic.model.SongModel;
import ccc_app.guessmusic.model.WordButton;
import ccc_app.guessmusic.base.ActivityBase;
import ccc_app.guessmusic.ui.definecontrol.ActionBarChoice;
import ccc_app.guessmusic.ui.definecontrol.ActionBarHelper;
import ccc_app.guessmusic.ui.definecontrol.GridViewForWorld;
import ccc_app.guessmusic.utilities.PlayMusic;
import ccc_app.guessmusic.utilities.SongUtility;
import ccc_app.guessmusic.utilities.StoreInfo;
import ccc_app.guessmusic.utilities.ViewUtility;

public class GameInterface extends ActivityBase implements IWordButtonClick,IHelperItem,ISelectMusic{
    //define
    private LinearLayout mAnswerBoxLinerLayout;
    private LinearLayout mVictoryView;
    private LinearLayout mWaveFormView;


    private TextView mIndexText;
    private TextView mSongText;
    private TextView mCurrentStageText;

    private ImageButton mNextButton;
    private ImageButton mShareButton;
    private ArrayList<WordButton> mAllData;
    private ArrayList<WordButton> mSelectData;
    private SongModel mSongModel;
    //The barrier
//    private int mCurrentStage = -1;
    private int mCurrentStage_Girl ;
    private int mCurrentStage_Man ;
    //grid
    private GridViewForWorld mGridView;
    //flag for answer
    private final int STATE_RIGHT = 1;
    private final int STATE_INCOMPLETE = 2;
    private final int STATE_ERROR = 3;
    //spark count
    private final int SPARK_COUNT = 6;
    //money
    private  int mCurrentMoney;
    private  int mDeletedMoney ;
    private  int mChoiceMoney ;
    private  boolean mIsLastBox;
    //music
    private PlayMusic mPlayMusic;
    //judge Man or girl
    private boolean isM;
    //get data for game
    private int [] mGameInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gm_game_interface);

        initView();
        initVariable();
        initListener();
        initCurrentData();
    }
    public void initListener()
    {
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The last Stage
                if(judageStage())
                {
                        Intent intent = new Intent(GameInterface.this,FinalInterFace.class);

                        intent.putExtra(FinalInterFace.PASS_SEXUAL,mGameInfo[StoreInfo.CURRENT_ISM]);
                        intent.putExtra(FinalInterFace.PASS_GIRL,mCurrentStage_Girl);
                        intent.putExtra(FinalInterFace.PASS_MAN,mCurrentStage_Man);
                        intent.putExtra(FinalInterFace.PASS_MONEY,mCurrentMoney);

                        startActivity(intent);

                        GameInterface.this.finish();
                }
                else
                {
//                    Log.i("Hello",124+"");
                    //play music for coin
                    mPlayMusic.playMusicNextAndCost();

                    //play stop
                    PlayMusic.stopMusic();

                    mVictoryView.setVisibility(View.GONE);

                    initCurrentData();
                }
            }
        });
        //button
        mGridView.registerWordButtonClickListener(this);
        //actionBar
        ActionBarHelper.registerIHelper(this);
        //selectMusic
        ActionBarChoice.registerIHelper(this);
    }

    public void initVariable() {

        isM = false;

        mGameInfo = StoreInfo.getDATA(this);

        mCurrentMoney = mGameInfo[StoreInfo.CURRENT_COIN];
        //songbird
        if ( mGameInfo[StoreInfo.CURRENT_ISM] == 0  )
        {
            mCurrentStage_Girl = mGameInfo[StoreInfo.CURRENT_STAGE_GIRL];
        }
        else
        {
            mCurrentStage_Man = mGameInfo[StoreInfo.CURRENT_STAGE_MEN];
            isM = true;

        }

        mDeletedMoney = getDeletedMoney();
        mIsLastBox = false;
    }
    public void initView()
    {
        mIndexText = (TextView)findViewById(R.id.indexText);
        mSongText = (TextView)findViewById(R.id.indexSong);
        mNextButton = (ImageButton)findViewById(R.id.btn_next);
        mShareButton = (ImageButton)findViewById(R.id.btn_share);
        mGridView = (GridViewForWorld)findViewById(R.id.btn_grid);
        mCurrentStageText = (TextView)findViewById(R.id.stage_index);
        mVictoryView = (LinearLayout)findViewById(R.id.victory_view);
        mWaveFormView = (LinearLayout)findViewById(R.id.waveformView);
        mAnswerBoxLinerLayout = (LinearLayout)findViewById(R.id.word_select);
    }

    //1:Set First Info
    //1.1:initialize
    public void initCurrentData()
    {
        mSelectData = getSelectBtn();

        mChoiceMoney = returnChoiceMoney();

        LinearLayout.LayoutParams _LayParams = new LinearLayout.LayoutParams(86,84);
        //Clean
        mAnswerBoxLinerLayout.removeAllViews();
        //Set Stage
        if( !isM )
        {

            if (mCurrentStage_Girl <= 9)
            {
                if ( mCurrentStage_Girl <= 0 )
                {
                    mCurrentStageText.setText("01");
                }else
                {
                    mCurrentStageText.setText("0"+(mCurrentStage_Girl + 1));
                }
            }
            else
            {
                mCurrentStageText.setText((mCurrentStage_Girl + 1)+"");
            }
        }
        else
        {
            if (mCurrentStage_Man <= 9)
            {
                if ( mCurrentStage_Man <= 0 )
                {
                    mCurrentStageText.setText("01");
                }else
                {
                    mCurrentStageText.setText("0"+(mCurrentStage_Man+1));
                }
            }
            else
            {
                mCurrentStageText.setText((mCurrentStage_Man+1)+"");
            }
        }

        //Add to select count
        for (int i = 0; i< mSelectData.size() ; i++)
        {
            mAnswerBoxLinerLayout.addView(mSelectData.get(i).getmViewBtn(), _LayParams);
        }
        //Add word
        mAllData = getAllData();
        mGridView.upData(mAllData);

        //Play Music And Show WaveForm
        mPlayMusic =  new PlayMusic(this,new IGetMediaForWFV() {
            @Override
            public void getMedia(MediaPlayer mediaPlayer) {
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mWaveFormView.removeAllViews();
                        mWaveFormView.setVisibility(View.GONE);
                    }
                });
            }
        },mSongModel.getSongFileName(),new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //getData
                Bundle bundle = msg.getData();

                PlayMusic.WaveFormView waveFormView = (PlayMusic.WaveFormView)bundle.getSerializable("View");

                if( waveFormView != null)
                {
                    //Clean
                    mWaveFormView.removeAllViews();
                    //Add
                    mWaveFormView.addView(waveFormView);
                    //show
                    mWaveFormView.setVisibility(View.VISIBLE);
                }
            }
        });

        mPlayMusic.playMusic();

    }

    //1.2:Get Data
    public ArrayList<WordButton> getAllData()
    {
        ArrayList<WordButton> _Array = new ArrayList<WordButton>();
        String []info = randomWord();

        for (int i = 0 ; i < GridViewForWorld.COUNT ; i++)
        {
                WordButton _Word = new WordButton();
                _Word.setmIsVisible(true);
                _Word.setmName( info[i] );
                _Array.add( _Word );
        }

        return _Array;

    }

    //1.2.1:Get Song for selecting
    public ArrayList<WordButton> getSelectBtn()
    {
        ArrayList<WordButton> _Array = new ArrayList<WordButton>();
        Resources _Res = getResources();

        //get Song ,according to stage
        if ( !isM )
        {
            mSongModel = getSong(mCurrentStage_Girl);
        }
        else
        {
            mSongModel = getSong(mCurrentStage_Man);

        }

        for (int i = 0 ; i < mSongModel.getSongLength() ; i++)
        {
            //get Btn
            WordButton  _WBtn = new WordButton();

            View _View = ViewUtility.getView(GameInterface.this, R.layout.gm_ui_gridview);

            _WBtn.setmViewBtn((Button)_View.findViewById(R.id.btn_word));
            //set Btn
            _WBtn.getmViewBtn().setText("");
            _WBtn.getmViewBtn().setTextColor(Color.WHITE);
            _WBtn.getmViewBtn().setBackground(_Res.getDrawable(R.drawable.game_wordblank));
            //setOther
            _WBtn.setmName("");
            _WBtn.setmIsVisible(false);

            _Array.add(_WBtn);
        }
        return _Array;
    }
    //1.2.2:Get Song ,according to stage
    public SongModel getSong(int currentStage)
    {
        //because ,change it that will sub
        if (currentStage < 0 )
        {
            currentStage = 0;
        }

        SongModel _SongModel = null;
        if( !isM )
        {
            _SongModel = new SongModel();

            String [] _SongInfo = SongUtility.getSongInfo_G[currentStage];
            //setter
            _SongModel.setSongName(_SongInfo[SongUtility.INDEX_OF_SongNAME]);
            _SongModel.setSongFileName(_SongInfo[SongUtility.INDEX_OF_FILENAME]);
        }
        else
        {
            String [] _SongInfo = SongUtility.getSongInfo_M[currentStage];
            _SongModel = new SongModel();
            //setter
            _SongModel.setSongName(_SongInfo[SongUtility.INDEX_OF_SongNAME]);
            _SongModel.setSongFileName(_SongInfo[SongUtility.INDEX_OF_FILENAME]);
        }

        return _SongModel;
    }

    //2:Random character for chinese

    //2.1:Generate chinese
    public char getChinese()
    {
        Random _Random = new Random();
        char _Char = ' ';

        int highChar = 176;
        int lowChar = 161;

        byte [] _Byte = new byte[2];
        _Byte[0] = Integer.valueOf(highChar + _Random.nextInt(39)).byteValue();
        _Byte[1] = Integer.valueOf(lowChar + _Random.nextInt(93)).byteValue();

        try {
           _Char = new String(_Byte,"GBK").charAt(0);
        }catch (Exception e)
        {
//            showMsg(e.toString());
        }

        return _Char;
    }
    //2.2:Random
    public String[] randomWord()
    {
        String [] _Str = new String[ GridViewForWorld.COUNT];

        for (int i = 0;i <  mSongModel.getSongLength() ; i++)
        {
            //Answer
            _Str[i] = mSongModel.getSongNameForChar()[i] + "";
        }

        for (int i = mSongModel.getSongLength() ; i < GridViewForWorld.COUNT ; i++)
        {
            _Str[i] = getChinese()+"";
        }

        //Random
        Random _Random = new Random();
        for (int i = GridViewForWorld.COUNT -1 ; i > 0; i--) {
            int index = _Random.nextInt(i + 1);
            String temp = _Str[i];
            _Str[i] = _Str[index];
            _Str[index] = temp;
        }

        return _Str;
    }


    //observe
    public void wordButtonOnClickListener(WordButton wordButton)
    {
        clickToAnswerBox(wordButton);

        int flag = checkAnswerState();

        switch(flag)
        {
            case STATE_RIGHT:
                passEvent();
                break;
            case STATE_INCOMPLETE:
//                showMsg("再选个吧！");
                break;
            case STATE_ERROR:
                Spark();
                break;
        }

    }
    //4 click to Box and hide
    //4.1 click to Box
    private void clickToAnswerBox(final WordButton wordButton)
    {

        for (int i = 0; i < mSelectData.size() ; i++)
        {
           final WordButton _WBtn = mSelectData.get(i);
            if( _WBtn.getmName().length() == 0)
            {
                _WBtn.getmViewBtn().setText(wordButton.getmName());
                _WBtn.getmViewBtn().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _WBtn.getmViewBtn().setText("");
                        _WBtn.setmName("");
                        _WBtn.setmIsVisible(false);
                        _WBtn.setmIndex(-1);
                        hideOrShowChinese(mAllData.get(wordButton.getmIndex()),View.VISIBLE);
                    }
                });
                _WBtn.setmName(wordButton.getmName());
                _WBtn.setmIsVisible(true);
                _WBtn.setmIndex(wordButton.getmIndex());

                hideOrShowChinese(wordButton, View.INVISIBLE);
                break;
            }
        }
    }

    //5:checkAnswer
    //5.1:Check
    private int checkAnswerState()
    {
        for( int i = 0; i < mSelectData.size() ; i++)
        {
            if(mSelectData.get(i).getmName().equals(""))
            {
                       return STATE_INCOMPLETE;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = 0;i < mSelectData.size() ; i ++)
        {
            stringBuilder.append(mSelectData.get(i).getmName());
        }

        return  stringBuilder.toString().equals(mSongModel.getSongName())?STATE_RIGHT:STATE_ERROR;
    }
    //5.2 Spark button
    private void Spark()
    {
        TimerTask timerTask = new TimerTask() {
            private  Boolean changeColor = false;
            private  int  changeCount = 0;
            @Override
            public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ( ++changeCount > SPARK_COUNT)
                            {
                                return;
                            }
                                for ( int i = 0;i < mSelectData.size() ; i++)
                                {
                                    mSelectData.get(i).getmViewBtn().setTextColor(changeColor?Color.WHITE:Color.RED);
                                }
                                //every count revert the flag
                                changeColor = !changeColor;
                        }
                    });
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,1,200);

    }


    //6:Helper

    private int returnChoiceMoney()
    {
        switch (mSongModel.getSongLength())
        {
            case 2:
                return  getChoiceMoney_L2();
            default:
                return  getChoiceMoney_L3();
        }
    }

    @Override
    public void helperForActBar(int id)
    {
        switch (id)
        {
            case 0:
                //music
                mPlayMusic.playMusicNextAndCost();

                showMsg(getString(R.string.tipsMoney)+mCurrentMoney);
                break;
            case 1:
                if(!deletedAnswer())
                {
                    showMsg("金钱不足哦");
                    setCurrentMoney();
                    showMsg(getString(R.string.tipsMoney)+mCurrentMoney);
                }
                else
                {
                    makeSureCoin(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            PlayMusic.stopMusic();

                            //music
                            mPlayMusic.playMusicNextAndCost();

                            mPlayMusic.playMusic();
                        }
                    },getString(R.string.again_music));

                }
                break;
            case 2:
                if(!deletedAnswer())
                {
                    showMsg("金钱不足哦");
                    setCurrentMoney();
                    showMsg(getString(R.string.tipsMoney)+mCurrentMoney);
                }
                else
                {

                    makeSureCoin(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //music
                            mPlayMusic.playMusicNextAndCost();

                            selectAnswer();
                        }
                    },getString(R.string.delete_error));
                }
                break;
            case 3:
                if(!giveAnswer())
                {
                    showMsg("金钱不足哦");
                    setCurrentMoney();
                    showMsg(getString(R.string.tipsMoney)+mCurrentMoney);
                }
                else
                {
                    String coinChoice = String.format(getString(R.string.help_choice),mChoiceMoney);
                    makeSureCoin(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            giveTips();
                            //the last answer isn't to show!
                            if(!mIsLastBox)
                            {
                                //music
                                mPlayMusic.playMusicNextAndCost();

                                mChoiceMoney +=  mChoiceMoney;
                            }
                        }
                    },coinChoice);
                }
                break;
            case 4:
                showMsg("即将开放...,有问题请联系:aasuperkey@163.com,谢谢您!");
                break;
        }
    }
    //choice music
    @Override
    public void selectMusic(int id)
    {
        switch (id)
        {
            case 0:
                isM = false;
                //girl
                //Save

//                StoreInfo.saveData(this,mCurrentStage_Girl,mCurrentStage_Man,mCurrentMoney,mGameInfo[StoreInfo.CURRENT_ISM]);

                mGameInfo[StoreInfo.CURRENT_ISM] = StoreInfo.CURRENT_STAGE_GIRL;

                //get again
                mCurrentStage_Girl = StoreInfo.getDATA(this)[StoreInfo.CURRENT_STAGE_GIRL];

                initCurrentData();

                break;
            case 1:
                isM = true;
                //man
                //Save

//                StoreInfo.saveData(this,mCurrentStage_Girl,mCurrentStage_Man,mCurrentMoney,mGameInfo[StoreInfo.CURRENT_ISM]);

                mGameInfo[StoreInfo.CURRENT_ISM] = StoreInfo.CURRENT_STAGE_MEN;

                //get again
                mCurrentStage_Man = StoreInfo.getDATA(this)[StoreInfo.CURRENT_STAGE_MEN];

                initCurrentData();

                break;
        }
    }
    //6.1:Cost
    private boolean costMoney(int coin)
    {
        mCurrentMoney = mCurrentMoney + coin;
        if(mCurrentMoney > 0)
        {
            return true;
        }
        return false;
    }

    private boolean deletedAnswer()
    {
        if(costMoney(-mDeletedMoney))return true;
        return false;
    }
    private boolean giveAnswer()
    {
        if(costMoney(-mChoiceMoney))return true;
        return false;
    }

    //6.2 selectAnswer
    private boolean selectAnswer()
    {
        Random random = new Random();
        int position ;
        int total = mAllData.size();
        for (int i = 0;i < total;i++)
        {
            position = random.nextInt(total);

            WordButton wordButton = mAllData.get(position);
            // not invisible and answer
            if(wordButton.ismIsVisible() && !isAnswer(wordButton))
            {
              hideOrShowChinese(wordButton,View.INVISIBLE);
              return true;
            }
        }
        return  false;
    }
    //6.3 isAnswer
    //delete
    private boolean isAnswer(WordButton wordButton)
    {
        for (int j = 0;j < mSongModel.getSongLength();j++)
        {
            if(wordButton.getmName().equals(mSongModel.getSongNameForChar()[j]+""))
                return true;
        }
        return false;
    }
    //Tips
    private WordButton isAnswerTips(int index)
    {
        int total = mAllData.size();
        for (int i = 0;i < total;i++)
        {
            WordButton wordButton = mAllData.get(i);
            // not invisible and answer
            if(wordButton.ismIsVisible() && wordButton.getmName().equals(mSongModel.getSongNameForChar()[index]+""))
            {
                return wordButton;
            }
        }
        return null;
    }
    //6.4 Tips
    private boolean giveTips()
    {

        if(mSongModel.getSongLength() == 1)
        {
            showMsg("只有一个答案不能提示");
            return false;
        }

        int total = mSelectData.size();
        int len = mSongModel.getSongLength();

        for(int i = 0 ; i < total ;i++)
        {
            WordButton wordButton = mSelectData.get(i);
            if(wordButton.getmName().length() == 0)
            {
                if( len - i == 1)
                {
                    mIsLastBox = true;
                    setCurrentMoney();
                    showMsg("还有一个，不要提示了哦!");
                    return false;
                }
                    mIsLastBox = false;
                    wordButton.getmViewBtn().setEnabled(false);
                    clickToAnswerBox(isAnswerTips(i));

                    return true;
            }

        }
        return false;
    }

    //7:Event for victory
    private  void passEvent()
    {
        //play stop
        PlayMusic.stopMusic();

        mVictoryView.setVisibility(View.VISIBLE);
        if ( !isM )
        {
            mIndexText.setText((mCurrentStage_Girl+1)+"");
            //Next
            mCurrentStage_Girl++;
        }
        else
        {
            mIndexText.setText((mCurrentStage_Man+1)+"");
            //Next
            mCurrentStage_Man++;
        }
        mSongText.setText(mSongModel.getSongName());

        //Add money
        mCurrentMoney += getChoiceMoney_Victory();
        //Save
       StoreInfo.saveData(this,mCurrentStage_Girl,mCurrentStage_Man,mCurrentMoney,mGameInfo[StoreInfo.CURRENT_ISM]);
    }
    //7.1:是不是最后一关
    private  boolean judageStage()
    {
        if ( !isM )
        {
            return  ( mCurrentStage_Girl == SongUtility.getSongInfo_M.length);
        }
        else
        {
            return  ( mCurrentStage_Man == SongUtility.getSongInfo_G.length);
        }
    }

    //other
    private  void setCurrentMoney()
    {
        mCurrentMoney = mChoiceMoney + mCurrentMoney;
    }

    @Override
    protected void onDestroy() {
        StoreInfo.saveData(this,mCurrentStage_Girl,mCurrentStage_Man,
                mCurrentMoney,mGameInfo[StoreInfo.CURRENT_ISM]);
        PlayMusic.releaseMusic();

        super.onDestroy();
    }

    @Override
    protected void onPause() {
        StoreInfo.saveData(this,mCurrentStage_Girl,
                mCurrentStage_Man,mCurrentMoney,mGameInfo[StoreInfo.CURRENT_ISM]);
        PlayMusic.stopMusic();

        super.onPause();
    }


}
