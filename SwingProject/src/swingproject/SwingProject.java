
package swingproject;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import view.DashBoard;
import view.Login;

public class SwingProject {

   
    public static void main(String[] args) {
        
        Login l = new Login();
        l.setVisible(true);
        l.setLocationRelativeTo(null);
        
        DashBoard dashboard = new DashBoard();
        dashboard.setVisible(true);
        dashboard.setLocationRelativeTo(null);
        dashboard.setTitle("Pos Porject");
        dashboard.setDefaultCloseOperation( EXIT_ON_CLOSE);
        
    }
    
}
