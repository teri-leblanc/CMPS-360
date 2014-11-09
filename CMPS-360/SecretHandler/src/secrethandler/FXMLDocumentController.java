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
package secrethandler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import solitairencryption.SolitairEncryption;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField secretText;
    @FXML
    private Button buttonServer;
    @FXML
    private Label statusLabel;
    @FXML
    private static TextArea messageReceived;
    
    public serverMessaging message = new serverMessaging(); // Create new object to connect with server.
    public static String messageConcact =""; //Hold all messages received from server
    
    /**
Prototype: private void handleButtonAction(ActionEvent event) throws Exception
Description: This button send the incoming message from secretText to get encrypted and then sends it to the server.
Precondtion(s): Must be connected to a server by clicking handleButtonServer.
Postcondition(s): Message encrypted and sent to server.
Visibility: Public
*/      
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        SolitairEncryption a = new SolitairEncryption();
        message.sendMessage(a.encrypt(secretText.getCharacters().toString()));
        secretText.setText(""); // Empty Text Box
        
        
    }
     /**
Prototype: private void handleButtonServer(ActionEvent event) throws Exception
Description: Connect tot the server and set Status label.
Postcondition(s): If connection successful then connect button hidden and statusLabel changed to connect. Else, status
* label changed to Connect Failed.
Visibility: Public
*/ 
    @FXML
    private void handleButtonServer(ActionEvent event) throws Exception{
        if(message.connectServer()){
            statusLabel.setText("Connected");
            buttonServer.setVisible(false);
        }
        else
            statusLabel.setText("Connection Failed");
    }
      /**
Prototype: public static void SetTextArea(String message)
Description: Gets incoming message from server and decrypts the message then displays the message.
Postcondition(s): Message is decrypted and displayed in the messageReceived Text Area.
Visibility: Public
*/     
    public static void SetTextArea(String message){
        SolitairEncryption decrypt = new SolitairEncryption();
        messageConcact = messageConcact + decrypt.decrypt(message.trim()) + "\n";
        messageReceived.setText(messageConcact);
}

@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
}
