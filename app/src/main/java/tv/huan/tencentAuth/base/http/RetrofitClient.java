package tv.huan.tencentAuth.base.http;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import retrofit2.Retrofit;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public class RetrofitClient {

    public Retrofit mRetrofit;
//    public ApiService APISTORES;
    private ApiService realApi;
    public static boolean ISDEBUG;


    private RetrofitClient() {
    }

    public void init(Retrofit retrofit) {
        mRetrofit = retrofit;
        realApi = mRetrofit.create(ApiService.class);
//        APISTORES = (ApiService) Proxy.newProxyInstance(ApiService.class.getClassLoader(),
//                new Class[]{ApiService.class}, new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        return method.invoke(realApi, args);
//                    }
//                });
    }

    public static RetrofitClient getRetrofitClient() {
        return SingleRetrofit.INSTANCE;
    }

    public static String getBaseApiUrl() {
        return getRetrofit().mRetrofit.baseUrl().url().toString();
    }

    public static class SingleRetrofit {
        public static final RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static ApiService getInstance() {
//        return SingleRetrofit.INSTANCE.APISTORES;
        return SingleRetrofit.INSTANCE.realApi;
    }

    public static RetrofitClient getRetrofit() {
        return RetrofitClient.SingleRetrofit.INSTANCE;
    }


}
