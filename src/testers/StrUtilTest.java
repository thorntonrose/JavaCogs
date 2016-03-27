package testers;

import org.javacogs.*;

/**
 * Test the StrUtil class.
 */
public final class StrUtilTest {   
   public static void main(String[] args) {
      String s1        = "This is a test.";
      String s2        = "abcde12345";
      String s3        = null;
      String s4        = null;
      StringBuffer sb1 = new StringBuffer(s1);
      StringBuffer sb2 = new StringBuffer(s2);

      System.out.println("s1 = [" + s1 + "]");
      System.out.println("s2 = [" + s2 + "]");
      System.out.println("sb1 = [" + sb1 + "]");
      System.out.println("sb2 = [" + sb2 + "]");
      
      // booleanValue
      System.out.println("booleanValue:");
      System.out.println("booleanValue(\"true\") = " + StrUtil.booleanValue("true"));
      System.out.println("booleanValue(\"\") = " + StrUtil.booleanValue(""));

      // intValue
      System.out.println("intValue:");
      
      try {
         System.out.println("intValue(\"123\") = " + StrUtil.intValue("123"));
         System.out.println("intValue(\"x\", 1) = " + StrUtil.intValue("x", 1));
         
         // This should throw an exception.
         System.out.println("intValue(\"x\") = ");
         System.out.println(StrUtil.intValue("x"));
      } catch(NumberFormatException ex) {
         System.out.println(ex);
      }

      // indexOf
      System.out.println("indexOf:");
      System.out.println("indexOf(s1, null) = " + StrUtil.indexOf(s1, null));
      System.out.println("indexOf(s1, 'i') = " + StrUtil.indexOf(s1, 'i'));
      System.out.println("indexOf(s1, \"is\") = " + StrUtil.indexOf(s1, "is"));
      System.out.println("indexOf(sb1, null) = " + StrUtil.indexOf(sb1, null));
      System.out.println("indexOf(sb1, 'i') = " + StrUtil.indexOf(sb1, 'i'));
      System.out.println("indexOf(sb1, \"is\") = " + StrUtil.indexOf(sb1, "is"));

      // lastIndexOf
      System.out.println("\nlastIndexOf:");
      System.out.println("lastIndexOf(s1, null) = " + StrUtil.lastIndexOf(s1, null));
      System.out.println("lastIndexOf(s1, 'i') = " + StrUtil.lastIndexOf(s1, 'i'));
      System.out.println("lastIndexOf(s1, \"is\") = " + StrUtil.lastIndexOf(s1, "is"));
      System.out.println("lastIndexOf(sb1, null) = " + StrUtil.lastIndexOf(sb1, null));
      System.out.println("lastIndexOf(sb1, 'i') = " + StrUtil.lastIndexOf(sb1, 'i'));
      System.out.println("lastIndexOf(sb1, \"is\") = " + StrUtil.lastIndexOf(sb1, "is"));

      // count
      System.out.println("\ncount:");
      System.out.println("count(s1, 'i') = " + StrUtil.count(s1, 'i'));

      // left
      System.out.println("\nleft:");
      System.out.println("left(s1, 4) = [" + StrUtil.left(s1, 4) + "]");
      System.out.println("left(sb1, 4) = [" + StrUtil.left(sb1, 4) + "]");

      // right:
      System.out.println("\nright:");
      System.out.println("right(s1, 5) = [" + StrUtil.right(s1, 5) + "]");
      System.out.println("right(sb1, 5) = [" + StrUtil.right(sb1, 5) + "]");

      // substring
      System.out.println("\nsubstring:");
      System.out.println("substring(s1, 1) = [" + StrUtil.substring(s1, 1) + "]");
      System.out.println("substring(s1, 1, 3) = [" + StrUtil.substring(s1, 1, 3) + "]");
      System.out.println("substring(sb1, 1) = [" + StrUtil.substring(sb1, 1) + "]");
      System.out.println("substring(sb2, 1, 3) = [" + StrUtil.substring(sb2, 1, 3) + "]");

      // padLeft
      System.out.println("\npadLeft:");
      System.out.println("padLeft(s1, 20) = [" + StrUtil.padLeft(s1, 20) + "]");
      System.out.println("padLeft(s1, 20, 'a') = [" + StrUtil.padLeft(s1, 20, 'a') + "]");

      // padRight
      System.out.println("\npadRight:");
      System.out.println("padRight(s1, 20) = [" + StrUtil.padRight(s1, 20) + "]");
      System.out.println("padRight(s1, 20, '*') = [" + StrUtil.padRight(s1, 20, '*') + "]");

      // padCenter
      System.out.println("\npadCenter:");
      System.out.println("padCenter(s1, s1.length()+4) = [" + StrUtil.padCenter(s1, s1.length()+4) + "]");
      System.out.println("padCenter(s1, s1.length()+4, '*') = [" + StrUtil.padCenter(s1, s1.length()+4, '*') + "]");
      System.out.println("padCenter(s1, s1.length()+5, '*') = [" + StrUtil.padCenter(s1, s1.length()+5, '*') + "]");

      // replace
      System.out.println("\nreplace:");
      System.out.println("replace(s1, 'i', 'y') = " + StrUtil.replace(s1, 'i', 'y'));
      System.out.println("replace(s1, \"is\", \"ees\") = [" + StrUtil.replace(s1, "is", "ees") + "]");
      System.out.println("replace(s1, \"is\", \"ish\") = [" + StrUtil.replace(s1, "is", "ish") + "]");

      // replicate
      System.out.println("\nreplicate:");
      System.out.println("replicate('*', 10) = [" + StrUtil.replicate('*', 10) + "]");
      System.out.println("replicate(\"abc\", 10) = [" + StrUtil.replicate("abc", 10) + "]");

      // wordWrap
      System.out.println("\nwordWrap:");
      System.out.println("wordWrap(s1, 6) = [" + StrUtil.wordWrap(s1, 6) + "]");
      System.out.println("wordWrap(s1, s1.length() + 1) = [" + StrUtil.wordWrap(s1, s1.length() + 1) + "]");
      System.out.println("wordWrap(s2, 6) = [" + StrUtil.wordWrap(s2, 6) + "]");

      // wrap
      System.out.println("\nwrap:");
      System.out.println("wrap(s1, 4) = [" + StrUtil.wrap(s1, 4) + "]");
      System.out.println("wrap(s1, s1.length() + 1) = [" + StrUtil.wrap(s1, s1.length() + 1) + "]");
      System.out.println("wrap(s2, 6) = [" + StrUtil.wrap(s2, 6) + "]");

      // split
      System.out.println("\nsplit:");

      String[] a1 = StrUtil.split("1,2,3", ",");
      System.out.println("a1 = split(\"1,2,3\", \",\")");

      for (int i = 0; i < a1.length; i ++) {
         System.out.println("a1[" + i + "] = [" + a1[i] + "]");
      }

      // join
      System.out.println("\njoin:");
      System.out.println("join(a1, \";\") = [" + StrUtil.join(a1, ";") + "]");

      // merge
      System.out.println("\nmerge:");

      String[] a2 = new String[] { "A", "B", "C" };
      System.out.println("a2 = { \"A\", \"B\", \"C\" }");
      System.out.println("merge(a2, a1, \"=\", \",\" = [" + StrUtil.merge(a2, a1, "=", ",") + "]");
      
      // hexEncode
      System.out.println("\nhexEncode:");

      s3 = StrUtil.hexEncode("abc\u000e\u000f");
      s4 = StrUtil.hexEncode("ABC");
      System.out.println("s3 = hexEncode(\"abc\\u000e\\u000f\") = [" + s3 + "]");
      System.out.println("s4 = hexEncode(\"ABC\") = [" + s4 + "]");

      // hexDecode
      System.out.println("\nhexDecode:");
      System.out.println("hexDecode(s3) = [" + StrUtil.hexDecode(s3) + "]");
      System.out.println("hexDecode(s4) = [" + StrUtil.hexDecode(s4) + "]");

      // ROT13      
      s3 = StrUtil.rot13(s2);
      System.out.println("\nrot13:");
      System.out.println("s3 = rot13(s2) = " + s3);
      System.out.println("rot13(s3) = " + StrUtil.rot13(s3));

      // ROT13N5      
      s3 = StrUtil.rot13n5(s2);
      System.out.println("\nrot13n5:");
      System.out.println("s3 = rot13n5(s2) = " + s3);
      System.out.println("rot13n5(s3) = " + StrUtil.rot13n5(s3));

      // ROTASCII
      s3 = StrUtil.rotAscii(s2, 1);
      System.out.println("\nrotAscii:");
      System.out.println("s3 = rotAscii(s2, 1) = " + s3);
      System.out.println("rotAscii(s3, -1): " + StrUtil.rotAscii(s3, -1));

      s3 = new String(new byte[] { (byte) 0xFE, (byte) 0xFF });
      s4 = StrUtil.rotAscii(s3, 1);
      System.out.println("s3 = " + StrUtil.hexEncode(s3));
      System.out.println("s4 = rotAscii(s3, 1) = " + StrUtil.hexEncode(s4));
      System.out.println("rotAscii(s4, -1) = " + 
         StrUtil.hexEncode(StrUtil.rotAscii(s4, -1)));

      s3 = new String(new byte[] { (byte) 0x00, (byte) 0x01 });
      s4 = StrUtil.rotAscii(s3, -1);
      System.out.println("s3 = " + StrUtil.hexEncode(s3));
      System.out.println("s4 = rotAscii(s3, -1) = " + StrUtil.hexEncode(s4));
      System.out.println("rotAscii(s4, 1) = " + 
         StrUtil.hexEncode(StrUtil.rotAscii(s4, 1)));
   }
}
