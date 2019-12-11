package tv.huan.tencentAuth.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import tv.huan.tencentAuth.room.entity.LoginResultBean;

/**
 * @author wangqiang
 * @date 2019/9/1
 * @describe TODO
 */
@Dao
public interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUsers(LoginResultBean users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateUsers(LoginResultBean users);

    @Delete
    int deleteUsers(LoginResultBean... resultBeans);


    @Query("SELECT * FROM userinfo")
    LoginResultBean getUserInfo();


    /**
     * 查询记录总条数
     *
     * @return
     */
    @Query("SELECT count(1) FROM userinfo")
    int getUserInfoCount();
}
