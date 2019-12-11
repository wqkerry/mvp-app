package tv.huan.tencentAuth.base.http;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wangqiang
 * @date 2019/7/29
 * @describe TODO
 */
public class HttpBaseParameters implements Interceptor {

    public static final String API_KEY = "apikey";
    public static final String SECRET_KEY = "secretkey";
    public static final String USER_ID = "userId";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl.Builder authorizedUrlBuilder = request.url().newBuilder().scheme(request.url().scheme())
                .host(request.url().host())
                //todo
                .addQueryParameter(API_KEY, "")
                .addQueryParameter(SECRET_KEY, "")//0617240010E00000B9F62E75FC
                .addQueryParameter(USER_ID, "0617240010E00000B9F62E75FC");//

        request = request.newBuilder()
                .method(request.method(), request.body())
                .url(authorizedUrlBuilder.build())
                .build();
        return chain.proceed(request);
    }
}
