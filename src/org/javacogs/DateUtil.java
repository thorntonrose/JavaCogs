package org.javacogs;

import java.text.*;
import java.util.*;

/**
 * This class provides date utility functions.
 *
 * @author Thornton Rose
 */
public abstract class DateUtil {
   /**
    * Constructor -- Private so class cannot be instantiated.
    */
   private DateUtil() {
   }
   
   /**
    * Convert the given hours since midnight to a date/time. The date part will
    * be today's date.
    */
   public static Date time(float hours) {
      // Calculate hours, minutes, and seconds.
      int   h  = (int) hours;
      float md = (hours - h) * 60;
      int   m  = (int) (md);
      int   s  = (int) ((md - m) * 60);
      
      // Get calendar and set time.
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.set(Calendar.HOUR_OF_DAY, h);
      calendar.set(Calendar.MINUTE, m);
      calendar.set(Calendar.SECOND, s);
      
      // Return date/time.
      return calendar.getTime();
   }
   
   /**
    * Convert the given date to hours since midnight.
    *
    * @param date Date to convert.
    */
   public static float hours(Date date) {
      // Get calendar and get time as seconds.
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(date);
      int seconds = (calendar.get(Calendar.HOUR_OF_DAY) * 3600)
         + (calendar.get(Calendar.MINUTE) * 60)
         + calendar.get(Calendar.SECOND);

      // Calculate hours and return.
      return (float) seconds / 3600;
   }

   /**
    * Convert a string representation of a date to hours since midnight.
    *
    * @param date   Date to convert.
    * @param format Format of given date string.
    */
   public static float hours(String date, DateFormat dateFormat) {
      try {
         return hours(dateFormat.parse(date));
      } catch(ParseException ex) {
      }

      return (float) 0;
   }
}
