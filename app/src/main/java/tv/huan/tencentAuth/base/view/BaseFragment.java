package tv.huan.tencentAuth.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import tv.huan.tencentAuth.base.presenter.BasePresenter;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public abstract class BaseFragment<P extends BasePresenter> extends CommomBaseFragment {
    protected Context mContext;
    protected P mBasePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mBasePresenter = createPresenter();

    }

    protected abstract P createPresenter();

    public BaseFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBasePresenter.register();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBasePresenter.unRegister();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBasePresenter != null) {
            mBasePresenter.detachView();
        }
    }
}
