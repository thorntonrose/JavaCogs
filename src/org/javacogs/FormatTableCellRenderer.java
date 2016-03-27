package org.javacogs;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * This class is used to format JTable cells using a given formatter, such as
 * SimpleDateFormat.
 *
 * @author Thornton Rose
 * @version 1.0
 */
public class FormatTableCellRenderer extends DefaultTableCellRenderer {
   private Format formatter;

   /**
    * Construct table cell renderer for given format.
    */
   public FormatTableCellRenderer(Format formatter) {
      this.formatter = formatter;
   }

   /**
    * Return table cell renderer component. (Called by JTable to render a given cell.)
    */
   public Component getTableCellRendererComponent(
         JTable table, Object value, boolean isSelected, boolean hasFocus,
         int row, int column) {
      try {
         value = (value == null) ? "" : formatter.format(value);
      } catch(Exception ex) {
         value = "";
      }

      super.getTableCellRendererComponent(
         table, value, isSelected, hasFocus, row, column);

      return this;
   }
}
