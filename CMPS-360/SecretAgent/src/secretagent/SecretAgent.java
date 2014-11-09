/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   Project 2
 *Due Date:     11/9/2014 23:55 PM
 *Description: Creates a server / client system that allows use of the handler client and the user of the spy client to send 
 * encrypted messages to and from each other based on the “Solitaire” encryption scheme designed by Bruce Schneier 
 * (and used in the 1999 novel Cryptonomicon by Neal Stephenson).
 */

package secretagent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SecretAgent extends Application {
     /**
Prototype: public void start(Stage stage) throws Exception
Description: Starts GUI
Postcondition(s): Graphical User Interface is launched
Visibility: Public
*/     
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() 
  {
      //Terminate all threads when gui is closed
      public void handle(WindowEvent e){
          System.out.println("test");  
          try {
               System.exit(0);
          } 
          catch (Exception e1) {
               e1.printStackTrace();
          }
      }
   });
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
