package cn.edu.nju.rm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangxue
 * Created by wangxue on 2019/3/9.
 */
public final class DateHelper {

    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat( Constant.DATE_PATTERN);
        return format.format(date);
    }

    public static Date stringToDate(String dateString){
        SimpleDateFormat format = new SimpleDateFormat( Constant.DATE_PATTERN);
        try {
            return format.parse(dateString);
        }catch (ParseException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
