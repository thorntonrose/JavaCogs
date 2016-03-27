package org.javacogs;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * <code>BackgroundTableCellRenderer</code> is used to render the background
 * color of JTable cells.
 */
public class BackgroundTableCellRenderer extends DefaultTableCellRenderer {
   private Color oddColor;
   private Color evenColor;
   
   public BackgroundTableCellRenderer() {
   }

   public BackgroundTableCellRenderer(Color oddColor, Color evenColor) {
      setOddColor(oddColor);
      setEvenColor(evenColor);
   }

   public void setOddColor(Color oddColor) {
      this.oddColor = oddColor;
   }

   public void setEvenColor(Color evenColor) {
      this.evenColor = evenColor;
   }
   
   public Component getTableCellRendererComponent(
         JTable table, Object value, boolean isSelected,
         boolean hasFocus, int row, int col) {
      // Set cell value.
      setValue(value);

      // Set cell font.
      setFont(table.getFont());

      // Set cell background color. If selected, use selection background
      // color. Else, use evenColor for the background of even rows and
      // oddColor for the background of odd rows. If either color is null,
      // the table background color is used instead.
      if (isSelected) {
         setBackground(table.getSelectionBackground());
      } else {
         if ((row % 2) == 0) {
            setBackground(evenColor == null ? table.getBackground() : 
               evenColor);
         } else {
            setBackground(oddColor == null ? table.getBackground() : 
               oddColor);
         }
      }

      // Return the renderer.
      return this;
   }
}
