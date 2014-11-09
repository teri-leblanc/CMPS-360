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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class serverMessaging implements Runnable{
        
    Socket sock;
    DataInputStream dis;
    BufferedReader bis;
    PrintStream ps;
     /**
Prototype: public serverMessaging();
Description: Constructor for serverMessaging.
Precondition(s): Instance object created.
Postcondition(s): Instance object created.
Visibility: Public
*/  
    public serverMessaging(){}
      /**
Prototype: public boolean connectServer();
Description: Attempt to connect to a server
Precondition(s): serverMessaging object created.
Postcondition(s): True returned if connected to server and data streams are opened. False otherwise.
Visibility: Public
*/     
    public boolean connectServer() {
        try{
            sock = new Socket("localhost", 8000); //Connect to server on localhost 8000
            ps = new PrintStream(sock.getOutputStream()); // Connect to the servers output stream
            dis = new DataInputStream(sock.getInputStream());  // Connect to servers input stream       
            bis = new BufferedReader(new InputStreamReader(dis));
            ps.println("agent\n");
            if("true".equals(bis.readLine())){
                new Thread (this).start(); //Start Seperate Thread to handle incoming data from server
                return true;
            }
        }
        catch(java.io.IOException e){
            System.out.println("No server listening on port 8000");
            return false;
        }
        return false;
    }
     /**
Prototype: public void sendMessage(String message);
Description: Send Message to the server.
Precondition(s): connectServer() called and true returned
Postcondition(s): Message has sent to the server.
Visibility: Public
*/      
    public void sendMessage(String message){
        try{
            ps.print(message + "\n");
        }
        catch(Exception e){
            System.out.println("SendMessage SecretAgent Exception");
        }
    }
     /**
Prototype: public void run();
Description: Listens for incoming messages from the server and sends to GUI.
Precondition(s): connectServer() called and true returned
Postcondition(s): All incoming messages from the server are sent to the GUI.
Visibility: Public
*/  
    @Override
    public void run(){
        String sendingMessage = "";
        String readMessage = "";
        try{
            while(true){
                System.out.println(sock.isClosed());
                if((readMessage = bis.readLine()) == null){
                    System.out.println("The connection has been terminated on the server side. \n This program will self distruct");
                    System.exit(1);} //If server terminates then both clients terminate
                sendingMessage = sendingMessage + readMessage + "\n";
                System.out.println(readMessage);
                FXMLDocumentController.SetTextArea(readMessage);
            }
        }
        catch(Exception e){
            System.out.println("You are no longer connected to the server");
            System.exit(1);
        }
    }
}
