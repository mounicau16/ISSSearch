package com.asnctaskexample.sample.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Mounica on 3/15/2018.
 */

public class IssUtils {

    /**
     * Convert time(long) to human's timestamp format in dd/MM/yyyy' 'HH:mm:ss format
     * @param millis
     * @return
     */
    public static String convertLongtoTimestamp(long millis){
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        TimeZone tz = TimeZone.getDefault();
        sdf.setTimeZone(tz);
        String riseTimeStr = sdf.format(calendar.getTime());
        return riseTimeStr;
    }
}
