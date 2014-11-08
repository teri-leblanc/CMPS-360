/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secretserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Teri
 */
public class SecretServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        //Scene scene = new Scene(root);
        
        //stage.setScene(scene);
        //stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Printing");
         //launch(args);
        if (args.length != 1) {
            System.err.println("Usage: java KnockKnockServer <port number>");
            System.exit(1);
        } 
        {
            int portNumber = 8000;
        try{
            ServerSocket secretSocket = new ServerSocket(portNumber);
            System.out.println("Listening on local host: 8080");
             while(true){
                Socket sock = secretSocket.accept();
                System.out.println("client has connected to the socket");
                onceConnected client = new onceConnected(sock);
                new Thread(client).start();
            }
    }
        catch(IOException e){
        }
       
        
    }
  }
}
