package ccc_app.guessmusic.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.lang.ref.PhantomReference;

/**
 * Created by Think on 2015/1/15.
 */
public class StoreInfo {
    private final static String DATANAME = "MUSICINFO";
    private final static int INITIAL_MONEY = 300;
    public final static int CURRENT_STAGE_GIRL = 0;
    public final static int CURRENT_STAGE_MEN = 1;
    public final static int CURRENT_COIN  = 2;
    public final static int CURRENT_ISM  = 3;

    private static SharedPreferences mSharedPreferences;



    private static void initial(Context mContext)
    {
        mSharedPreferences = mContext.
                getSharedPreferences(DATANAME, Activity.MODE_PRIVATE);
    }

    //isG 0: girl 1:man
    //Save All
    public static void saveData(Context mContext,int currentStageG,int currentStageM
            ,int currentCoin,int isG)
    {
        initial(mContext);
        if( mSharedPreferences != null)
        {
            SharedPreferences.Editor editor = mSharedPreferences.edit();

            editor.putInt("currentStageG",currentStageG);
            editor.putInt("currentStageM",currentStageM);
            editor.putInt("currentCoin",currentCoin);
            editor.putInt("currentIsg",isG);
            editor.commit();
        }
    }
    //Save stage
    //isG 0: girl 1:man
    public static void saveData(Context mContext,int currentStageG,int currentStageM
            ,int isG)
    {
        initial(mContext);
        if( mSharedPreferences != null)
        {
            SharedPreferences.Editor editor = mSharedPreferences.edit();

            editor.putInt("currentStageG",currentStageG);
            editor.putInt("currentStageM",currentStageM);
            editor.putInt("currentIsg",isG);
            editor.commit();
        }
    }


    //Save Flag And Money
    public static void saveData(Context mContext,int currentCoin,int isG)
    {
        initial(mContext);
        if( mSharedPreferences != null)
        {
            SharedPreferences.Editor editor = mSharedPreferences.edit();

            editor.putInt("currentIsg",isG);
            editor.putInt("currentCoin",currentCoin);
            editor.commit();
        }
    }

    public static int[] getDATA(Context mContext)
    {
        int []data = {-1,-1,0,0};
        initial(mContext);

        if( mSharedPreferences != null)
        {
            data[0] = mSharedPreferences.getInt("currentStageG",0);
            data[1] = mSharedPreferences.getInt("currentStageM",0);
            data[2] = mSharedPreferences.getInt("currentCoin",INITIAL_MONEY);
            data[3] = mSharedPreferences.getInt("currentIsg",0);
        }

        return data;
    }
}
