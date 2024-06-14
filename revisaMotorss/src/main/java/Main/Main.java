// Main.java
package Main;

import javax.swing.SwingUtilities;
import View.MainView;
import View.ClientePanel;
import View.OficinaPanel;
import View.RevisaoPanel;


public class Main {
    public static void main(String[] args) {
       javax.swing.SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
             mainView.setVisible(true);
        });
       
    }
}