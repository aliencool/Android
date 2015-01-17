package ccc_app.guessmusic.ui.definecontrol;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import ccc_app.guessmusic.model.IHelperItem;
import ccc_app.guessmusic.ui.R;

/**
 * Created by Think on 2015/1/14.
 */
public class ActionBarHelper extends ActionProvider {
    private Context mContext;
    private static IHelperItem mIHelperItem;

    public ActionBarHelper(Context context) {
        super(context);
        this.mContext = context;
    }

    public static void registerIHelper(IHelperItem iHelperItem)
    {
        mIHelperItem = iHelperItem;
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
        subMenu.add(0,0,0,mContext.getString(R.string.infBar))
                .setIcon(R.drawable.ic_action_coin_48).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mIHelperItem != null)
                mIHelperItem.helperForActBar(item.getItemId());
                return false;
            }
        });

        //music
        subMenu.add(0,1,0,mContext.getString(R.string.again))
                .setIcon(R.drawable.ic_action_headphones).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mIHelperItem != null)
                    mIHelperItem.helperForActBar(item.getItemId());
                return false;
            }
        });
        //delete a answer
        subMenu.add(0,2,0,mContext.getString(R.string.deleteBar))
                .setIcon(R.drawable.ic_action_x_48).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mIHelperItem != null)
                    mIHelperItem.helperForActBar(item.getItemId());
                return false;
            }
        });
        //tips
        subMenu.add(0,3,0,mContext.getString(R.string.tipsBar))
                .setIcon(R.drawable.ic_action_help_48).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mIHelperItem != null)
                    mIHelperItem.helperForActBar(item.getItemId());
                return false;
            }
        });

        //share
        subMenu.add(0,4,0,mContext.getString(R.string.shareBar))
                .setIcon(R.drawable.ic_action_share).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if( mIHelperItem != null)
                    mIHelperItem.helperForActBar(item.getItemId());
                return false;
            }
        });
    }
}
