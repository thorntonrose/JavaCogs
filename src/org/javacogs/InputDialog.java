package org.javacogs;

import java.awt.*;
import java.text.*;
import javax.swing.*;

/**
 * InputDialog is a wrapper for <code>JOptionPane.showInputDialog</code>.
 *
 * @author Thornton Rose
 */
public class InputDialog {
   /**
    * Show an input dialog (message type = JOptionPane.QUESTION_MESSAGE).
    *
    * @param parent  Parent component.
    * @param message Prompt message.
    * @param text    Default input value.
    */
   public static String show(Component parent, String message, String text) {
      return show(parent, "Input", message, text);
   }

   /**
    * Show an input dialog (message type = JOptionPane.QUESTION_MESSAGE).
    *
    * @param parent  Parent component.
    * @param title   Dialog title.
    * @param message Prompt message.
    * @param text    Default input value.
    */
   public static String show(Component parent, String title, String message,
         String text) {
      return (String) JOptionPane.showInputDialog(
         parent,
         message,
         title,
         JOptionPane.QUESTION_MESSAGE,
         null,
         null,
         text);
   }

   /**
    * Show an input dialog with a text box (message type = 
    * JOptionPane.QUESTION_MESSAGE).
    *
    * @param parent  Parent component.
    * @param title   Dialog title.
    * @param message Prompt message.
    * @param text    Default input value.
    * @param rows    Number of rows in input field.
    * @param cols    Number of columns in input field.
    */
   public static String show(Component parent, String title, String message,
         String text, int rows, int cols) {
      JPanel      panel      = new JPanel();
      JScrollPane scrollPane = new JScrollPane();
      JLabel      label      = new JLabel();
      JTextArea   textArea   = new JTextArea();

      textArea.setRows(rows);
      textArea.setColumns(cols);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setText(text);

      scrollPane.getViewport().add(textArea);

      panel.setLayout(new BorderLayout());
      panel.add(scrollPane, BorderLayout.CENTER);

      if (message != null) {
         label.setText(message);
         panel.add(label, BorderLayout.NORTH);
      }

      int result = JOptionPane.showConfirmDialog(
         parent,
         panel,
         title,
         JOptionPane.OK_CANCEL_OPTION,
         JOptionPane.QUESTION_MESSAGE);

      if (result == JOptionPane.OK_OPTION) {
         return textArea.getText();
      }

      return null;
   }
}
