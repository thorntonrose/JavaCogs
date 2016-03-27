package org.javacogs;

import java.io.*;
import java.util.*;

/**
 * This class is a sequence number generator. It uses a properties file as its data
 * source.
 *
 * @author Thornton Rose
 * @version 1.0
 */
public class Sequence {
   private static final String PROP_NAME = "seq";

   private String     fileName;
   private Properties data;

   /**
    * Create a neq sequence generator that uses the specified file for its data.
    */
   public Sequence(String fileName) throws IOException {
      // Set file name.

      this.fileName = fileName;

      // Initialize sequence data. If the data file exists, load it. Otherwise,
      // create it.

      data = new Properties();
      File dataFile = new File(fileName);

      if (dataFile.exists()) {
         load();
      } else {
         data.setProperty(PROP_NAME, "0");
         store();
      }
   }

   /**
    * Load the sequence data.
    */
   protected void load() throws IOException {
      FileInputStream stream = new FileInputStream(getFileName());

      try {
         data.load(stream);
      } finally {
         stream.close();
      }
   }

   /**
    * Store the sequence data.
    */
   protected void store() throws IOException {
      FileOutputStream stream = new FileOutputStream(getFileName());

      try {
         data.store(stream, null);
      } finally {
         stream.close();
      }
   }

   /**
    * Get the name of the data file.
    */
   public String getFileName() {
      return fileName;
   }

   /**
    * Get the next value of the sequence.
    */
   public synchronized long getNextValue() throws IOException {
      long seq = 0;

      try {
         seq = Long.parseLong(data.getProperty(PROP_NAME));
      } catch(NumberFormatException ex) {
      }

      seq ++;
      data.put(PROP_NAME, Long.toString(seq));
      store();

      return seq;
   }

   //--------------------------------------------------------------------------

   /*
   public static void main(String[] args) {
      try {
         Sequence seq = new Sequence("foo.properties");

         for (int i = 0; i < 3; i ++) {
            System.out.println("foo = " + seq.getNextValue());
         }
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }
   */
}