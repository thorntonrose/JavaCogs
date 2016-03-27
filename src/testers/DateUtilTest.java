package testers;

import java.text.*;
import java.util.*;
import org.javacogs.*;

/**
 * Test the DateUtil class.
 */
public final class DateUtilTest {
   public static void main(String[] args) {
      SimpleDateFormat timeFmt = new SimpleDateFormat("hh:mm a");
      SimpleDateFormat hoursFmt = new SimpleDateFormat("HH:mm");
      Date now = new Date();
      
      System.out.println(now);
      System.out.println(DateUtil.hours(now));
      System.out.println(DateUtil.hours("7:00 am", timeFmt));
      System.out.println(DateUtil.hours("1:30", hoursFmt));
      System.out.println(hoursFmt.format(DateUtil.time((float) 2.25)));
   }
}
