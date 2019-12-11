package tv.huan.tencentAuth.base.http;


import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public class RetrofitBuilder {
    OkHttpClient.Builder mOkHttpClient;
    Retrofit.Builder mBuilder;
    private static final long DEFAULT_TIMEOUT = 15;

    public RetrofitBuilder() {
        this.mOkHttpClient = new OkHttpClient.Builder();
        this.mOkHttpClient.retryOnConnectionFailure(false);
        this.mOkHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        this.mOkHttpClient.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        this.mOkHttpClient.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        mBuilder = new Retrofit.Builder();
    }

    public RetrofitBuilder addConverterFactory(Converter.Factory factory) {
        mBuilder.addConverterFactory(factory);
        return this;
    }

    public RetrofitBuilder addCallAdapterFactory(CallAdapter.Factory factory) {
        mBuilder.addCallAdapterFactory(factory);
        return this;
    }

    public RetrofitBuilder baseUrl(String baseUrl) {
        mBuilder.baseUrl(baseUrl);
        return this;
    }

    public RetrofitBuilder sslSocketFactory(Context context, int keystoreResId) {
        SSLSocketFactory socketFactory = SslContextFactory.getSSLSocketFactory_Certificate(context, "BKS", keystoreResId);
        this.mOkHttpClient.sslSocketFactory(socketFactory);
        return this;
    }

    public RetrofitBuilder addInterceptor(Interceptor interceptor) {
        this.mOkHttpClient.addInterceptor(interceptor);
        return this;
    }

    public Retrofit build() {
        mBuilder.client(mOkHttpClient.build());
        return mBuilder.build();
    }
}
