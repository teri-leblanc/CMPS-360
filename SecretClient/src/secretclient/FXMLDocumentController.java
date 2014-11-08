/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secretclient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    
    Socket sock;
    DataInputStream dis;
    BufferedReader bis;
    PrintStream ps;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
       try{
            dis = new DataInputStream(sock.getInputStream());        
            bis = new BufferedReader(new InputStreamReader(dis));
            ps = new PrintStream(sock.getOutputStream());
            ps.print(secretText.getCharacters()+"\n");
           System.out.println(bis.readLine());

       }
       catch(IOException e){
           System.out.println("Check Connection");
       }

       }
    
    @FXML
    private void handleButtonServer(ActionEvent event) throws Exception{
        try{
            sock = new Socket("localhost", 8000);
            statusLabel.setText("Connected");
        }
        catch(java.io.IOException e){
            System.out.println("No server listening on port 8000");
            statusLabel.setText("Connection Failed");
            
        }
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
