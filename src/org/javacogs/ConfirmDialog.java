package org.javacogs;

import java.awt.*;
import javax.swing.*;

/**
 * ConfirmDialog is a wrapper for <code>JOptionPane.showConfirmDialog</code>
 * that does word wrapping.
 *
 * @author Thornton Rose
 */
public class ConfirmDialog {
   public static final int WRAP_WIDTH = 50;

   /**
    * Show a confirm dialog (message type = JOptionPane.QUESTION_MESSAGE, 
    * option type = JOptionPane.YES_NO_OPTION).
    *
    * @param parent  Parent container.
    * @param message Message to display.
    *
    * @return Selected option (JOptionPane.YES_OPTION, JOptionPane.NO_OPTION).
    */
   public static int show(Container parent, String message) {
      return show(parent, message, "Confirmation", JOptionPane.YES_NO_OPTION);
   }

   /**
    * Show a confirm dialog (message type = JOptionPane.QUESTION_MESSAGE).
    *
    * @param parent     Parent container.
    * @param title      Dialog title.
    * @param message    Message to display.
    * @param optionType Response option type (use constants in JOptionPane).
    *
    * @return Selected option.
    */
   public static int show(Container parent, String message, String title,
         int optionType) {
      return JOptionPane.showConfirmDialog(
         parent,
         StrUtil.wordWrap(message, WRAP_WIDTH),
         title,
         optionType,
         JOptionPane.QUESTION_MESSAGE);
   }
}
