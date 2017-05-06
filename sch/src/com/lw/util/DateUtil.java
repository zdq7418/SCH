package com.lw.util;/**
 * Created by Administrator on 2017/5/5.
 */

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/5/5 22:09
 */
public class DateUtil {
    /**
     * yyyy-HH-dd hh:mm:ss
     * @return
     */
    public static String getDateTime() throws Exception{
        Date date=new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
        String format = dateFormater.format(date);
        return format;
    }
    public static Long getTime() throws Exception{
        Date date=new Date();
        return date.getTime();
    }
    public static Timestamp getTimestamp() throws Exception{
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        return nousedate;
    }
}
