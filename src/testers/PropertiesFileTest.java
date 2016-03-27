package testers;

import org.javacogs.*;

public class PropertiesFileTest {
   public static void main(String[] args) {
      try {
         Class c = PropertiesFileTest.class;
         PropertiesFile props = new PropertiesFile();
         String fn = "classes/org/javacogs/testers/foo.properties"; 
         
         props.load(fn);
         System.out.println("Loaded " + fn + ".");
         
         int foo = props.getInt("foo");
         System.out.println("foo = " + foo);

         foo ++;
         props.setInt("foo", foo);
         System.out.println("foo++ => " + foo);

         props.store(fn);
         System.out.println("Stored " + fn + ".");
         
         fn = "org/javacogs/testers/foo.properties";
         props.loadAsResource(c.getClassLoader(), fn);
         System.out.println("Loaded " + fn + " as resource.");

         fn = "foo.properties";
         props.loadAsResource(c, fn);
         System.out.println("Loaded " + fn + " as resource for " + c + ".");
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }
}