package org.javacogs;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * DateCellEditor is used to edit a date with validation in a JTable cell.
 *
 * @author Thornton Rose
 * @version 1.0
 */
public class DateCellEditor extends DefaultCellEditor {
   private static final Date defaultDate = new Date();

   private JTextField field;
   private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
   private Date       dateValue;

   public DateCellEditor() {
      super(new JTextField());

      field = (JTextField) getComponent();
      field.setBorder(new LineBorder(Color.black));

      field.getDocument().addDocumentListener(new DocumentListener() {
         public void insertUpdate(DocumentEvent event) {
            parseDate();
         }

         public void removeUpdate(DocumentEvent event) {
            parseDate();
         }

         public void changedUpdate(DocumentEvent event) {
            parseDate();
         }
      });
   }

   public DateCellEditor(DateFormat formatter) {
      this();
      this.formatter = formatter;
   }

   public Component getTableCellEditorComponent(JTable table,
         Object value, boolean isSelected, int row, int column) {
      try {
         field.setText((value == null) ? "" : formatter.format((Date) value));
      } catch(Exception ex) {
         field.setText("");
      }

      return field;
   }

   private void parseDate() {
      try {
         dateValue = formatter.parse(field.getText());
      } catch(ParseException ex) {
         dateValue = defaultDate;
      }
   }

   public Object getCellEditorValue() {
      return dateValue;
   }
}