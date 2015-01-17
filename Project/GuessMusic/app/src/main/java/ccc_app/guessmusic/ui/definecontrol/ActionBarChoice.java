package ccc_app.guessmusic.ui.definecontrol;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import ccc_app.guessmusic.model.IHelperItem;
import ccc_app.guessmusic.model.ISelectMusic;
import ccc_app.guessmusic.ui.R;

/**
 * Created by Think on 2015/1/14.
 */
public class ActionBarChoice extends ActionProvider {
    private Context mContext;
    private static ISelectMusic mISelectMusic;

    public ActionBarChoice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static void registerIHelper(ISelectMusic iSelectMusic)
    {
        mISelectMusic = iSelectMusic;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        //Add

        //coin
        subMenu.add(0,0,0,mContext.getString(R.string.choicegirl))
                .setIcon(R.drawable.ic_action_iconmonstr_female_icon_48).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mISelectMusic != null)
                mISelectMusic.selectMusic(item.getItemId());
                return false;
            }
        });
        //delete a answer
        subMenu.add(0,1,1,mContext.getString(R.string.choiceman))
                .setIcon(R.drawable.ic_action_iconmonstr_male_icon_48).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mISelectMusic != null)
                    mISelectMusic.selectMusic(item.getItemId());
                return false;
            }
        });
    }
}
