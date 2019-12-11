package tv.huan.tencentAuth.base.http;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author wangqiang
 * @date 2019/7/26
 * @describe TODO
 */
public interface ApiService {

    /**
     * @param event
     * @return
     */
    @POST("loginAuth")
    Observable<BaseResponse<String>> loginAuth(@Query("event") int event);


}
