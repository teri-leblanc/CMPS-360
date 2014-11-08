/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
/**
 *
 * @author Teri
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField secretText;
    @FXML
    private Button buttonServer;
    @FXML
    private Label statusLabel;
    
    public serverMessaging message = new serverMessaging();
    public static String messageConcact ="";
    @FXML
    private static TextArea messageReceived;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
         SolitairEncryption a = new SolitairEncryption();
        message.sendMessage(a.encrypt(secretText.getCharacters().toString()));
       
        secretText.setText("");
        
        
    }
    @FXML
    private void handleButtonServer(ActionEvent event) throws Exception{
        if(message.connectServer()){
            statusLabel.setText("Connected");
            buttonServer.setVisible(false);
        }
        else
            statusLabel.setText("Connection Failed");
    }
    
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
