package org.javacogs;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * MessageDialog is a wrapper for <code>JOptionPane.showMessageDialog</code>
 * that does word wrapping.
 *
 * @author Thornton Rose
 */
public class MessageDialog {
   public static final int WRAP_WIDTH = 50;

   /**
    * Show a message dialog (JOptionPane.INFORMATION_MESSAGE).
    *
    * @param parent  Parent container.
    * @param message Message to display.
    */
   public static void show(Container parent, Object message) {
      show(parent, "Message", message);
   }

   /**
    * Show a message dialog (JOptionPane.INFORMATION_MESSAGE).
    *
    * @param parent  Parent container.
    * @param message Message to display.
    * @param title   Dialog title.
    */
   public static void show(Container parent, String title, Object message) {
      show(parent, title, message, JOptionPane.INFORMATION_MESSAGE);
   }

   /**
    * Show a message dialog.
    *
    * @param parent  Parent container.
    * @param message Message to display.
    * @param title   Dialog title.
    */
   public static void show(Container parent, String title, Object message,
         int type) {
      JOptionPane.showMessageDialog(parent, 
         StrUtil.wordWrap(message.toString(), WRAP_WIDTH), title, type);
   }
}
