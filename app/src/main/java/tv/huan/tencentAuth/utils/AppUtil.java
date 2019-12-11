package tv.huan.tencentAuth.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static tv.huan.tencentAuth.utils.Constants.Files_Path;

/**
 * Created by $Knight on 2019/3/7.
 */
public class AppUtil {
    public static String TAG = AppUtil.class.getSimpleName();

    /**
     * 获取本APP版本名
     */
    public static String getApkVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 下载图片存储
     *
     * @param context
     */
    public static void downloadImage(Context context, String url, String bgNum) {
        File f = new File(Constants.Files_Path + bgNum + "temp.png");
        if (f.exists()) {
            deleteFile(Constants.Files_Path + bgNum + "temp.png");
        }
        File f1 = new File(Constants.Files_Path + bgNum + ".png");
        if (f1.exists()) {
            deleteFile(Constants.Files_Path + bgNum + ".png");
        }
//        Aria.download(context)
//                .load(url)     //读取下载地址
//                .setFilePath(Constants.Files_Path + bgNum + "temp.png") //设置文件保存的完整路径
//                .start();
    }

    /**
     * 设置背景
     *
     * @param bgView
     */
    @SuppressLint("NewApi")
    public static void setBackgroundImag(View bgView, String bgNum) {
        File file = new File(Files_Path + bgNum + ".png");
        if (file.exists()) {
            Log.e(TAG, "9999" + (Files_Path + bgNum + ".png"));
            Uri uri = Uri.fromFile(file);
            Drawable drawable = Drawable.createFromPath(Files_Path + bgNum + ".png");
            bgView.setBackground(drawable);
        }
    }


    /**
     * 下载APK以及安装
     *
     * @param context
     */
    public static void downloadAPK(Context context, String url) {
        File f = new File(Constants.tempapkurl);
        if (f.exists()) {
            deleteFile(Constants.tempapkurl);
        }
        File f1 = new File(Constants.apkurl);
        if (f1.exists()) {
            deleteFile(Constants.apkurl);
        }
//        Aria.download(context)
//                .load(url)     //读取下载地址
//                .setFilePath(Constants.tempapkurl) //设置文件保存的完整路径
//                .start();
    }

    /**
     * 重命名文件
     *
     * @param oldPath 原来的文件地址
     * @param newPath 新的文件地址
     */
    public static void renameFile(String oldPath, String newPath) {
        File oleFile = new File(oldPath);
        File newFile = new File(newPath);
        //执行重命名
        oleFile.renameTo(newFile);
    }

    public static void deleteFile(String path) {
        File f = new File(path);
        if (f.isFile()) f.delete();
    }

    /**
     * 提升读写权限
     *
     * @param filePath 文件路径
     * @return
     * @throws IOException
     */
    public static void setPermission(String filePath) {
        String command = "chmod " + "777" + " " + filePath;
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自升级安装
     *
     * @param context
     * @param apkPath
     */
    public static void installApk(Context context, String apkPath) {
        if (context == null || apkPath == null)
            return;
        setPermission(apkPath);
        Log.e("apputil", "apkPath" + apkPath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 由于没有在Activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(new File(apkPath)),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 电影：音乐 detailm.html 1 ，22  电视剧和动漫,少儿:detail.html 2.3   综艺：detailv.html 10    纪录片：detailn.html9
     *
     * @param type
     * @return
     */
    public static String getDetailHtmlStr(int type) {
        String htmlstr = "detailm.html";
        switch (type) {
            case 1:
            case 22:
                htmlstr = "detailm.html";
                break;
            case 2:
            case 3:
            case 106:
                htmlstr = "detail.html";
                break;
            case 10:
                htmlstr = "detailv.html";
                break;
            case 9:
                htmlstr = "detailn.html";
                break;
        }
        return htmlstr;
    }

    public static String replaceBlank(String str) {

        String dest = "";

        if (str != null) {

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }

        return dest;
    }

    public static String replaceDetail(String str) {

        String dest = "";
        String regEx = "[`~!@#$%^&*()+=|{}''':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：\"”“’。、？]";
        if (str != null) {

            Pattern p = Pattern.compile(regEx);

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }

        return dest;
    }

    /**
     * 获取eth的mac地址
     */
    public static String getMacAddress(Context context) {
        String mac = AppUtil.getEthMacAddress("eth");
        if (TextUtils.isEmpty(mac)) {
            mac = AppUtil.getWifiMacAddress(context);
        }
        return mac;
    }

    /**
     * 获取eth的mac地址
     *
     * @param name
     * @return
     */
    @SuppressLint({"NewApi", "DefaultLocale"})
    private static String getEthMacAddress(String name) {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface intf = en.nextElement();
                if (intf.getName().toLowerCase(Locale.getDefault())
                        .contains(name)) {
                    byte[] ha = intf.getHardwareAddress();
                    if (ha != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < ha.length; ++i) {
                            sb.append(String.format("%1$02x", ha[i]));
                        }
                        return sb.toString().toLowerCase(Locale.getDefault());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        return "";
    }

    /**
     * 获取Wifi的mac地址
     */
    public static String getWifiMacAddress(Context context) {
        try {
            WifiManager wifi = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            return info.getMacAddress().replace(":", "")
                    .toLowerCase(Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 判断SD卡是否存在
     */
    public static boolean isExistsSdcard(){
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }



    public static void main(String[] args) {
        String extra = "{\"guid\": \"0C15BCE600E081E142ED0243A84CE99D\", \t\"TVPlatform\": \"3290603\", \t\"QUA\": \"QV%3D1%26PR%3DVIDEO%26PT%3DOTTAPP%26CHID%3D13072%26RL%3D1280*720%26VN%3D4.0.2%26VN_CODE%3D5240%26SV%3D4.4.2%26SI%3D19%26DV%3DHi3798MV200%26VN_BUILD%3D0%26MD%3DHi3798MV200%26BD%3Dbigfish%26MF%3Dyinhe%26TVKPlatform%3D3290603\" }";

        com.alibaba.fastjson.JSONObject Obj = JSON.parseObject(extra);
        String guid = Obj.getString("guid").toString();
        String TVPlatform = Obj.getString("TVPlatform").toString();
        String QUA = Obj.getString("QUA").toString();
        System.out.println(guid);
        System.out.println(TVPlatform);
        System.out.println(QUA);
    }

}
