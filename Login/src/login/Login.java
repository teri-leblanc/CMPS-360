/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-6
 *Due Date:     10/12/2014 23:55 PM
 *Description: Work Tutorial #2 "Creating a Form in JavaFX" in this document:  http://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.pdf
               When finished, submit the entire NetBeans project directory in a Zip archive file named “a6_your­clid.zip”.*/
package login;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Login extends Application {
    
@Override
 public void start(Stage primaryStage) {
 primaryStage.setTitle("JavaFX Welcome");
 
 primaryStage.show();
 
 /**
  * creates a GridPane object and assigns it to the variable named grid. The 
alignment property changes the default position of the grid from the top left of the 
scene to the center. The gap properties manage the spacing between the rows and 
columns, while the padding property manages the space around the edges of the grid 
pane. The insets are in the order of top, right, bottom, and left. In this example, there 
are 25 pixels of padding on each side.
The scene is created with the grid pane as the root node, which is a common practice 
when working with layout containers. Thus, as the window is resized, the nodes 
within the grid pane are resized according to their layout constraints. In this example, 
the grid pane remains in the center when you grow or shrink the window. The 
padding properties ensure there is a padding around the grid pane when you make 
the window smaller.
This code sets the scene width and height to 300 by 275. If you do not set the scene 
dimensions, the scene defaults to the minimum size needed to display its contents.*/
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    
/**
 * The first line creates a button named btn with the label Sign in, and the second line 
creates an HBox layout pane named hbBtn with spacing of 10 pixels. The HBox pane sets 
an alignment for the button that is different from the alignment applied to the other 
controls in the grid pane. The alignment property has a value of Pos.BOTTOM_RIGHT, 
which positions a node at the bottom of the space vertically and at the right edge of 
the space horizontally. The button is added as a child of the HBox pane, and the HBox
pane is added to the grid in column 1, row 4.
Now, add a Text control for displaying the message, as shown in Example 2–5. Add 
this code before the code for the scene.*/    
    Button btn = new Button("Sign in");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(btn);
    grid.add(hbBtn, 1, 4);
 /** 
  * shows the form now. You will not see the text message until you work 
through the next section of the tutorial, Add Code to Handle an Event.*/   
    final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
 /**
  * The first line creates a Text object that cannot be edited, sets the text to Welcome, and 
assigns it to a variable named scenetitle. The next line uses the setFont() method to 
set the font family, weight, and size of the scenetitle variable. Using an inline style is 
appropriate where the style is bound to a variable, but a better technique for styling 
the elements of your user interface is by using a style sheet. In the next tutorial, Fancy 
Forms with JavaFX CSS, you will replace the inline style with a style sheet.
The grid.add() method adds the scenetitle variable to the layout grid. The 
numbering for columns and rows in the grid starts at zero, and scenetitle is added in 
column 0, row 0. The last two arguments of the grid.add() method set the column 
span to 2 and the row span to 1. 
The next lines create a Label object with text User Name at column 0, row 1 and a Text 
Field object that can be edited. The text field is added to the grid pane at column 1, 
row 1. A password field and label are created and added to the grid pane in a similar 
fashion.
When working with a grid pane, you can display the grid lines, which is useful for 
debugging purposes. In this case, you can add grid.setGridLinesVisible(true)
after the line that adds the password field. Then, when you run the application, you 
see the lines for the grid columns and rows as well as the gap properties, as shown in*/
    Text scenetitle = new Text("Welcome");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 2, 1);
    Label userName = new Label("User Name:");
    grid.add(userName, 0, 1);
    TextField userTextField = new TextField();
    grid.add(userTextField, 1, 1);
    Label pw = new Label("Password:");
    grid.add(pw, 0, 2);
    
    PasswordField pwBox = new PasswordField();
    grid.add(pwBox, 1, 2);
/**
 * The setOnAction() method is used to register an event handler that sets the 
actiontarget object to Sign in button pressed when the user presses the button. 
The color of the actiontarget object is set to firebrick red.*/   
    btn.setOnAction(new EventHandler<ActionEvent>() {
 
        
        @Override
        public void handle(ActionEvent e) {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Sign in button pressed");
        }
    });
Scene scene = new Scene(grid, 300, 275);
primaryStage.setScene(scene);
 }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
