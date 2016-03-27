package org.javacogs;

import java.io.*;
import java.net.*;
import java.util.*;

public class PropertiesFile extends Properties {
   public PropertiesFile() {
   }
   
   //--------------------------------------------------------------------------

   public String getString(String key) {
      return getProperty(key);
   }

   public String getString(String key, String defaultVal) {
      return getProperty(key, defaultVal);
   }

   public void setString(String key, String s) {
      setProperty(key, s);
   }

   public String[] getStringArray(String key) {
      String   prop = getProperty(key);
      String[] arr = null;

      if (prop != null) {
         arr = StrUtil.split(prop, ",");
      }

      return arr;
   }

   public int getInt(String key) throws NumberFormatException {
      return Integer.parseInt(getProperty(key));
   }

   public int getInt(String key, int defaultVal) {
      try {
         return Integer.parseInt(getProperty(key));
      } catch(NumberFormatException ex) {
         return defaultVal;
      }
   }

   public void setInt(String key, int i) {
      setProperty(key, String.valueOf(i));
   }

   public boolean getBoolean(String key) {
      return new Boolean(getProperty(key)).booleanValue();
   }

   public void setBoolean(String key, boolean b) {
      setProperty(key, String.valueOf(b));
   }
   
   //--------------------------------------------------------------------------
   
   public void load(String fileName) throws IOException {
      InputStream in = new FileInputStream(fileName);
      
      try {
         super.load(in);
      } finally {
         in.close();
      }
   }

   public void load(URL fileUrl) throws IOException {
      InputStream in = fileUrl.openStream();
      
      try {
         super.load(in);
      } finally {
         in.close();
      }
   }

   public void loadAsResource(ClassLoader cl, String fileName) 
         throws IOException {
      URL resource = cl.getResource(fileName);
      
      if (resource == null) {
         throw new IOException("File not found: " + fileName);
      }
      
      load(resource);
   }

   public void loadAsResource(Class c, String fileName) throws IOException {
      URL resource = c.getResource(fileName);
      
      if (resource == null) {
         throw new IOException("File not found: " + fileName);
      }

      load(resource);
   }

   public void store(String fileName) throws IOException {
      store(fileName, null);
   }

   public void store(String fileName, String header) throws IOException {
      FileOutputStream out = new FileOutputStream(fileName);

      try {
         super.store(out, header);
      } finally {
         out.close();
      }
   }
}