package ccc_app.guessmusic.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import ccc_app.guessmusic.ui.R;

/**
 * Created by Think on 2015/1/19.
 */
public class WeiXinUtilities {
    private static final String  App_ID  = "wxc11aeba0be443dc2";

    private static final String URL="http://zhushou.360.cn/detail/index/soft_id/2515488";

    private static final int THUMB_SIZE = 150;

    private IWXAPI mIwxapi;

    private Context mContext;

    private static WeiXinUtilities mWeiXinUtilities;

    private WeiXinUtilities(Context context)
    {
        mContext = context;

        mIwxapi = WXAPIFactory.createWXAPI(context,App_ID,false);

        mIwxapi.registerApp(App_ID);
    }

    public  static WeiXinUtilities getInstance(Context context)
    {
        if ( mWeiXinUtilities == null)
        {
            mWeiXinUtilities = new WeiXinUtilities(context);
        }
        return mWeiXinUtilities;
    }

    /**
     * 发送文本
     * */
    public void sendText(String text)
    {
        WXTextObject textObject = new WXTextObject();
        textObject.text = text;

        WXMediaMessage wxMediaMessage = new WXMediaMessage();
        wxMediaMessage.mediaObject = textObject;
        wxMediaMessage.description = text;

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "txt" + String.valueOf(System.currentTimeMillis());
        req.message = wxMediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneTimeline ;

        mIwxapi.sendReq(req);
    }

    /**
     * 发送图片
     * */
    public void sendBitMap(int id,String text)
    {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = URL;
        WXMediaMessage wxMediaMessage = new WXMediaMessage(webpage);
        wxMediaMessage.title = text;
        try
        {
            Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(), id);
            Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
            bmp.recycle();
            wxMediaMessage.setThumbImage(thumbBmp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "img" + String.valueOf(System.currentTimeMillis());
        req.message = wxMediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneTimeline ;

        mIwxapi.sendReq(req);

    }


}
