package tv.huan.tencentAuth.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import tv.huan.tencentAuth.room.dao.UserInfoDao;
import tv.huan.tencentAuth.room.entity.LoginResultBean;

/**
 * @author wangqiang
 * @date 2019/9/1
 * @describe TODO
 */
@Database(entities = LoginResultBean.class, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserInfoDao userInfoDao();
}
