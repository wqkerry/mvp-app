package tv.huan.tencentAuth.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_1 = "HH:mm:ss";

    /**
     * 获取当前时间
     */
    public static String getDateTime() {
        return getDateTime(DATE_FORMAT);
    }

    public static String getDateTime(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 格式化播放时间
     * @param seconds 秒
     */
    public static String formatSeconds(long seconds){
        String standardTime;
        if (seconds <= 0){
            standardTime = "00:00:00";
        } else if (seconds < 60) {
            standardTime = String.format(Locale.getDefault(), "00:00:%02d", seconds % 60);
        } else if (seconds < 3600) {
            standardTime = String.format(Locale.getDefault(), "00:%02d:%02d", seconds / 60, seconds % 60);
        } else {
            standardTime = String.format(Locale.getDefault(), "%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60);
        }
        return standardTime;
    }


    /**
     * 比较日期（年月日）
     */
    public static int dateCompare(Date date) {
        if (date == null) {
            return -2;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date dateFirst = null;
        try {
            dateFirst = dateFormat.parse(dateFormat.format(new Date(System.currentTimeMillis())));
            Date dateLast = dateFormat.parse(dateFormat.format(date));
            if (dateFirst.after(dateLast)) {
                return 1;
            } else if (dateFirst.before(dateLast)) {
                return -1;
            }
            return 0;
        } catch (ParseException e) {
            return -2;
        }
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            LogUtil.e("===>" + e.getMessage());
            return null;
        }
        return date;
    }

    /**
     * 字符日期格式化
     *
     * @param dateStr
     * @param formatStr
     * @return
     */
    public static String getDateFormat(String dateStr, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = StrToDate(dateStr);
        return format.format(date);
    }

    public static void main(String[] args) {
        String date = getDateFormat("2019-09-22 08:58:26", "yyyy-MM-dd");
        System.out.println("========>result=" + date);
    }

}
