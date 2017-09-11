package com.example.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.example.exception.domain.DatePatternMismatchException;

public final class DateUtils {

    private DateUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * This method will get the UTC current time stamp
     */
    public static String getUTCDate() {
        final TimeZone timeZone = TimeZone.getTimeZone("UTC");
        final Calendar calendar = Calendar.getInstance(timeZone);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.sss'Z'");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * This method is used to format the date to UTC timestamp. No time zone
     * conversions will be done.
     *
     * @param date
     * @return
     */
    public static String getUTCDateFormat(final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.sss'Z'");
        return simpleDateFormat.format(date);
    }

    public static java.sql.Timestamp getSqlStartDate(final String date) {
        if (date.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            final String startDate = date + " 00:00:00.000";
            return java.sql.Timestamp.valueOf(startDate);
        } else {
            throw new DatePatternMismatchException();

        }
    }

    public static java.sql.Timestamp getSqlEndDate(final String date) {
        if (date.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            final String endDate = date + " 24:00:00.000";
            return java.sql.Timestamp.valueOf(endDate);
        } else {
            throw new DatePatternMismatchException();

        }

    }
}