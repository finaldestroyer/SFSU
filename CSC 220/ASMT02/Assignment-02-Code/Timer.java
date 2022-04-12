/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Timer.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


public class Timer {
    private String CurrentTimeZone = null;
    private static String defaultTimeZone = "Pacific Standard Time";
    private static final TimeZone DF_TimeZoneLocation = TimeZone.getTimeZone("America/Los_Angeles");
    private final TimeZone timeZoneObject;
    private final String timeZoneName;
    private boolean isDst = false;

    public Timer() {
        this.timeZoneObject = DF_TimeZoneLocation;
        this.timeZoneName = defaultTimeZone;
    }

    public Timer(String timeZoneName) {
        this.timeZoneObject = findTimeZone(timeZoneName);
        this.timeZoneName = timeZoneObject.getDisplayName(isDst, TimeZone.LONG);
    }

    private TimeZone findTimeZone(String timeZoneName) {
        for (String supportedId : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(supportedId);

            // If it's the IANA ID.
            if (timeZoneName.equalsIgnoreCase(supportedId)) {
                return tz;
            }
            // If it matches the daylight version of the name.
            if (timeZoneName.equalsIgnoreCase(tz.getDisplayName(true, TimeZone.LONG))
                    || timeZoneName.equalsIgnoreCase(tz.getDisplayName(true, TimeZone.SHORT))) {
                isDst = true;
                return tz;
            }
            // If it matches the non-daylight version of the name.
            if (timeZoneName.equalsIgnoreCase(tz.getDisplayName(false, TimeZone.LONG))
                    || timeZoneName.equalsIgnoreCase(tz.getDisplayName(false, TimeZone.SHORT))) {
                isDst = false;
                return tz;
            }
        }
        return DF_TimeZoneLocation;
    }

    public static Timer setTimeZonePreference() {
        return null;
    }

    public Object getTimeZoneFormatted() {
        //Calendar now = Calendar.getInstance();
        //TimeZone timeZone = now.getTimeZone();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss [SSSS 'ms'] a z");
        df.setTimeZone(timeZoneObject);
        return df.format(new Date());
    }

    public String getNowTime(String s) {
        Calendar now = Calendar.getInstance();
        TimeZone timeZone = now.getTimeZone();
        System.out.println(now);
        return null;
    }
    public Object getChatTimestamp() {
        return null;
    }
}
