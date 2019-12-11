package tv.huan.tencentAuth.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import tv.huan.tencentAuth.R;


/**
 * @author wangqiang
 * @date 2019/7/29
 * @describe TODO
 */
public class ToastUtil {

    private static Context sAppCtx;

    public static void initAppCtx(Context context) {
        sAppCtx = context.getApplicationContext();
    }

    /**
     * 自定义Toast显示
     *
     * @param text
     */
    public static void show(Context m, CharSequence text) {
        LogUtil.e("text=" + text);
        Toast toast = Toast.makeText(m, text, Toast.LENGTH_LONG);
//        int yOffset = PxUtil.getPx(sAppCtx.getResources(), R.dimen.toast_y_offset);
        toast.setGravity(Gravity.CENTER, 0, 0);
        View view = LayoutInflater.from(m).inflate(R.layout.toast_view, null);
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(text);
            toast.setView(view);
            toast.show();
        }
    }
}
