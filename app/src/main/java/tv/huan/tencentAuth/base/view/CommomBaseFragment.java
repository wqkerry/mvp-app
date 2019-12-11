package tv.huan.tencentAuth.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author wangqiang
 * @date 2019/7/25
 * @describe TODO
 */
public abstract class CommomBaseFragment extends Fragment {
    public Context mContext;
    private View mRootview;


    public View getRootview() {
        return mRootview;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootview == null) {
            mRootview = inflater.inflate(getLayoutID(), container, false);
            initView(mRootview);

            initData();
        }
        ViewGroup mViewGroup = (ViewGroup) mRootview.getParent();
        if (mViewGroup != null) {
            mViewGroup.removeView(mRootview);
        }
        return mRootview;
    }


    protected abstract void initData();

    protected abstract void initView(View rootview);

    protected abstract int getLayoutID();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }


    public final <T extends View> View findViewById(@IdRes int id) {
        if (getRootview() == null) {
            return null;
        }
        return (T) getRootview().findViewById(id);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }


}
