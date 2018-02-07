package blacar.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
    public static Date convert(Date datePrecisionToDay, short hours, short minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datePrecisionToDay);
        cal.set(Calendar.HOUR, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
