package tv.huan.tencentAuth.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tv.huan.tencentAuth.room.entity.LoginResultBean;

public class UserUtil {
    private static final String FILE_NAME = "user.txt";

    /**
     * 保存用户信息
     */
    public static void saveUser(LoginResultBean user) {
        LogUtil.i("saveUser");
        if (!AppUtil.isExistsSdcard()) {
            LogUtil.e("sdcard not exists");
            return;
        }
        try {
            File folderFile = new File(Environment.getExternalStorageDirectory().getPath() + File.separator
                    + "Huan");
            File file = new File(folderFile, FILE_NAME);
            if (!folderFile.exists()) {
                if (folderFile.mkdirs()) {
                    if (!file.exists()) {
                        if (!file.createNewFile()) {
                            return;
                        }
                    }
                }
            }
            LogUtil.i("file path " + file.getPath());
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file.getPath()));
            outputStream.writeObject(user);
            LogUtil.i("write user success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除用户信息
     */
    public static void clearUser() {
        LogUtil.i("clearUser");
        if (!AppUtil.isExistsSdcard()) {
            LogUtil.e("sdcard not exists");
            return;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator
                    + "Huan" + File.separator + FILE_NAME);
            if (file.exists()) {
                LogUtil.e("file exists");
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取用户信息
     */
    public static LoginResultBean getUser() {
        LogUtil.i("getUser");
        if (!AppUtil.isExistsSdcard()) {
            LogUtil.e("sdcard not exists");
            return null;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator
                    + "Huan" + File.separator + FILE_NAME);
            if (!file.exists()) {
                LogUtil.e("file not exists");
                return null;
            }
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                    Environment.getExternalStorageDirectory().getPath() + File.separator
                            + "Huan" + File.separator + FILE_NAME
            ));
            return (LoginResultBean) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
