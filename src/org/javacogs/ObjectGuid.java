package org.javacogs;

import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

/**
 * <code>ObjectGuid</code> is an implementation of a global unique identifier 
 * (GUID) for Java objects. It is similar to a Microsoft Windows GUID but has
 * a smaller final form, because it is hashed with MD5. The GUID is retrieved
 * with <code>toString()</code>.
 *
 * @author Thornton Rose
 */
public final class ObjectGuid {
   private String key;
   private String guid;
   
   private ObjectGuid() {
   }
   
   /**
    * Construct a new ObjectGUID for the given object. The following algorithm
    * is used:
    *
    * <ol>
    * <li><p>1. key = [st]:[lhip]:[rthc]:[ohc]:[ri]<br>
    * [st] = system time in milliseconds<br>
    * [lhip] = IP address of local host (or random number if IP not available)<br>
    * [rthc] = hashcode of Java runtime<br>
    * [ohc] = hashcode of source object<br>
    * [ri] = random int (in range Integer.MIN_VALUE to Integer.MAX_VALUE)<br>
    *
    * <li><p>2. GUID = MD5 message digest of key
    * </ol>
    *
    * @param obj Source object.
    */
   public ObjectGuid(Object obj) {
      StringBuffer keybuf = new StringBuffer();
      
      // Create a random number generator.
      Random randomizer = new Random();
      
      // Get the system time.
      keybuf.append(System.currentTimeMillis()).append(':');

      // Get the IP of the local host. If not available, use random number.
      try {
         keybuf.append(InetAddress.getLocalHost().getHostAddress());
      } catch(Exception ex) {
         keybuf.append(randomizer.nextInt());
      }
      
      // Append runtime hashcode.
      keybuf.append(':').append(Runtime.getRuntime().hashCode());
      
      // Append object hashcode.
      keybuf.append(':').append(obj.hashCode());
      
      // Append random number.
      keybuf.append(':').append(randomizer.nextInt());

      // Save key.
      this.key = keybuf.toString();

      // Get an instance of an MD5 message digest. If the MD5 algorithm is not
      // supported, throw a runtime exception.
      MessageDigest md5;
      
      try {
         md5 = MessageDigest.getInstance("MD5");
      } catch(Exception ex) {
         throw new RuntimeException("MD5 not implemented.");
      }
      
      // Generate message digest for key and save as GUID.
      md5.update(key.getBytes());
      this.guid = new String(md5.digest());
   }

   /**
    * Get the string form of the GUID.
    *
    * @return GUID string
    */
   public String toString() {
      return guid;
   }

   /**
    * Get the key that was used to generate the GUID.
    *
    * @return GUID key
    */
   public String getKey() {
      return key;
   }
}   
