package tv.huan.tencentAuth.base.http;


public interface ApiCallback<T> {
    void onSuccess(int code, T model, String msg);

    void onFailure(int code, String msg);

    void onCompleted();
}
