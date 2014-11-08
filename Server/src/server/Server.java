/*Author:           Terianne LeBlanc Bolding
  CLID:             TLL6799
  Class:            CMPS 360
  Assignment:       project­2
  Due Date:         November 9th 2014 11:55 PM
  Description:      The server will listen for a connection request from the handler client.  When there is an active handler client
                    connected to the server, the server will listen for a connection request from the spy client.  When a  
                    connection is made to the server by both clients, the user of the either client will be able to choose to type in 
                    ordinary text1.
.  
*/

package server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Teri
 */
public class Server extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
