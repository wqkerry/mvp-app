package tv.huan.tencentAuth.base.http;


import android.content.Context;

import java.io.EOFException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;


/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe 接口请求状态码
 */
public abstract class SubscriberCallBack<T> implements Observer<BaseResponse<T>> {
    public static final int SUCCESS = 0; //成功
    public static final int SUCCESS_BOSS_AUTH = 3; //成功
    private ApiCallback<T> apiCallback;
    private Context mContext;

    public SubscriberCallBack(Context context, ApiCallback<T> apiCallback) {
        this.apiCallback = apiCallback;
        mContext = context;
    }

    @Override
    public abstract void onSubscribe(Disposable d);

    @Override
    public void onNext(BaseResponse<T> baseResponse) {
        try {
            if (baseResponse.getCode() == SUCCESS) {
                if (apiCallback != null) {
                    apiCallback.onSuccess(baseResponse.getCode(), baseResponse.getData(), baseResponse.getMsg());
                }
            } else if (baseResponse.getCode() == SUCCESS_BOSS_AUTH) {
                apiCallback.onSuccess(baseResponse.getCode(), baseResponse.getDatas(), baseResponse.getMsg());
            } else {
                onError(new ApiException(baseResponse));//
            }
        } finally {
            if (apiCallback != null) {
                apiCallback.onCompleted();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code > 300 && code < 600) {
                if (!Api.IS_DEBUG) {
                    msg = "网络不给力";
                }
            }
            if (apiCallback != null) {
                apiCallback.onFailure(code, msg);
                apiCallback.onCompleted();
            }
        } else if (e instanceof UnknownHostException) {
            if (apiCallback != null) {

                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof SocketException) {
            if (apiCallback != null) {

                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof SocketTimeoutException) {
            if (apiCallback != null) {

                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof HttpRetryException) {
            if (apiCallback != null) {

                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof MalformedURLException) {
            if (apiCallback != null) {

                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof UnknownServiceException) {
            if (apiCallback != null) {
                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof EOFException) {
            if (apiCallback != null) {
                apiCallback.onFailure(0, "请检查网络");
                apiCallback.onCompleted();
            }
        } else if (e instanceof UnKnowException) {
            if (RetrofitClient.ISDEBUG) {
                UnKnowException httpException = (UnKnowException) e;
                if (apiCallback != null) {
                    apiCallback.onFailure(0, httpException.getInfo());
                }

            }
            if (apiCallback != null) {
                apiCallback.onCompleted();
            }
        } else if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            if (apiCallback != null) {
                apiCallback.onFailure(exception.getCode(), exception.getInfo());
            }
        } else {
            if (apiCallback != null) {
                apiCallback.onFailure(0, e.getMessage());
                apiCallback.onCompleted();
            }
        }
    }

    @Override
    public void onComplete() {

    }
}
