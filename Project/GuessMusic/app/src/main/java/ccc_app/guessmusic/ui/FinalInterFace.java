package ccc_app.guessmusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import ccc_app.guessmusic.base.ActivityBase;
import ccc_app.guessmusic.ui.R;
import ccc_app.guessmusic.utilities.StoreInfo;

/**
 * Created by Think on 2015/1/15.
 */
public class FinalInterFace extends ActivityBase {

    public final static String PASS_SEXUAL = "PASS_Sexual";
    public final static String PASS_MAN = "PASS_Man";
    public final static String PASS_GIRL = "PASS_Gril";
    public final static String PASS_MONEY = "PASS_MONEY";

    private final int PASS_THIRB_HERO = 1500;
    private final int PASS_FOURTH_HERO = 2500;
    private final int PASS_FOURTH_ALL = 3000;

    private ImageButton mImageButton_continue;
    private ImageButton mImageButton_share;

    private ImageView mImageView_medal_2;
    private ImageView mImageView_medal_3;
    private ImageView mImageView_medal_4;


    // Data
    private int mPass_Sexual;
    private int mPass_Money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gm_final_interface);

        initView();
        initListener();
        handlerPage();
    }

    private void initListener() {
        mImageButton_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalInterFace.this,GameInterface.class);

                switch ( mPass_Sexual )
                {
                    case StoreInfo.CURRENT_STAGE_GIRL:
                        StoreInfo.saveData(FinalInterFace.this,mPass_Money,StoreInfo.CURRENT_STAGE_MEN);
                        break;
                    case StoreInfo.CURRENT_STAGE_MEN:
                        StoreInfo.saveData(FinalInterFace.this,mPass_Money,StoreInfo.CURRENT_STAGE_GIRL);
                        break;
                }

                startActivity(intent);

                FinalInterFace.this.finish();
            }
        });
        mImageButton_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg("即将开放");
            }
        });
    }

    private void  initView()
    {
        mImageButton_share = (ImageButton)findViewById(R.id.btn_final_share);
        mImageButton_continue = (ImageButton)findViewById(R.id.btn_final_continue);
        mImageView_medal_2 = (ImageView)findViewById(R.id.medal_two);
        mImageView_medal_3 = (ImageView)findViewById(R.id.medal_three);
        mImageView_medal_4 = (ImageView)findViewById(R.id.medal_four);
    }

    private void  handlerPage()
    {
        Intent intent = getIntent();

        mPass_Sexual = intent.getIntExtra(PASS_SEXUAL,0);
        int passMan =  intent.getIntExtra(PASS_MAN, 0);
        int passGirl =  intent.getIntExtra(PASS_GIRL,0);
        //set Zero for one
        returnZeroStage(mPass_Sexual,passGirl,passMan);

        mPass_Money = intent.getIntExtra(PASS_MONEY, 0);

        if ( mPass_Money <= PASS_THIRB_HERO)
        {
            showMsg("通关奖励!Hero勋章"+"您还有"+ (PASS_THIRB_HERO - mPass_Money) +"金钱，显示下一个Hero");
        }

        if( mPass_Money >= PASS_THIRB_HERO && mPass_Money <= PASS_FOURTH_HERO)
        {
            mImageView_medal_2.setVisibility(View.VISIBLE);
            showMsg("您还有"+ (PASS_FOURTH_HERO - mPass_Money) +"金钱，显示下一个Hero");
        }
        if( mPass_Money >= PASS_FOURTH_HERO && mPass_Money <= PASS_FOURTH_ALL)
        {
            mImageView_medal_2.setVisibility(View.VISIBLE);
            mImageView_medal_3.setVisibility(View.VISIBLE);
            showMsg("您还有"+ (PASS_FOURTH_HERO - mPass_Money) +"金钱，显示下一个Hero");
        }


     }

    private void returnZeroStage(int passSexual,int passGirl,int passMan) {
        switch (passSexual)
        {
            case StoreInfo.CURRENT_STAGE_GIRL:
                StoreInfo.saveData(this,StoreInfo.CURRENT_STAGE_GIRL,passMan,passSexual);
                break;
            case StoreInfo.CURRENT_STAGE_MEN:
                StoreInfo.saveData(this,passGirl,StoreInfo.CURRENT_STAGE_MEN - 1,passSexual);
                break;
        }
    }


}

