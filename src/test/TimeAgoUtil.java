package test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/8/8
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class TimeAgoUtil {
    private static Calendar calendar = Calendar.getInstance();
    private static long MILLIS_PER_WEEK = 7*DateUtils.MILLIS_PER_DAY;
    private static long MILLIS_PER_MONTH = 30*DateUtils.MILLIS_PER_DAY;
    private static long MILLIS_PER_YEAR = 12*30*DateUtils.MILLIS_PER_DAY;
    private static String tpl="{0} {1} ago";
    public static String getTimeAgo(String videotime){
        String timeAgo = "";
        try {
            Calendar now = Calendar.getInstance();
            calendar.setTime(DateUtils.parseDate(videotime, "yyyy-MM-dd HH:mm:ss"));
            if(calendar.compareTo(now)>0) return timeAgo;

            long diff = now.getTimeInMillis()-calendar.getTimeInMillis();
            if((diff/MILLIS_PER_YEAR)>0){
                long yearNum = diff/MILLIS_PER_YEAR;
                timeAgo = MessageFormat.format(tpl,yearNum,(yearNum>1l?"years":"year"));
            }else if((diff/MILLIS_PER_MONTH)>0){
                System.out.println("month....");
                long monthNum = diff/MILLIS_PER_MONTH;
                timeAgo = MessageFormat.format(tpl,monthNum,(monthNum>1l?"months":"month"));
            }else if((diff/MILLIS_PER_WEEK)>0){
                long weekNum = diff/MILLIS_PER_WEEK;
                timeAgo = MessageFormat.format(tpl,weekNum,(weekNum>1l?"weeks":"week"));
            }else if((diff/DateUtils.MILLIS_PER_DAY)>0){
                long dayNum = diff/DateUtils.MILLIS_PER_DAY;
                timeAgo = MessageFormat.format(tpl,dayNum,(dayNum>1l?"days":"day"));
            }else if((diff/DateUtils.MILLIS_PER_HOUR)>0){
                long hourNum = diff/DateUtils.MILLIS_PER_HOUR;
                timeAgo = MessageFormat.format(tpl,hourNum,(hourNum>1l?"hours":"hour"));
            }else {
                long minuteNum = diff/DateUtils.MILLIS_PER_MINUTE;
                timeAgo = MessageFormat.format(tpl,minuteNum,(minuteNum>1l?"minutes":"minute"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeAgo;
    }

    public static void main(String[] args) {
        System.out.println(getTimeAgo("2016-08-08 16:00:08"));

        String[] str = {"aaaa.0"};
        str[0] = str[0].split("\\.")[0];
        System.out.println(str[0]);
        System.out.println(formatTosepara(0));
        System.out.println(String.format("%,d",1234));
    }

    public static String formatTosepara(float data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }
}
