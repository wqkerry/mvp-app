package tv.huan.tencentAuth.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import tv.huan.tencentAuth.base.presenter.Presenter;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public abstract class BaseActivity<P extends Presenter> extends CommonBaseActivity {
    protected P mBasePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mBasePresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBasePresenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBasePresenter.unRegister();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBasePresenter != null) {
            mBasePresenter.detachView();
        }
    }

    protected abstract P createPresenter();
}
