package tv.huan.tencentAuth.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.widget.ImageView;

import tv.huan.tencentAuth.R;


/**
 * 加载数据对话框
 * Author: yhw on 2017-12-25.
 */

public class LoadDialog extends Dialog {
    private AnimationDrawable animationDrawable;

    public LoadDialog(@NonNull Context context) {
        super(context, R.style.App_Theme_Dialog);
    }

    public LoadDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected LoadDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_load_layout);
        initView();
    }

    private void initView(){
        ImageView imageView = findViewById(R.id.load_view);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if(animationDrawable!=null && animationDrawable.isRunning()){
            animationDrawable.stop();
        }
    }
}
