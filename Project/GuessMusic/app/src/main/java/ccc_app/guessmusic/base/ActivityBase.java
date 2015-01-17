package ccc_app.guessmusic.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import ccc_app.guessmusic.model.WordButton;
import ccc_app.guessmusic.ui.R;

/**
 * Created by Think on 2015/1/2.
 */
public class ActivityBase extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void showMsg(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    protected   void hideOrShowChinese(WordButton wordButton,int visibility)
    {
        wordButton.getmViewBtn().setVisibility(visibility);
        wordButton.setmIsVisible((visibility== View.VISIBLE?true:false));
    }


    protected  int getDeletedMoney()
    {
        return Integer.parseInt(getResources().getString(R.string.gm_delete_answer));
    }

    protected  int getChoiceMoney_L2()
    {
        return Integer.parseInt(getResources().getString(R.string.gm_choice_answer_L2));
    }

    protected  int getChoiceMoney_L3()
    {
        return Integer.parseInt(getResources().getString(R.string.gm_choice_answer_L3));
    }

    protected  int getChoiceMoney_Victory()
    {
        return Integer.parseInt(getResources().getString(R.string.gm_victory_money));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_titlebar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    protected final void makeSureCoin(DialogInterface.OnClickListener listener,String coinInfo)
    {
        AlertDialog alertDialog = new  AlertDialog.Builder(this)
                                           .setTitle(coinInfo)
                                           .setNegativeButton(getString(R.string.FALSE),new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   dialog.dismiss();
                                               }
                                           }).setPositiveButton(getString(R.string.TRUE),listener).show();
    }
}
