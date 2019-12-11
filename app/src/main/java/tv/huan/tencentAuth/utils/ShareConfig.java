package tv.huan.tencentAuth.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ShareConfig {

    private SharedPreferences pref;

    public ShareConfig(Context context) {
        pref = context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }


    /**
     * 保存doLogin返回的qua数据
     *
     * @param qua
     */
    public void commitQua(String qua) {
        Editor editor = pref.edit();
        editor.putString(Constants.QUA, qua);
        editor.commit();
    }

    public void saveTvplaform(String tvplaform) {
        Editor editor = pref.edit();
        editor.putString(Constants.TVPLATFORM, tvplaform);
        editor.commit();
    }

    public void saveGuid(String guid) {
        Editor editor = pref.edit();
        editor.putString(Constants.GUID, guid);
        editor.commit();
    }

    /**
     * 保存用户登录认证type，用来分辨是否要走迁移流程
     *
     * @param loginType
     */
    public void commitUserLoginState(String loginType) {
        Editor editor = pref.edit();
        editor.putString(Constants.LOGINT_STATE_YPE, loginType);
        editor.commit();
    }

    public String getUserLoginState() {
        return pref.getString(Constants.LOGINT_STATE_YPE, null);
    }


    /**
     * 保存客厅开放平台接口的唯一票据
     *
     * @param token
     */
    public void saveKtAccessToken(String token) {
        Editor editor = pref.edit();
        editor.putString(Constants.KTACCESSTOKEN, token);
        editor.commit();
    }

    /**
     * 保存登录方式
     *
     * @param loginType
     */
    public void commitLoginType(String loginType) {
        Editor editor = pref.edit();
        editor.putString(Constants.LOGINTYPE, loginType);
        editor.commit();
    }

    public String getLoginType() {
        return pref.getString(Constants.LOGINTYPE, null);
    }


    /**
     * 保存openid
     */
    public void commitEventOpenId(String openid) {
        Editor editor = pref.edit();
        editor.putString(Constants.OPENID, openid);
        editor.commit();
    }


    public String getOpenId() {
        return pref.getString(Constants.OPENID, null);
    }

    public String getQua() {
        return pref.getString(Constants.QUA, null);
    }

    public String getGuid() {
        return pref.getString(Constants.GUID, null);
    }

    public String getTVPlatform() {
        return pref.getString(Constants.TVPLATFORM, null);
    }

    public String getKtAccessToken() {
        return pref.getString(Constants.KTACCESSTOKEN, null);
    }
}
