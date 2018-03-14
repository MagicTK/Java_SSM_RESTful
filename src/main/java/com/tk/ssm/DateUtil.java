package com.hym.ssm.Utils;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 日期工具类
 * @author ZhangTK
 * @version 1.0.0
 * @Time 2018//01/18
 */

public class DateUtil {
    
    public static enum TIME_UNIT {MILLIS, SECS, MINS, HOURS, DAYS};
    
    private static String INVALID_DATE_ERR = "请输入合法格式的Date日期";
    private static String INVALID_CAL_ERR  = "请输入合法格式的Calendar日期";
    private static String STRING_FMT_ERR   = "请输入合法格式的字符串";
    
    private static final long MILLIS_IN_SEC  = 1000;
    private static final long MILLIS_IN_MIN  = MILLIS_IN_SEC*60;
    private static final long MILLIS_IN_HOUR = MILLIS_IN_MIN*60;
    private static final long MILLIS_IN_DAY  = MILLIS_IN_HOUR*24;

    /**
     * 将Date日期转化为日期字符串
     * @param date   日期（Date）
     * @param format 日期格式（String）
     * @return 日期（String）
     */
    public static String formatDate(Date date, String format){
        if(date == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        if(format == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(format.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        return dateFormatter.format(date);
    }


    /**
     * 将日期字符串转化为Date日期
     * @param formattedString 日期字符串（String）
     * @return 日期（Date）
     * @throws ParseException
     */
    public static Date getDateFromString(String formattedString) throws ParseException{
        if(formattedString == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(formattedString.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat();
        
        return dateFormatter.parse(formattedString);
        
    }


    /**
     * 将Calendar日期转化为日期字符串
     * @param calendar 日期（Calendar）
     * @param format   日期格式（String）
     * @return 日期（String）
     */
    public static String formatDate(Calendar calendar, String format){
        if(calendar == null){
            throw new NullPointerException(INVALID_CAL_ERR);
        }
        if(format == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(format.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
        
        return dateFormatter.format(calendar.getTime());
    }


    /**
     * 将日期字符串转化为Calendar日期
     * @param formattedString 日期字符串（String）
     * @return 日期（Calendar）
     * @throws ParseException
     */
    public static Calendar getCalendarFromString(String formattedString) throws ParseException{
        if(formattedString == null){
            throw new NullPointerException(STRING_FMT_ERR);
        }
        if(formattedString.length() == 0){
            throw new IllegalArgumentException(STRING_FMT_ERR);
        }
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat(formattedString);
        Date date = dateFormatter.parse(formattedString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        return calendar;
    }


    /**
     * 将Calendar日期(yyyy/MM/dd)转化为日期字符串
     * @param calendar 日期（Calendar）
     * @return 日期（String）
     */
    public static String formatToShortDate(Calendar calendar){
        if(calendar == null){
            throw new NullPointerException(INVALID_CAL_ERR);
        }
        return formatDate(calendar, "yyyy/MM/dd");
    }


    /**
     * 将Date日期(yyyy/MM/dd)转化为日期字符串
     * @param date 日期（Date）
     * @return 日期（String）
     */
    public static String formatToShortDate(Date date){
        if(date == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        return formatDate(date, "yyyy/MM/dd");
    }


    /**
     * 将Calendar时间(HH:mm:ss)转化为时间字符串
     * @param calendar 时间（Calendar）
     * @return 时间（String）
     */
    public static String formatToShortTime(Calendar calendar){
        if(calendar == null){
            throw new NullPointerException(INVALID_CAL_ERR);
        }
        return formatDate(calendar, "HH:mm:ss");
    }


    /**
     * 将Date时间(HH:mm:ss)转化为时间字符串
     * @param date 时间（Date）
     * @return 时间（String）
     */
    public static String formatToShortTime(Date date){
        if(date == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        return formatDate(date, "HH:mm:ss");
    }    
    
    
    /**
     * 计算两个Calendar日期的时间差，可选择返回值单位；如果第一个日历的日期发生在第二个日历之后，返回一个负值
     * @param calendar1 开始日期（Calendar）
     * @param calendar2 结束日期（Calendar）
     * @param timeUnit  返回值单位（TIME_UNIT）
     * @return 两个日期间的时间差（long）
     */
    public static long getDiff(Calendar calendar1, Calendar calendar2,
            TIME_UNIT timeUnit){
        
        if(calendar1 == null || calendar2 == null || timeUnit == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        
        long timeDiffInMillis = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
        
        switch(timeUnit){
            case MILLIS:
                return timeDiffInMillis;
            case SECS:
                return timeDiffInMillis/MILLIS_IN_SEC;
            case MINS:
                return timeDiffInMillis/MILLIS_IN_MIN;
            case HOURS:
                return timeDiffInMillis/MILLIS_IN_HOUR;
            case DAYS:
                return timeDiffInMillis/MILLIS_IN_DAY;
            default:
                return timeDiffInMillis;
        }
        
    }


    /**
     * 计算两个Date日期的时间差，可选择返回值单位；如果第一个日历的日期发生在第二个日历之后，返回一个负值
     * @param date1    开始日期（Date）
     * @param date2    结束日期（Date）
     * @param timeUnit 返回值单位（TIME_UNIT）
     * @return 两个日期间的时间差（long）
     */
    public static long getDiff(Date date1, Date date2, TIME_UNIT timeUnit){
       if(date1 == null || date2 == null || timeUnit == null){
           throw new NullPointerException();
       }
        
       Calendar calendar1 = Calendar.getInstance();
       calendar1.setTime(date1);
        
       Calendar calendar2 = Calendar.getInstance();
       calendar2.setTime(date2);
       
       return getDiff(calendar1, calendar2, timeUnit);
       
    }


    /**
     * 将给定的时间量添加到Calendar日期中，如果给定的增量为负数，则减少时间
     * @param calendar 日期（Calendar）
     * @param amount   增量（long）
     * @param timeUnit 增量的时间单位（TIME_UNIT）
     * @return 新日期（Calendar）
     */
    public static Calendar addTime(Calendar calendar, long amount, TIME_UNIT timeUnit){
        if(calendar == null){
            throw new NullPointerException(INVALID_CAL_ERR);
        } 
        switch(timeUnit){
            case MILLIS:
                calendar.setTimeInMillis(calendar.getTimeInMillis()+amount);
                return calendar;
            case SECS:
                long secondsToAdd = calendar.getTimeInMillis() + amount*MILLIS_IN_SEC;
                calendar.setTimeInMillis(secondsToAdd);
                return calendar;
            case MINS:
                long minsToAdd = calendar.getTimeInMillis()+ amount*MILLIS_IN_MIN;
                calendar.setTimeInMillis(minsToAdd);
                return calendar;
            case HOURS:
                long hoursToAdd = calendar.getTimeInMillis() + amount*MILLIS_IN_HOUR;
                calendar.setTimeInMillis(hoursToAdd);
                return calendar;
            case DAYS:
                long daysToAdd = calendar.getTimeInMillis() + amount*MILLIS_IN_DAY;
                calendar.setTimeInMillis(daysToAdd);
                return calendar;
            default:
                return null;
        }
    }


    /**
     * 将给定的时间量添加到Date日期中，如果给定的增量为负数，则减少时间
     * @param date     日期（Date）
     * @param amount   增量（long）
     * @param timeUnit 增量的时间单位（TIME_UNIT）
     * @return 新日期（Date）
     */
    public static Date addTime(Date date, long amount, TIME_UNIT timeUnit){
        if(date == null){
            throw new NullPointerException(INVALID_DATE_ERR);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        addTime(cal, amount, timeUnit);
        return cal.getTime();
    }

}