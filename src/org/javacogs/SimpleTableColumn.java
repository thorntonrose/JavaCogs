package org.javacogs;

import javax.swing.table.*;

/**
 * This class is a simple column for use with JTable.
 *
 * @author Thornton Rose
 * @version 1.0
 */
public class SimpleTableColumn extends TableColumn {
   /**
    * Construct a table column with the given header and width that maps to the given
    * index of the underlying data model.
    */
   public SimpleTableColumn(int index, int width, String header) {
      super(index, width);
      setHeaderValue(header);
      setCellRenderer(new DefaultTableCellRenderer());
   }
}
