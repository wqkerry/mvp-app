package tv.huan.tencentAuth.base.presenter;

import android.content.Context;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tv.huan.tencentAuth.HuanApplication;
import tv.huan.tencentAuth.base.http.Api;
import tv.huan.tencentAuth.base.http.ApiCallback;
import tv.huan.tencentAuth.base.http.BaseResponse;
import tv.huan.tencentAuth.base.http.SubscriberCallBack;
import tv.huan.tencentAuth.room.entity.LoginResultBean;
import tv.huan.tencentAuth.utils.UserUtil;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public class BasePresenter<V> implements Presenter<V> {
    public Context mContext;
    public V mView;

    protected CompositeDisposable mCompletableOnSubscribe;

    public BasePresenter(Context context, V mView) {
        this.mContext = context;
        attachView(mView);
    }

    @Override
    public void attachView(V view) {
        this.mView = view;

    }


    @Override
    public void detachView() {
        this.mView = null;
        onUnsubscribe();
    }

    @Override
    public void register() {
    }

    @Override
    public void unRegister() {
    }

    private void onUnsubscribe() {
        if (mCompletableOnSubscribe != null && !mCompletableOnSubscribe.isDisposed()) {
            mCompletableOnSubscribe.clear();
        }
    }

    protected <T> void addApiCallback(Observable<BaseResponse<T>> observable, final ApiCallback<T> apiCallback) {

        if (mCompletableOnSubscribe == null) {
            mCompletableOnSubscribe = new CompositeDisposable();
        }
        SubscriberCallBack subscriberCallBack = new SubscriberCallBack<T>(mContext, new ApiCallback<T>() {


            @Override
            public void onSuccess(int code, T model, String msg) {
                if (apiCallback != null) {
                    apiCallback.onSuccess(code, model, msg);
                }
            }

            @Override
            public void onFailure(int code, String msg) {
                switch (code) {
                    case 400:
                        if (Api.IS_DEBUG) {

                        }
                        break;
                    case 500:
                        if (Api.IS_DEBUG) {

                        }
                        break;
                }
                if (apiCallback != null) {
                    apiCallback.onFailure(code, msg);
                }
            }

            @Override
            public void onCompleted() {
                if (apiCallback != null) {
                    apiCallback.onCompleted();
                }
            }
        }) {

            @Override
            public void onSubscribe(Disposable disposable) {
                mCompletableOnSubscribe.add(disposable);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(BaseResponse baseResponse) {
                super.onNext(baseResponse);
            }
        };
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//AndroidSchedulers.mainThread()
                .subscribe(subscriberCallBack);
    }


    /**
     * 登录成功保存用户信息
     *
     * @param bean
     */
    protected void saveUserInfo(LoginResultBean bean) {
        //登录成功后,存储用户信息
        if (HuanApplication.getInstance().getAppDatabase().userInfoDao().getUserInfo() == null) {
            HuanApplication.getInstance().getAppDatabase().userInfoDao().insertUsers(bean);
        } else {
            HuanApplication.getInstance().getAppDatabase().userInfoDao().updateUsers(bean);
        }
        UserUtil.saveUser(bean);
    }


    /**
     * 获取数据库用户信息
     *
     * @return
     */
    protected LoginResultBean getUserInfoFromDatabase() {
        if (HuanApplication.getInstance().getAppDatabase().userInfoDao().getUserInfo() != null) {
            return HuanApplication.getInstance().getAppDatabase().userInfoDao().getUserInfo();
        }
        return null;
    }
}
