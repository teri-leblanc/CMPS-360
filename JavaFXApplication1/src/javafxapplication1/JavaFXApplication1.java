/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-6
 *Due Date:     10/12/2014 23:55 PM
 *Description: Work Tutorial #2 "Creating a Form in JavaFX" in this document:  http://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.pdf
               When finished, submit the entire NetBeans project directory in a Zip archive file named “a6_your­clid.zip”.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class JavaFXApplication1 extends Application {
    private Label label = new Label();
    Button btn = new Button();
    @Override
    public void start(Stage primaryStage) {
        
        btn.setText("Play global thermonuclear war");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                btn.setVisible(false);
                label.setText("Bang");
                label.setVisible(true);
                System.out.println("Hello World!");
                
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(label);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);//launch from a jar or from ide, cause START to be called
    }
    
}
