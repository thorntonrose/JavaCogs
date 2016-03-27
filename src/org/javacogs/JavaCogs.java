package org.javacogs;

/**
 * <code>JavaCogs</code> is a stub class at the root of the package hierarchy
 * that provides version information for the JavaCogs library. If run from the 
 * command-line, it will display the version number.
 *
 * <p>
 * <b>Note:</b> This class will return valid version information only if it is
 * bundled in a jar file with the following in the manifest:
 * <pre>
 * Name: org/javacogs/
 * Specification-Title: JavaCogs
 * Specification-Version: (version)
 * Specification-Vendor: Thornton Rose
 * Implementation-Title: org.javacogs
 * Implementation-Version: (version)
 * Implementation-Vendor: Thornton Rose
 * </pre>
 *
 * @author Thornton Rose
 */
public class JavaCogs {
   private static final Package p = JavaCogs.class.getPackage();

   /**
    * Get title.
    *
    * @return Title, null if Specification-Title not in manifest.
    */
   public static String getTitle() {
      return p.getSpecificationTitle();
   }

   /**
    * Get version.
    *
    * @return Version, null if Specification-Version not in manifest.
    */
   public static String getVersion() {
      return p.getSpecificationVersion();
   }
   
   //--------------------------------------------------------------------------
   
   /**
    * Display the version information.
    */
   public static void main(String[] args) {
      System.out.println(getTitle() + " " + getVersion());
   }
}