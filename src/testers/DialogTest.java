package testers;

import java.io.*;
import javax.swing.*;
import org.javacogs.*;

/**
 * Test the dialog classes (MessageDialog, InputDialog, ConfirmDialog).
 */
public class DialogTest {
   public static void main(String[] args) {
      // long message
      MessageDialog.show(
         null,
         "Test",
         "This is a long long long long long long long long long long " +
            "long long long long long long long long long long message.");
     
      // exception
      try {
         FileInputStream in = new FileInputStream("foo");
      } catch(Exception ex) {
         MessageDialog.show(null, "DialogTest.main", ex, 
            JOptionPane.ERROR_MESSAGE);     
      }

      // confirm
      int answer = ConfirmDialog.show(null, "Is the sky blue?");
      System.out.println("answer = " + answer);
      
      // input
      String s = InputDialog.show(null, "Enter something:", "");
      System.out.println("s = " + s);

      // text input
      s = InputDialog.show(null, "Input", "Enter something:", "", 3, 25);
      System.out.println("s = " + s);

      System.exit(0);
   }
}