package tv.huan.tencentAuth.base.http;

import android.content.Context;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import tv.huan.tencentAuth.BuildConfig;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public class Api {
    public static String APIURL;
    public static boolean IS_DEBUG;

    private static ApiService sApiService;

    public static ApiService getApiService() {
        return sApiService;
    }

    /**
     * @param applicationContext
     * @param apiUrl
     * @param interceptors
     * @param isDebug
     */
    public static void invoke(Context applicationContext, String apiUrl, List<Interceptor> interceptors, boolean isDebug) {
        if (apiUrl == null) {
            throw new RuntimeException(" apiUrl cannot be NULL");
        }
        APIURL = apiUrl;
        IS_DEBUG = isDebug;
        RetrofitClient.ISDEBUG = isDebug;
        RetrofitBuilder apiBuild = new RetrofitBuilder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addInterceptor(new HttpBaseParameters())
                .addInterceptor(new LoggingInterceptor.Builder().loggable(BuildConfig.IS_DEBUG)
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .request("Request")
                        .response("Response").build())
                .baseUrl(APIURL);
//                .sslSocketFactory(applicationContext, 0);  启用https方式时增加使用

        if (interceptors != null && !interceptors.isEmpty()) {
            for (Interceptor interceptor : interceptors) {
                apiBuild.addInterceptor(interceptor);
            }
        }
        RetrofitClient.getRetrofit().init(apiBuild.build());
        sApiService = RetrofitClient.getInstance();
    }


    private static final LoggingInterceptor.Builder s = new LoggingInterceptor.Builder();

}
