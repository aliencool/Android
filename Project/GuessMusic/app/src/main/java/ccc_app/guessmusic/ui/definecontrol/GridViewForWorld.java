package ccc_app.guessmusic.ui.definecontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import ccc_app.guessmusic.model.IWordButtonClick;
import ccc_app.guessmusic.model.WordButton;
import ccc_app.guessmusic.ui.R;
import ccc_app.guessmusic.utilities.ViewUtility;

/**
 * Created by Think on 2015/1/2.
 */
public class GridViewForWorld  extends GridView{
    //Total
    public static final int COUNT = 24;

    private ArrayList<WordButton> mArrayList;
    private Context mContext;
    private GridViewAdapterForMe mGridViewAdapterForMe;
    private Animation mWordShow;
    private IWordButtonClick mIWordButtonClick;

    public GridViewForWorld(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        mGridViewAdapterForMe = new GridViewAdapterForMe();
        initVariable();
    }

    public void initVariable()
    {
        mArrayList = new ArrayList<WordButton>();
    }

    public void upData(ArrayList<WordButton> mArrayList)
    {
        this.mArrayList = mArrayList;
        this.setAdapter(mGridViewAdapterForMe);
//        this.noti;
    }

    //observe Moder
    public  void registerWordButtonClickListener(IWordButtonClick iWordButtonClick)
    {
                this.mIWordButtonClick = iWordButtonClick;
    }

    //Adapter
    class  GridViewAdapterForMe extends BaseAdapter
    {
        @Override
        public int getCount() {
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
             final WordButton _WBtn;

            if( convertView == null )
            {
                convertView = ViewUtility.getView(mContext, R.layout.gm_ui_gridview);

                _WBtn = mArrayList.get(position);

                _WBtn.setmIndex(position);

                if ( _WBtn.getmViewBtn() == null)
                {
                    _WBtn.setmViewBtn((Button)convertView.findViewById(R.id.btn_word));
                    _WBtn.getmViewBtn().setText(mArrayList.get(position).getmName());
                    //Subject change to notify all observe
                    _WBtn.getmViewBtn().setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            GridViewForWorld.this.mIWordButtonClick.wordButtonOnClickListener(_WBtn);
                        }
                    });
                }

                //start Animation
                mWordShow = AnimationUtils.loadAnimation(mContext,R.anim.word_show);
                mWordShow.setInterpolator(new LinearInterpolator());
                mWordShow.setStartOffset(position * 100);

                convertView.setTag(_WBtn);
            }
            else
            {
                _WBtn = (WordButton)convertView.getTag();
            }

            _WBtn.setmName(mArrayList.get(position).getmName());
            convertView.startAnimation(mWordShow);

            return convertView;
        }
    }





}
