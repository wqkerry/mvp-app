package tv.huan.tencentAuth.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import tv.huan.tencentAuth.R;

/**
 * 二维码工具
 */
public class QRCodeUtil {

    /**
     * 生成不带图标的二维码
     * @param context
     * @param textContent
     * @param w
     * @param h
     * @return
     */
    public static Bitmap createImage(Context context, String textContent, int w, int h) {
        Bitmap  mBitmap = MyCodeUtils.createImage(textContent, w, h, null);
        return mBitmap;
    }

    /**
     * 生成带图标的二维码
     * @param context
     * @param textContent
     * @param w
     * @param h
     * @return
     */
    public static Bitmap createIconImage(Context context, String textContent, int w, int h,final int type) {
        Bitmap mBitmap;
        if (type == 1) {
            mBitmap = MyCodeUtils.createImage(textContent, w, h, BitmapFactory.decodeResource(context.getResources(), R.drawable.qq));
        } else {
            mBitmap = MyCodeUtils.createImage(textContent, w, h, BitmapFactory.decodeResource(context.getResources(), R.drawable.wx));
        }
        return mBitmap;
    }





}
