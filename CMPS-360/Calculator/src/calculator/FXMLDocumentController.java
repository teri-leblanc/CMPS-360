/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-5
 *Due Date:     10/26/2014 23:55 PM
 *Description: Create a calculator with a gui interface.
 */
package calculator;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    private int Total = 0; // keep track of calculator total including the first number entered by user
    private int Operated = 0;  //Keep track of second number entered to apply operation on
    private Label label;
    private String Operator = ""; // Keep track of operation to be done
    private boolean justOperated = false;
    @FXML
    private TextField screen;
    @FXML
    private Button ButtonE; // =
    @FXML
    private Button ButtonM; //-
    @FXML
    private Button ButtonT;//*
    @FXML
    private Button ButtonP;//+
    @FXML
    private Button ButtonClr;//Clr
    @FXML
    private Button Button0, Button9, Button8, Button7, Button6, Button5, Button4, Button3, Button2, Button1;
    @FXML
    private Button QuiteButton;
    @FXML
    private Button ButtonD;
    
    /**
Prototype: handleButtonAction(ActionEvent event);
ActionEvent handler to get which button for the numbers is selected.
Precondition(s): A button on the calculator between 0 and 9 must have been clicked by the user or fired in the code.
Postcondition(s): If an operator has not been selected by the user then the number selected is displayed on the screen
*                 If an operator is selected then the Operated value is displayed on the screen.
Visibility: Private
*/
    @FXML
    private void handleButtonAction(ActionEvent event) {
       Button tempButton = (Button)event.getSource();

       if (Operator == ""){
           if(justOperated){ // If just computed operation and the user enters a number instead of an operation then the 
                            // Total goes back to zero and just operated goes to false.
                Total = 0;
                justOperated = false;
                
            }
            Total = parseInt(String.valueOf(Total) + String.valueOf(Character.getNumericValue(tempButton.getId().charAt(6))));
            screen.setText(String.valueOf(Total));
        }
       else{ 
            Operated = parseInt(String.valueOf(Operated) + String.valueOf(Character.getNumericValue(tempButton.getId().charAt(6))));
            screen.setText(String.valueOf(Operated));
        }
       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
Prototype: handleButtonE(ActionEvent event);
ActionEvent handler to do operation when the = button is selected
Precondition(s):2 number buttons and one operations button should be pressed before the = button is pressed.
Postcondition(s): Total is manipulated with the Operated value based on the Operator character value
Visibility: Private
*/
    @FXML
    private void handleButtonE(ActionEvent event) {
        switch (Operator) {
            case "P":  
                Total = Total + Operated;
                        break;
            case "T":  
                Total = Total * Operated;
                        break;
            case "M":  
                Total = Total - Operated;
                        break;
            case "D":
                try{
                    Total = Total/Operated;
                            }
                catch(Exception e){
                    System.out.println("Not a Number");
                    Total = 0;
                }
                        
                        break;
            default: break;
    }
        Operator  = "";
        justOperated = true;
        Operated = 0;
        screen.setText(String.valueOf(Total));
    }
    /**
Prototype: handleButtonO(ActionEvent event);
ActionEvent handler to get the Operator value from which Operator button selected
Precondition(s):A number button has to be pressed before the operator button.
Postcondition(s): The operator is stored for use on the numbers selected.
Visibility: Private
*/
    @FXML
    private void handleButtonO(ActionEvent event) {
        Button tempButton = (Button)event.getSource();
        if (Operator !=null){ButtonE.fire();} //If an operator has been selected, do that operation before assigning
                                              //the new operator value
        Operator =  Character.toString(tempButton.getId().charAt(6));
    }
    /**
Prototype: handleButtonClr(ActionEvent event);
ActionEvent handler to handle when the clr button is selected.
Precondition(s):No preconditions for this button
Postcondition(s):Total is set to 0, Operator is set to default empty string and 0 is displayed on the screen.
Visibility: Private
*/
    @FXML
    private void handleButtonClr(ActionEvent event) {
        Operator =  "";
        Total = 0;
        screen.setText(String.valueOf(Total));
    }

    @FXML
    /**
Prototype: handleButtonQuite(ActionEvent event);
ActionEvent handler to handle the quite button selected in the drop down menu.
Precondition(s):No preconditions for this button
Postcondition(s):The calculator closes and the program ends.
Visibility: Private
*/
    private void handleButtonQuite(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) QuiteButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    /**
Prototype: handleText(ActionEvent event);
ActionEvent handler to handle the text input from the keyboard
Precondition(s):Program must be running and the calculator must be in focus.
Postcondition(s):The calculator functions as though the physical buttons have been pressed.
Visibility: Private
*/
    @FXML
    private void handleText(KeyEvent event) { //Handle text being input when the shift button is pressed
        if(event.isShiftDown()){
            switch(event.getText()){//Get Keyboard string
                case "+":
                        ButtonP.fire();  //Handle Addition Button
                        break;

                case "*":
                        ButtonT.fire(); //Handle Multiplication Button
                        break;  
            }
        }
        else{
            switch(event.getText()){  //Get Keyboard String
                case "=":
                        ButtonE.fire(); //Handle the equals button
                        break;
                case "-":
                        ButtonM.fire(); //Handles the subtraction button
                        break;
                case "/":
                        ButtonD.fire(); //handles the division button
                        break;  
          //Handles Buttons 0 - 9     
                case "0":
                        Button0.fire();
                    break;                
                case "1":
                        Button1.fire();
                    break;
                case "2":
                        Button2.fire();
                    break;
                case "3":
                        Button3.fire();
                    break;
                case "4":
                        Button4.fire();
                    break;
                case "5":
                        Button5.fire();
                    break; 
                case "6":
                        Button6.fire();
                    break; 
                case "7":
                        Button7.fire();
                    break;  
                case "8":
                        Button8.fire();
                    break; 
                case "9":
                        Button9.fire();
                        break;   
                default:
                       
                        break;
            }
        }
    }
}
