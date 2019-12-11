package tv.huan.tencentAuth.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * @author wangqiang
 * @date 2019/9/1
 * @describe TODO
 */
@Entity(tableName = "userinfo")
public class LoginResultBean implements Serializable {
    private static final long serialVersionUID = -6744777824363263477L;

    @PrimaryKey
    public long uid;
    public String appid;
    public String openid;
    public String accesstoken; //小屏登录回调
    public String vuserid; //小屏
    public String vuid; //大屏vuid
    public String vusession;
    public String bigVusession; //大屏vusession用于迁移
    public String ktUserid;
    public String loginType;  //wx  qq
    public String ktAccessToken; //大屏accessToken

    public String nick;//昵称
    public String face;//头像

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getVuserid() {
        return vuserid;
    }

    public void setVuserid(String vuserid) {
        this.vuserid = vuserid;
    }

    public String getVusession() {
        return vusession;
    }

    public void setVusession(String vusession) {
        this.vusession = vusession;
    }

    public String getKtUserid() {
        return ktUserid;
    }

    public void setKtUserid(String ktUserid) {
        this.ktUserid = ktUserid;
    }

    public String getLoginType() {
        return loginType;
    }

    public String getVuid() {
        return vuid;
    }

    public void setVuid(String vuid) {
        this.vuid = vuid;
    }

    public String getBigVusession() {
        return bigVusession;
    }

    public void setBigVusession(String bigVusession) {
        this.bigVusession = bigVusession;
    }

    public String getKtAccessToken() {
        return ktAccessToken;
    }

    public void setKtAccessToken(String ktAccessToken) {
        this.ktAccessToken = ktAccessToken;
    }

    public String getUserType() {
        if ("qq".equals(getLoginType())) {
            return "1";
        } else {
            return "2";
        }
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }


    @Override
    public String toString() {
        return "LoginResultBean{" +
                "uid=" + uid +
                ", appid='" + appid + '\'' +
                ", openid='" + openid + '\'' +
                ", accesstoken='" + accesstoken + '\'' +
                ", vuserid='" + vuserid + '\'' +
                ", vuid='" + vuid + '\'' +
                ", vusession='" + vusession + '\'' +
                ", bigVusession='" + bigVusession + '\'' +
                ", ktUserid='" + ktUserid + '\'' +
                ", loginType='" + loginType + '\'' +
                ", ktAccessToken='" + ktAccessToken + '\'' +
                ", nick='" + nick + '\'' +
                ", face='" + face + '\'' +
                '}';
    }
}
