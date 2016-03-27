package org.javacogs;

import java.util.*;

/**
 * StrUtil provides utility methods for manipulating strings and string
 * buffers.
 *
 * @author Thornton Rose
 */
public final class StrUtil {
   /**
    * Private constructor, so class cannot be instatiated.
    */
   private StrUtil() {
   }

   // -------------------------------------------------------------------------
   // conversion functions
   // -------------------------------------------------------------------------

   /**
    * Gets the boolean value of the given string, such that the string "true",
    * ignoring case, => <i>true</i>. Anything else => <i>false</i>.
    *
    * @param str String from which to get boolean value.
    *
    * @return Boolean value of given string.
    */
   public static boolean booleanValue(String str) {
      return Boolean.valueOf(str).booleanValue();
   }

   /**
    * Gets the integer value of the given string.
    *
    * @param str String from which to get integer value.
    *
    * @return Integer value of given string.
    */
   public static int intValue(String str) throws NumberFormatException {
      return Integer.parseInt(str);
   }

   /**
    * Gets the integer value of the given string. If the string cannot be
    * converted to an integer value, the default value is returned.
    *
    * @param str String from which to get integer value.
    * @param def Default integer value.
    *
    * @return Integer value of given string.
    */
   public static int intValue(String str, int def) {
      try {
         return Integer.parseInt(str);
      } catch(NumberFormatException ex) {
         return def;
      }
   }

   // -------------------------------------------------------------------------
   // indexOf
   // -------------------------------------------------------------------------

   /**
    * Find the index of a string in the given string.
    *
    * @param str    String to search.
    * @param target String to find.
    *
    * @return Index of given string. -1 if str or target is null.
    */
   public static int indexOf(String str, String target) {
      return ((str == null) || (target == null)) ? -1 : str.indexOf(target);
   }

   /**
    * Find the index of a string in the given string starting at the given
    * index.
    *
    * @param str    String to search.
    * @param target String to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given string. -1 if str or target is null.
    */
   public static int indexOf(String str, String target, int start) {
      return ((str == null) || (target == null)) ? -1 : 
         str.indexOf(target, start);
   }

   /**
    * Find the index of a character in the given string.
    *
    * @param str    String to search.
    * @param target String to find.
    *
    * @return Index of given string. -1 if str is null.
    */
   public static int indexOf(String str, char target) {
      return (str == null) ? -1 : str.indexOf(target);
   }

   /**
    * Find the index of a character in the given string starting at the given
    * index.
    *
    * @param str    String to search.
    * @param target String to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given string. -1 if str or target is null.
    */
   public static int indexOf(String str, char target, int start) {
      return (str == null) ? -1 : str.indexOf(target, start);
   }

   /**
    * Find the index of a string in the given buffer.
    *
    * @param sb     Buffer to search.
    * @param target String to find.
    *
    * @return Index of given string. -1 if sb or target is null.
    */
   public static int indexOf(StringBuffer sb, String target) {
      return indexOf(sb, target, 0);
   }

   /**
    * Find the index of a string in the given buffer starting from the given
    * position.
    *
    * @param sb     Buffer to search.
    * @param target String to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given string. -1 if sb or target is null.
    */
   public static int indexOf(StringBuffer sb, String target, int start) {
      int index = -1;

      if ((sb != null) && (target != null) && (target.length() > 0)) {
         for (int i = start; i < sb.length(); i ++) {
            int j = i + target.length();

            if (j > sb.length()) {
               break;
            }

            if (sb.substring(i, j).equals(target)) {
               index = i;
               break;
            }
         }
      }

      return index;
   }

   /**
    * Find the index of a character in the given buffer.
    *
    * @param sb     Buffer to search.
    * @param target Character to find.
    *
    * @return Index of given character. -1 if sb is null.
    */
   public static int indexOf(StringBuffer sb, char target) {
      return indexOf(sb, target, 0);
   }

   /**
    * Find the index of a character in the given buffer starting from the given
    * position.
    *
    * @param sb     Buffer to search.
    * @param target Character to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given character. -1 if sb is null.
    */
   public static int indexOf(StringBuffer sb, char target, int start) {
      int index = -1;

      if (sb != null) {
         for (int i = start; i < sb.length(); i ++) {
            if (sb.charAt(i) == target) {
               index = i;
               break;
            }
         }
      }

      return index;
   }

   // -------------------------------------------------------------------------
   // lastIndexOf
   // -------------------------------------------------------------------------

   /**
    * Find the last index of a string in the given string.
    *
    * @param str    String to search.
    * @param target String to find.
    *
    * @return Index of given string. -1 if str or target is null.
    */
   public static int lastIndexOf(String str, String target) {
      return ((str == null) || (target == null)) ? -1 : 
         str.lastIndexOf(target);
   }

   /**
    * Find the last index of a string in the given string starting at the
    * given index.
    *
    * @param str    String to search.
    * @param target String to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given string. -1 if str or target is null.
    */
   public static int lastIndexOf(String str, String target, int start) {
      return ((str == null) || (target == null)) ? -1 :
         str.lastIndexOf(target, start);
   }

   /**
    * Find the last index of a character in the given string.
    *
    * @param str    String to search.
    * @param target String to find.
    *
    * @return Index of given string. -1 if str is null.
    */
   public static int lastIndexOf(String str, char target) {
      return (str == null) ? -1 : str.lastIndexOf(target);
   }

   /**
    * Find the last index of a character in the given string starting at the
    * given index.
    *
    * @param str    String to search.
    * @param target String to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given string. -1 if str is null.
    */
   public static int lastIndexOf(String str, char target, int start) {
      return (str == null) ? -1 : str.lastIndexOf(target, start);
   }

   /**
    * Find the last index of a string in the given buffer.
    *
    * @param sb     Buffer to search.
    * @param target String to find.
    *
    * @return Index of given string. -1 if sb or target is null.
    */
   public static int lastIndexOf(StringBuffer sb, String target) {
      return (sb == null) ? -1 : lastIndexOf(sb, target, sb.length() - 1);
   }

   /**
    * Find the last index of a string in the given buffer starting from the
    * given position.
    *
    * @param sb     Buffer to search.
    * @param target String to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given string. -1 if sb or target is null.
    */
   public static int lastIndexOf(StringBuffer sb, String target, int start) {
      int index = -1;

      if ((sb != null) && (target != null) && (target.length() > 0)) {
         for (int i = sb.length() - 1; i >= start; i --) {
            int j = i + target.length();

            if (j > sb.length()) {
               break;
            }

            if (sb.substring(i, j).equals(target)) {
               index = i;
               break;
            }
         }
      }

      return index;
   }

   /**
    * Find the last index of a character in the given buffer.
    *
    * @param sb     Buffer to search.
    * @param target Character to find.
    *
    * @return Index of given character. -1 if sb is null.
    */
   public static int lastIndexOf(StringBuffer sb, char target) {
      return (sb == null) ? -1 : lastIndexOf(sb, target, sb.length() - 1);
   }

   /**
    * Find the last index of a character in the given buffer starting from the
    * given position.
    *
    * @param sb     Buffer to search.
    * @param target Character to find.
    * @param start  Index at which to start search.
    *
    * @return Index of given character. -1 if sb is null.
    */
   public static int lastIndexOf(StringBuffer sb, char target, int start) {
      int index = -1;

      if (sb != null) {
         for (int i = sb.length() - 1; i >= start; i --) {
            if (sb.charAt(i) == target) {
               index = i;
               break;
            }
         }
      }

      return index;
   }

   // -------------------------------------------------------------------------
   // count
   // -------------------------------------------------------------------------

   /**
    * Count the occurrences of a character in a string.
    *
    * @param str    String in which to count occurrences.
    * @param target Character to count.
    *
    * @return Number of occurrences.
    */
   public static int count(String str, char target) {
      return count(str, String.valueOf(target));
   }

   /**
    * Count the occurrences of one string in another string.
    *
    * @param str    String in which to count occurrences.
    * @param target String to count.
    *
    * @return Number of occurrences.
    */
   public static int count(String str, String target) {
      // Note: It seemed better to do the counting here than to convert the
      // string to a string buffer, which would cause two passes through the
      // string.
      
      int count = 0;

      if (str != null) {
         int i = str.indexOf(target);

         while (i > -1) {
            count ++;
            i = str.indexOf(target, i + 1);
         }
      }

      return count;
   }

   /**
    * Count the occurrences of a character in a string buffer.
    *
    * @param sb     Buffer in which to count occurrences.
    * @param target Character to count.
    *
    * @return Number of occurrences.
    */
   public static int count(StringBuffer sb, char target) {
      return count(sb, String.valueOf(target));
   }

   /**
    * Count the occurrences of a string in a string buffer.
    *
    * @param sb     Buffer in which to count occurrences.
    * @param target String to count.
    *
    * @return Number of occurrences.
    */
   public static int count(StringBuffer sb, String target) {
      int count = 0;
      int i = indexOf(sb, target);

      while (i > -1) {
         count ++;
         i = indexOf(sb, target, i + 1);
      }

      return count;
   }

   // -------------------------------------------------------------------------
   // trim
   // -------------------------------------------------------------------------

   // trim:
   /**
    * Trim whitespace from the beginning and end of a string.
    *
    * @param str String to trim
    *
    * @return Trimmmed string; empty string if given string is null.
    */
   public static String trim(String str) {
      return (str == null) ? "" : str.trim();
   }

   // trim:
   /**
    * Trim whitespace from the beginning and end of a string buffer.
    *
    * @param sb String buffer to trim.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer trim(StringBuffer sb) {
      if (sb != null) {
         int i = 0;

         while (i < sb.length()) {
            if (Character.isWhitespace(sb.charAt(i))) {
               sb.deleteCharAt(i);
            } else {
               i ++;
            }
         }
      }

      return sb;
   }

   // -------------------------------------------------------------------------
   // left
   // -------------------------------------------------------------------------

   /**
    * Get the left part of a string.
    *
    * @param str       String from which to get part.
    * @param forLength Length of part to get.
    *
    * @return Left part of string. Empty string if given string is null.
    */
   public static String left(String str, int forLength) {
      return (str == null) ? "" : str.substring(0, forLength);
   }

   /**
    * Get the left part of a string buffer.
    *
    * @param sb        Buffer from which to get left part.
    * @param forLength Length of part to get.
    *
    * @return Left part of buffer. Empty string if given buffer is null.
    */
   public static String left(StringBuffer sb, int forLength) {
      return (sb == null) ? "" : sb.substring(0, forLength);
   }

   // -------------------------------------------------------------------------
   // right
   // -------------------------------------------------------------------------

   /**
    * Get the right part of a string.
    *
    * @param str       String from which to get part.
    * @param forLength Length of part to get.
    *
    * @return Right part of string. Empty string if given string is null.
    */
   public static String right(String str, int forLength) {
      return (str == null) ? "" : str.substring(str.length() - forLength);
   }

   /**
    * Get the right part of a string buffer.
    *
    * @param sb        Buffer from which to get right part.
    * @param forLength Length of part to get.
    *
    * @return Right part of buffer. Empty string if given buffer is null.
    */
   public static String right(StringBuffer sb, int forLength) {
      return (sb == null) ? "" : sb.substring(sb.length() - forLength);
   }

   // -------------------------------------------------------------------------
   // substring
   // -------------------------------------------------------------------------

   /**
    * Get part of a string.
    *
    * @param str       String from which to get part.
    * @param start     Index at which to start.
    *
    * @return Part of string. Empty string if given string is null.
    */
   public static String substring(String str, int start) {
      return (str == null) ? "" : str.substring(start);
   }

   /**
    * Get part of a string.
    *
    * @param str       String from which to get part.
    * @param start     Index at which to start.
    * @param forLength Length of part to get.
    *
    * @return Part of string. Empty string if given string is null.
    */
   public static String substring(String str, int start, int forLength) {
      return (str == null) ? "" : str.substring(start, start + forLength);
   }

   /**
    * Get part of a string buffer.
    *
    * @param sb        Buffer from which to get part.
    * @param start     Index at which to start.
    *
    * @return Part of given buffer. Empty string if given buffer is null.
    */
   public static String substring(StringBuffer sb, int start) {
      return (sb == null) ? "" : sb.substring(start);
   }

   /**
    * Get part of a string buffer.
    *
    * @param sb        Buffer from which to get part.
    * @param start     Index at which to start.
    * @param forLength Length of part.
    *
    * @return Part of given buffer. Empty buffer if given buffer is null.
    */
   public static String substring(StringBuffer sb, int start, 
         int forLength) {
      return (sb == null) ? "" : sb.substring(start, start + forLength);
   }

   // -------------------------------------------------------------------------
   // padLeft
   // -------------------------------------------------------------------------

   /**
    * Pad the given string on the left to the given size with spaces. If the
    * given string is longer than the specified size, it is truncated.
    *
    * @param str    String to pad.
    * @param toSize Desired string length.
    *
    * @return String padded on left.
    */
   public static String padLeft(String str, int toSize) {
      return (str == null) ? "" : padLeft(str, toSize, ' ');
   }

   /**
    * Pad the given string on the left to the given size with the given
    * character. If the given string is longer than the specified size, it is
    * truncated.
    *
    * @param str      String to pad.
    * @param toSize   Desired string length.
    * @param withChar Character to use for padding.
    *
    * @return String padded on left.
    */
   public static String padLeft(String str, int toSize, char withChar) {
      return (str == null) ? "" : 
         padLeft(new StringBuffer(str), toSize, withChar).toString();
   }

   /**
    * Pad the given buffer on the left to the given size with spaces. If the
    * buffer is longer than the specified size, it is truncated.
    *
    * @param sb     Buffer to pad.
    * @param toSize Desired length.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer padLeft(StringBuffer sb, int toSize) {
      return padLeft(sb, toSize, ' ');
   }

   /**
    * Pad the given buffer on the left to the given size with the given
    * character. If the buffer is longer than the specified size, it is
    * truncated.
    *
    * @param sb       Buffer to pad.
    * @param toSize   Length to which to pad str.
    * @param withChar Character to use for padding.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer padLeft(
         StringBuffer sb, int toSize, char withChar) {
      // If the given buffer is longer than the given size, truncate it.
      if (sb.length() > toSize) {
         sb.setLength(toSize);
      } else {
         // If the length of the buffer is less than the padding size, append
         // enough copies of the padding character to make up the difference.
         // (That is, pad with [size - buffer length] pad characters.)
         if (sb.length() < toSize) {
            sb.insert(0,
               replicate(new StringBuffer(), withChar, toSize - sb.length()));
         }
      }

      // Return the padded buffer.
      return sb;
   }

   // -------------------------------------------------------------------------
   // padRight
   // -------------------------------------------------------------------------

   /**
    * Pad the given string on the right to the given size with spaces. If the
    * given string is longer than the specified size, it is truncated.
    *
    * @param str    String to pad.
    * @param toSize Desired string length.
    *
    * @return String padded on right.
    */
   public static String padRight(String str, int toSize) {
      return (str == null) ? "" : padRight(str, toSize, ' ');
   }

   /**
    * Pad the given string on the right to the given size with the given
    * character. If the given string is longer than the specified size, it is
    * truncated.
    *
    * @param str      String to pad.
    * @param toSize   Desired string length.
    * @param withChar Character to use for padding.
    *
    * @return String padded on right.
    */
   public static String padRight(String str, int toSize, char withChar) {
      return (str == null) ? "" : 
         padRight(new StringBuffer(str), toSize, withChar).toString();
   }

   /**
    * Pad the given buffer on the right to the given size with spaces. If the
    * buffer is longer than the specified size, it is truncated.
    *
    * @param sb     Buffer to pad.
    * @param toSize Desired length.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer padRight(StringBuffer sb, int toSize) {
      return padRight(sb, toSize, ' ');
   }

   /**
    * Pad the given buffer on the right to the given size with the given
    * character. If the buffer is longer than the specified size, it is
    * truncated.
    *
    * @param sb       Buffer to pad.
    * @param toSize   Length to which to pad str.
    * @param withChar Character to use for padding.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer padRight(
         StringBuffer sb, int toSize, char withChar) {
      // If the given buffer is longer than the given size, truncate it.
      if (sb.length() > toSize) {
         sb.setLength(toSize);
      } else {
         // If the length of the buffer is less than the padding size, append
         // enough copies of the padding character to make up the difference.
         // (That is, pad with [size - buffer length] pad characters.)
         if (sb.length() < toSize) {
            sb.append(replicate(
               new StringBuffer(), withChar, toSize - sb.length()));
         }
      }

      // Return the padded buffer.
      return sb;
   }

   // -------------------------------------------------------------------------
   // padCenter
   // -------------------------------------------------------------------------

   /**
    * Pad the given string to the center for the given size with spaces. If the
    * given string is longer than the specified size, it is truncated.
    *
    * @param str    String to pad.
    * @param toSize Desired string length.
    *
    * @return String padded to center.
    */
   public static String padCenter(String str, int toSize) {
      return (str == null) ? "" : padCenter(str, toSize, ' ');
   }

   /**
    * Pad the given string to the center in the given size with the given
    * character. If the given string is longer than the specified size, it is
    * truncated.
    *
    * @param str      String to pad.
    * @param toSize   Desired string length.
    * @param withChar Character to use for padding.
    *
    * @return String padded to center.
    */
   public static String padCenter(String str, int toSize, char withChar) {
      return (str == null) ? "" : 
         padCenter(new StringBuffer(str), toSize, withChar).toString();
   }

   /**
    * Pad the given buffer to the center in the given size with spaces. If the
    * buffer is longer than the specified size, it is truncated.
    *
    * @param sb     Buffer to pad.
    * @param toSize Desired length.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer padCenter(StringBuffer sb, int toSize) {
      return padCenter(sb, toSize, ' ');
   }

   /**
    * Pad the given buffer to the center in the given size with the given
    * character. If the buffer is longer than the specified size, it is
    * truncated.
    *
    * @param sb       Buffer to pad.
    * @param toSize   Length to which to pad str.
    * @param withChar Character to use for padding.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer padCenter(
         StringBuffer sb, int toSize, char withChar) {
      // If the given buffer is longer than the given size, truncate it.
      if (sb.length() > toSize) {
         sb.setLength(toSize);
      } else {
         // If the length of the buffer is less than the padding size, append
         // enough copies of the padding character to each side to make up the
         // difference.  (That is, pad each side with (size - length)/2
         // characters.)
         if (sb.length() < toSize) {
            int padLength = toSize - sb.length();
            StringBuffer pad = replicate(
               new StringBuffer(), withChar, padLength / 2);
            sb.insert(0, pad);
            sb.append(pad);

            // If the pad length is odd, the padding could not be equally
            // divided across the beginning and end of the buffer. So, add
            // one more character to the end.
            if ((padLength % 2) != 0) {
               sb.append(withChar);
            }
         }
      }

      // Return the padded buffer.
      return sb;
   }

   // -------------------------------------------------------------------------
   // replace
   // -------------------------------------------------------------------------

   /**
    * Replace one string with another.
    *
    * @param str         String in which to do replacing.
    * @param target      String to replace.
    * @param replacement String with which to replace target.
    *
    * @return String where target is replaced with replacement.
    */
   public static String replace(String str, String target, 
         String replacement) {
      return (str == null) ? "" : 
         replace(new StringBuffer(str), target, replacement).toString();
   }

   /**
    * Replace one character with another.
    *
    * @param str         String in which to do replacing.
    * @param target      Character to replace.
    * @param replacement Character with which to replace target.
    *
    * @return String where target is replaced with replacement.
    */
   public static String replace(String str, char target, char replacement) {
      return (str == null) ? "" : 
         replace(new StringBuffer(str), target, replacement).toString();
   }

   /**
    * Replace one string with another within in the given string buffer.
    *
    * @param sb          Buffer in which to do replacing.
    * @param target      String to replace.
    * @param replacement String with which to replace target.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer replace(StringBuffer sb, String target, 
         String replacement) {
      int ol = target.length();  // Length of string to replace.
      int s = 0;                 // Starting position for indexOf().
      int i = 0;                 // Index of old string.

      if ((! target.equals(replacement)) && (ol > 0)) {
         while (s < sb.length()) {
            i = indexOf(sb, target, s);

            if (i < 0) {
               break;
            }

            sb.delete(i, i + ol);
            sb.insert(i, replacement);

            s = i + replacement.length();
         }
      }

      return sb;
   }

   /**
    * Replace one character with another within in the given string buffer.
    *
    * @param sb          Buffer in which to do replacing.
    * @param target      Character to replace.
    * @param replacement Character with which to replace target.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer replace(StringBuffer sb, char target, 
         char replacement) {
      if (target != replacement) {
         for (int i = 0; i < sb.length(); i ++) {
            if (sb.charAt(i) == target) {
               sb.setCharAt(i, replacement);
            }
         }
      }

      return sb;
   }

   // -------------------------------------------------------------------------
   // replicate
   // -------------------------------------------------------------------------

   /**
    * Replicate the given character n times.
    *
    * @param c Character to replicate.
    * @param n Number of times to replicate c.
    *
    * @return String that contains n copies of c.
    */
   public static String replicate(char c, int n) {
      return replicate(new StringBuffer(), c, n).toString();
   }

   /**
    * Replicate the given string n times.
    *
    * @param str Character to replicate.
    * @param n   Number of times to replicate c.
    *
    * @return String that contains n copies of str.
    */
   public static String replicate(String str, int n) {
      return replicate(new StringBuffer(), str, n).toString();
   }

   /**
    * Replicate the given character n times into the given buffer.
    *
    * @param sb Buffer to fill.
    * @param c  Character to replicate.
    * @param n  Number of times to replicate c.
    *
    * @return StringBuffer that contains n copies of c.
    */
   public static StringBuffer replicate(StringBuffer sb, char c, int n) {
      // Append n copies of the given character to the buffer.
      for (int i = 0; i < n; i ++) {
         sb.append(c);
      }

      // Return the buffer.
      return sb;
   }

   /**
    * Replicate the given string n times into the given buffer.
    *
    * @param sb   Buffer to fill.
    * @param str  String to replicate.
    * @param n    Number of times to replicate str.
    *
    * @return StringBuffer that contains n copies of str.
    */
   public static StringBuffer replicate(StringBuffer sb, String str, int n) {
      // Append n copies of the given string to the buffer.
      for (int i = 0; i < n; i ++) {
         sb.append(str);
      }

      // Return the buffer.
      return sb;
   }

   // -------------------------------------------------------------------------
   // wordWrap
   // -------------------------------------------------------------------------

   /**
    * Wrap the given string at the given width on word boundaries. The line
    * terminator is '\n'. Any line formatting using '\n' in the given string is
    * preserved.
    *
    * @param str   String to wrap.
    * @param width Width at which to wrap string.
    *
    * @return Wrapped string.
    */
   public static String wordWrap(String str, int width) {
      return (str == null) ? "" : 
         wordWrap(new StringBuffer(str), width).toString();
   }

   /**
    * Wrap the given buffer at the given width on word boundaries. The line
    * terminator is '\n'. Any line formatting using '\n' in the given buffer is
    * preserved.
    *
    * @param sb     Buffer to wrap.
    * @param width  Width at which to wrap.
    *
    * @return Wrapped buffer.
    */
   public static StringBuffer wordWrap(StringBuffer sb, int width) {
      char c;
      int  colsAcross = 0;
      int  sIndex = -1;
      int  i = 0;

      // Iterate through the buffer.
      while (i < sb.length()) {
         // Get the character.
         c = sb.charAt(i);
         colsAcross ++;

         switch (c) {
            // If newline, reset column counter.
            case '\n':
               colsAcross = 0;
               break;

            // If space or tab, save index.
            case ' ':
            case '\t':
               sIndex = i;
               break;
         }

         // If width characters have been counted, ...
         if (colsAcross == width) {
            // If space or tab before current character, put newline there.
            // Else, insert newline after current index.
            if (sIndex > -1) {
               sb.setCharAt(sIndex, '\n');
               colsAcross = 0;
            } else {
               i ++;

               if (i < sb.length()) {
                  sb.insert(i, '\n');
                  colsAcross = 0;
               }
            }
         }

         i ++;
      }

      // Return the wrapped buffer.
      return sb;
   }

   // -------------------------------------------------------------------------
   // wrap
   // -------------------------------------------------------------------------

   /**
    * Wrap the given string at the given width. The line terminator is '\n'.
    * Any line formatting using '\n' in the given string is preserved.
    *
    * @param str   String to wrap.
    * @param width Width at which to wrap string.
    *
    * @return Wrapped string.
    */
   public static String wrap(String str, int width) {
      return (str == null) ? "" : 
         wrap(new StringBuffer(str), width).toString();
   }

   /**
    * Wrap the given buffer at the given width. The line terminator is '\n'.
    * Any line formatting using '\n' in the given buffe is preserved.
    *
    * @param sb     Buffer to wrap.
    * @param width  Width at which to wrap.
    *
    * @return Wrapped buffer.
    */
   public static StringBuffer wrap(StringBuffer sb, int width) {
      char c;
      int  colsAcross = 0;
      int  sIndex = -1;
      int  i = 0;

      // Iterate through the buffer.
      while (i < sb.length()) {
         // Get the character.
         c = sb.charAt(i);
         colsAcross ++;

         // If newline, reset column counter.
         if (c == '\n') {
            colsAcross = 0;
         }

         // If width characters have been counted, insert newline after current
         // index.
         if (colsAcross == width) {
            i ++;

            if (i < sb.length()) {
               sb.insert(i, '\n');
               colsAcross = 0;
            }
         }

         i ++;
      }

      // Return the wrapped buffer.
      return sb;
   }

   // -------------------------------------------------------------------------
   // split
   // -------------------------------------------------------------------------

   /**
    * Split a string into an array of strings.
    * <br><br>
    * Example:
    * <blockquote>
    * s1 = "A,B"
    * split(s1, ",") => { "A", "B" }
    * </blockquote>
    *
    * @param str       String to split.
    * @param delimiter Delimiter on which to split the string.
    *
    * @return Array of strings.
    */
   public static String[] split(String str, String delimiter) {
      int          delimIndex = 0;
      int          startIndex = 0;
      int          delimCount = 0;
      StringBuffer sb = new StringBuffer(str);
      String[]     arr = {};

      if (str != null) {
         // Append delimiter to buffer (which makes parsing easier).
         sb.append(delimiter);

         // Count delimiters.
         delimCount = count(sb, delimiter);

         // If there is at least one delimiter, ...
         if (delimCount > 0) {
            arr = new String[delimCount];

            // Iterate through the buffer.
            for (int i = 0; i < arr.length; i ++) {
               // Get index of delimiter.
               delimIndex = indexOf(sb, delimiter, startIndex);

               // Extract a substring from the buffer up to but not including the
               // delimiter and put it in the array.
               arr[i] = sb.substring(startIndex, delimIndex);

               // Set the start index to the next position after the delimiter.
               startIndex = delimIndex + delimiter.length();
            }
         }
      }

      // Return the array.
      return arr;
   }

   /*
   public static StringBuffer[] split(StringBuffer sb) {
   }
   */

   // -------------------------------------------------------------------------
   // join
   // -------------------------------------------------------------------------

   /**
    * Create a delimited string from an array of strings.
    * <br><br>
    * Example:
    * <blockquote>
    * a1 = { "A", "B" }
    * join(a1, ",") => "A,B"
    * </blockquote>
    *
    * @param arr       Array of strings to join.
    * @param delimiter Delimiter between strings.
    *
    * @return Delimited string.
    */
   public static String join(String[] arr, String delimiter) {
      // Create new buffer.
      StringBuffer sb = new StringBuffer();

      // For each string in the array ...
      for (int i = 0; i < arr.length; i ++) {
         // If not the first one, append delimiter to buffer.
         if (i > 0) {
            sb.append(delimiter);
         }

         // Append string to buffer.
         sb.append(arr[i]);
      }

      // Return delimited string.
      return sb.toString();
   }

   /*
   public static StringBuffer join(StringBuffer[] arr) {
   }
   */

   // -------------------------------------------------------------------------
   // merge
   // -------------------------------------------------------------------------

   /**
    * Create a delimited string that contains pairs of delimited strings from
    * two arrays.
    * <br><br>
    * Example:
    * <blockquote>
    * a1 = { "A", "B" }
    * a2 = { "1", "2" }
    * merge(a1, a2, "=", ",") => "A=1,B=2"
    * </blockquote>
    *
    * @param arr1      First array of strings to merge.
    * @param arr2      Second array of strings to merge.
    * @param pairDelim Delimiter between strings of each pair.
    * @param strDelim  Delimiter between strings.
    *
    * @return Delimited string.
    */
   public static String merge(String[] arr1, String[] arr2, String pairDelim,
         String strDelim) {
      // Create new buffer.
      StringBuffer sb = new StringBuffer();

      // For each string in the array ...
      for (int i = 0; i < arr1.length; i ++) {
         // If not the first one, append delimiter to buffer.
         if (i > 0) {
            sb.append(strDelim);
         }

         // Append strings to buffer.
         sb.append(arr1[i]).append(pairDelim).append(arr2[i]);
      }

      // Return delimited string.
      return sb.toString();
   }
   
   // -------------------------------------------------------------------------
   // hexEncode
   // -------------------------------------------------------------------------

   /**
    * Encodes the given string as a series of hexadecimal values delimited with
    * colons. (This method is useful for converting an encrypted string to
    * printable form.)
    * <br><br>
    * Example:
    * <br><br>
    * ABC --> 41:42:43
    *
    * @param str The string to be encoded.
    *
    * @see #hexDecode(String)
    */
   public static String hexEncode(String str) {
      return (str == null) ? "" : 
         hexEncode(new StringBuffer(str)).toString();
   }

   /**
    * Encodes the given string buffer as a series of hexadecimal values
    * delimited with colons.
    * <br><br>
    * Example:
    * <br><br>
    * ABC --> 41:42:43
    *
    * @param sb The buffer to be encoded.
    */
   public static StringBuffer hexEncode(StringBuffer sb) {
      String temp = sb.toString();

      sb.setLength(0);

      for (int i = 0; i < temp.length(); i ++) {
         if (i > 0) {
            sb.append(':');
         }

         sb.append(Integer.toHexString((int) temp.charAt(i)));
      }

      return sb;
   }

   // -------------------------------------------------------------------------
   // hexDecode
   // -------------------------------------------------------------------------

   /**
    * Decodes a string from another string that contains a series of
    * hexadecimal values delimited with colons. Unrecognized tokens are
    * converted to '?'.
    * <br><br>
    * Examples:
    * <br><br>
    * 41:42:43 --> ABC<br>
    * 41:zz:43 --> A?C
    *
    * @param str The string to be decoded.
    */
   public static String hexDecode(String str) {
      return (str == null) ? "" : 
         hexDecode(new StringBuffer(str)).toString();
   }

   /**
    * Decodes a buffer that contains a series of hexadecimal values delimited
    * with colons. Unrecognized tokens are converted to '?'.
    *
    * <p>Examples:
    * <pre>
    * 41:42:43 --> ABC<br>
    * 41:zz:43 --> A?C
    * </pre>
    *
    * @param sb The buffer to be decoded.
    */
   public static StringBuffer hexDecode(StringBuffer sb) {
      StringTokenizer tokenizer = new StringTokenizer(sb.toString(), ":");
      String          token;

      sb.setLength(0);

      while (tokenizer.hasMoreTokens()) {
         token = tokenizer.nextToken();

         try {
            sb.append((char) Integer.parseInt(token, 16));
         } catch(NumberFormatException ex) {
            sb.append("?");
         }
      }

      return sb;
   }

   // -------------------------------------------------------------------------
   // ROT13
   // -------------------------------------------------------------------------

   /**
    * Transform the given string using the ROT13 algorithm.
    *
    * @param str String to transform.
    *
    * @return Transformed string.
    */
   public static String rot13(String str) {
      return str == null ? "" : rot13(new StringBuffer(str)).toString();
   }
   
   /**
    * Transform the given string buffer using the ROT13 algorithm.
    *
    * @param sb String buffer to transform.
    *
    * @return Reference to transformed buffer.
    */
   public static StringBuffer rot13(StringBuffer sb) {
      for (int i = 0; i < sb.length(); i ++) {
         sb.setCharAt(i, rot13(sb.charAt(i)));
      }

      return sb;
   }

   /**
    * Transform the given character with the ROT13 algorithm.
    *
    * @param c Character to transform.
    */
   public static char rot13(char c) {
      char ce;

      // Rotate forward/backward by swapping character from first half of set
      // to second half of set and vice versa (instead of using modulus). If
      // character is in range A-M or a-m, add 13. If character is in range N-Z
      // or n-z, subtract 13. Otherwise, do nothing to the character.

      if ( ((c >= 'A') && (c <= 'M')) ||
           ((c >= 'a') && (c <= 'm')) ) {
         ce = (char) ((int) c + 13);
      } else if ( ((c >= 'N') && (c <= 'Z')) ||
                  ((c >= 'n') && (c <= 'z')) ) {
         ce = (char) ((int) c - 13);
      } else {
         ce = c;
      }

      return ce;
   }

   // -------------------------------------------------------------------------
   // ROT13N5
   // -------------------------------------------------------------------------

   /**
    * Transform the given string with the ROT13N5 algorithm.
    *
    * @param str String to transform.
    *
    * @return Transformed string.
    */
   public static String rot13n5(String str) {
      return str == null ? "" : rot13n5(new StringBuffer(str)).toString();
   }

   /**
    * Transform the given string with the ROT13N5 algorithm.
    *
    * @param sb String buffer to transform.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer rot13n5(StringBuffer sb) {
      for (int i = 0; i < sb.length(); i ++) {
         sb.setCharAt(i, rot13n5(sb.charAt(i)));
      }

      return sb;
   }

   /**
    * Transform the given character with the ROT13N5 algorithm.
    *
    * @param s Character to transform.
    */
   public static char rot13n5(char c) {
      char ce;

      // Rotate forward/backward by swapping character from first half of set
      // to second half of set and vice versa (instead of using modulus). If
      // character is in range '0'-'4', add 5. If character is in range '5'-'9',
      // subtract 5. Otherwise, do nothing to the character.

      if ( (c >= '0') && (c <= '4') ) {
         // System.out.print("c = " + c);
         ce = (char) ((int) c + 5);
         // System.out.println(", ce = " + ce);
      } else if ( (c >= '5') && (c <= '9') ) {
         ce = (char) ((int) c - 5);
      } else {
         ce = rot13(c);
      }

      return ce;
   }

   //--------------------------------------------------------------------------
   // ROTASCII
   //--------------------------------------------------------------------------

   /**
    * Transform the given string with the ROTASCII algorithm.
    *
    * @param str  String to transform.
    * @param rlen Rotation length.
    *
    * @return Transformed string.
    */
   public static String rotAscii(String str, int rlen) {
      return str == null ? "" : 
         rotAscii(new StringBuffer(str), rlen).toString();
   }

   /**
    * Transform the given string with the ROTASCII algorithm.
    *
    * @param sb   String buffer to transform.
    * @param rlen Rotation length.
    *
    * @return Reference to modified buffer.
    */
   public static StringBuffer rotAscii(StringBuffer sb, int rlen) {
      for (int i = 0; i < sb.length(); i ++) {
         sb.setCharAt(i, rotAscii(sb.charAt(i), rlen));
      }

      return sb;
   }

   /**
    * Transform the given character with the ROTASCII algorithm.
    *
    * @param c    Character to transform.
    * @param rlen Rotation length.
    */
   public static char rotAscii(char c, int rlen) {
      int ce = ((int) c + rlen) % 256;
      
      if (ce < 0) {
         ce += 256;
      }

      return (char) ce;
   }
}
