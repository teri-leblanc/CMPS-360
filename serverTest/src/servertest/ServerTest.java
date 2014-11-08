

package servertest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static onceConnected clientOne;
    public static onceConnected clientTwo;
    private static BufferedReader in;
    private static DataOutputStream out;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
            int portNumber = 8000;
            ServerSocket secretSocket = new ServerSocket(portNumber);
             
            
        try{
            
            System.out.println("Listening on local host: 8000");
             while(true){
                Socket sock = secretSocket.accept();
                if(Authenticate(sock) == true){
                    
                    clientOne = new onceConnected(sock);
                    System.out.println("clientOne has connected to the socket, Waiting for clientTwo");
                    Socket sock2 = secretSocket.accept();
                    clientTwo = new onceConnected(sock2);
                    System.out.println("clientTwo has connected to the socket");
                    clientOne.getSecureAgent(clientTwo);
                    clientTwo.getSecureAgent(clientOne);
                    new Thread(clientOne).start();
                    new Thread(clientTwo).start();
                
                }
            }
             
        
      } finally {
            secretSocket.close();
        }
       
        
    }
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
  


    

