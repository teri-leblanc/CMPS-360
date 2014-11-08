
package secrethandler;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SecretHandler extends Application {
    
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
