package tv.huan.tencentAuth.utils;

/**
 * Created by $Knight on 2019/2/28.
 */
public class Constants {

    public static final String SHARED_PREFERENCE_NAME = "tencent_data_info";

    public static final String DATAS = "datas";
    //tencent返回的相关参数
    public static final String QUA = "qua";
    public static final String GUID = "guid";
    public static final String TVPLATFORM = "TVPlatform";
    public static final String LOGINTYPE = "loginType";
    public static final String OPENID = "openid";
    public static final String LOGINT_STATE_YPE = "loginStateType";
    public static final String ORDER_ID = "loginStateType";
    public static final String KTACCESSTOKEN = "KtAccessToken";


    public static final int SUCCESS = 0;//成功
    public static final int ERROR_PARAM = 201;//参数错误
    public static final int ERROR_ACCESSTOKEN_LIMIT = 202;//accesstoken频率限制
    public static final int ERROR_SYSTEM = 203;//系统错误
    public static final int ERROR_APPID = 204;//appid无效
    public static final int ERROR_APPID_STATE = 205;//appid状态异常
    public static final int ERROR_SERVER = 206;//服务器ip限制
    public static final int ERROR_ACCESSTOKEN = 231;//非法accesstoken
    public static final int ERROR_ACCESSTOKEN_OUTTIME = 232;//accesstoken已过期

    public static final int ERROR_ORDER = 413;//订单创建错误


    /**
     * 内部存储key
     */
    public static class Key {
        public static String VUID = "vuid";//用户ID vuid对应服务器huanId
        public static String VTOKEN = "vtoken";//vtoken
        public static String REMOTEURL = "remoteUrl";//请求地址key
        public static String SESSKEY = "sesskey";
        public static String CLASSID = "classId"; //子分类id
        public static String ROOTCLASSID = "rootclassid"; //根分类ID 影片专辑类型 1电影 2电视
        public static String CID = "cid"; //cid
        public static String IMAGEBG = "imagebg"; //背景URL
        public static String detailName = "detailUrl"; //前缀URL
        public static String PRODID = "prodId"; //产品id
        public static String ALBUMID = "albumId"; //
        public static String ALBUMTYPE = "albumtype"; //类型
        public static String ACCESS_TOKEN = "ACCESS_TOKEN"; //ACCESS_TOKEN
        public static String ACCESS_TOKEN_EXPIREIN = "ACCESS_TOKEN_EXPIREIN"; //accessToken过期时间
        public static String SESS_KEY_EXPIREIN = "SESS_KEY_EXPIREIN"; //sessKey过期时间
        public static String PAY_WEBURL = "PAY_WEBURL"; //支付WEB地址
        public static String PAY_RESULT_JSON = "PAY_RESULT_JSON"; //支付结果
        public static String APP_FIRST_INSTALL = "APP_FIRST_INSTALL"; //APP是否第一次安装
    }


    public static String SelfPath;//
    public static String Files_Path;

    public static String tempapkurl;//
    public static String apkurl;//

    //焦点json
    public static final String SERVER = "http://portalshdx.huan.tv/public/epg/json/first_pos.json";

    //腾讯详情页面启动参数
    public static final String stay_flag = "stayFlag";
    public static final String action = "action";
    public static final String cover_id = "coverId";
    public static final String pull_from = "pullFrom";
    public static final String tab_id = "tabId";
    public static final String httpUrl = "httpUrl";
    public static final String rType = "rType";


    //超时时间设置
    public static final long TIME_OUT = 3 * 60 * 1000;

    //打开方式
    public static final String OPEN_TYPE = "openType";


}
