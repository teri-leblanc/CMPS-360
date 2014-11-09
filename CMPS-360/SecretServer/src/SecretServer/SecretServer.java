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

package SecretServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SecretServer {
    public static onceConnected clientOne; //Hold Handler Client
    public static onceConnected clientTwo; // Hold Agent Client
    private static BufferedReader in;      //BufferedReader
    private static DataOutputStream out;  // Data output stream
    
    /**
     * @param args the command line arguments
     *      /**
Prototype: static void main(String[] args) throws Exception;
Description: Main to handle socket server
Postcondition(s): Handler Client Connects then Agent client connects then both new threads are sent off.
Visibility: Public
*/  
     
    public static void main(String[] args) throws Exception {
            int portNumber = 8000;      //Port number for server
            ServerSocket secretSocket = new ServerSocket(portNumber); //Server listening on port
        try{
            
            System.out.println("Listening on local host: 8000");
             while(true){
                Socket sock = secretSocket.accept();
                if(Authenticate(sock) == true){ //Check it connection is from Handler
                    
                    clientOne = new onceConnected(sock);
                    System.out.println("clientOne has connected to the socket, Waiting for clientTwo");
                    Socket sock2 = secretSocket.accept();
                    clientTwo = new onceConnected(sock2);
                    System.out.println("clientTwo has connected to the socket");
                    clientOne.getSecureAgent(clientTwo);//Client one Connect with client Two
                    clientTwo.getSecureAgent(clientOne);//Client two connect with client One
                    new Thread(clientOne).start();
                    new Thread(clientTwo).start();
                }
            }
       } finally {
            secretSocket.close();
        }
    }
/**
Prototype: static Boolean Authenticate(Socket sock)
Description: Authenticate the server connection
Postcondition(s): Return true if handler is trying to connect. False otherwise.
Visibility: Public
*/      
    public static Boolean Authenticate(Socket sock){
        try{
        in = new BufferedReader(new InputStreamReader(
                                    sock.getInputStream())
                               );
        out = new DataOutputStream(sock.getOutputStream());
        
        String authenticate = in.readLine();
            if("handler".equals(authenticate)) {
                
            out.writeBytes("true"+"\n");
                return true;
            }
            out.writeBytes("false"+"\n");
            return false;
        }
        catch(IOException e){
            System.out.println("Error: Authenticase IOException");
        }
        
       
        return false;
    }
    
    
    
    }
  


    

