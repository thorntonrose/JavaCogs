package testers;

import java.text.*;
import java.util.*;
import org.javacogs.*;

/**
 * Test the ObjectProxy class.
 */
public final class ObjectProxyTest {
   public static final class Quark {
      private String color;
      
      public Quark() {
      }
      
      public String getColor() {
         return this.color;
      }
      
      public void setColor(String color) {
         this.color = color;
      }
   }
   
   public static void main(String[] args) {
      Quark q = new Quark();
      System.out.println("q = new Quark()");

      q.setColor("blue");
      System.out.println("q.setColor(\"blue\")");
      System.out.println("q.getColor() = \"" + q.getColor() + "\"");
      
      try {
         ObjectProxy p = new ObjectProxy(q);
         System.out.println("p = new ObjectProxy(q)");

         p.set("color", "red");
         System.out.println("p.set(\"color\", \"red\")");
         System.out.println("p.get(\"color\") = \"" + p.get("color") + "\"");
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }
}
