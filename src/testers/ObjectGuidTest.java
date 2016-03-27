package testers;

import org.javacogs.*;

/**
 * Test the ObjectGuid class.
 */
public final class ObjectGuidTest {
   public static void main(String[] args) {
      ObjectGuid oguid = new ObjectGuid("a");
      System.out.println("oguid = [" + oguid + "]");
      System.out.println("key = [" + oguid.getKey() + "]");
   }   
}