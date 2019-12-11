package tv.huan.tencentAuth.base.presenter;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public interface Presenter<V> {
    void attachView(V view);

    void detachView();

    void register();

    void unRegister();
}
