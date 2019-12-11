package tv.huan.tencentAuth;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import tv.huan.tencentAuth.base.http.Api;
import tv.huan.tencentAuth.room.AppDatabase;
import tv.huan.tencentAuth.utils.ShareConfig;

public class HuanApplication extends Application {

    private ShareConfig mShareConfig;
    public static HuanApplication instance;
    private AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initShareCinfig();
        initHttp();
        initAppDatas();
        //腾讯SDK注册
        //二维码工具注册
        ZXingLibrary.initDisplayOpinion(this);
    }

    private void initShareCinfig() {
        mShareConfig = new ShareConfig(this);
    }

    public ShareConfig getShareConfig() {
        return mShareConfig;
    }

    private void initHttp() {
        Api.invoke(this, BuildConfig.BASE_SEVER_URL,
                null, false);
    }
    public static HuanApplication getInstance() {
        return instance;
    }

    private void initAppDatas() {
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                "huan_tx.db").allowMainThreadQueries().build();
    }
    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

}
