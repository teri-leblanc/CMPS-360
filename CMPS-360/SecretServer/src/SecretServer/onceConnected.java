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
import java.io.*;
import java.net.*;

public class onceConnected implements Runnable{
    Socket sock;
    BufferedReader in = null;
    DataOutputStream out = null;
    onceConnected agent; // Connect with other client
    
     /**
Prototype: onceConnected(Socket sock)throws Exception;
Description: Constructor for class OnceConnected
Precondition(s): Server connected to client and passed socket
Postcondition(s): Input and output streams opened along with true being sent to client
Visibility: Public
*/      
    public onceConnected(Socket sock)throws Exception {
        this.sock = sock;
        in = new BufferedReader(new InputStreamReader(
                                    sock.getInputStream())
                               );
        out = new DataOutputStream(sock.getOutputStream());
        out.writeBytes("true"+"\n");
    }
     /**
Prototype: getSecureAgent(onceConnected agent)
Description: Store the other client on the server.
Precondition(s): valid OnceConnected object passed
Postcondition(s): Client object has been set to agent
Visibility: Public
*/  
    public void getSecureAgent(onceConnected agent){
        this.agent = agent;
    }
     /**
Prototype: public void sendIncoming(String message);
Description: Send incoming message from other agent to this agent.
Precondition(s): Both agents connected
Postcondition(s): Message sent to opposing agent.
Visibility: Public
*/    
    public void sendIncoming(String message){
        try{
        out.writeBytes(message + "\n");
        }
        catch(IOException e){
            System.out.println("SendIncoming Exception");
        }
    }
        
     /**
Prototype: public void run()
Description: Constantly listen for incoming messages.
Precondition(s): Two clients are connected.
Postcondition(s): All incoming messages from client are sent to the other client.
Visibility: Public
*/   
    @Override
    public void run(){
        try{
            
            while (true) {
                    if(agent.sock.isClosed()){
                        System.out.println("The connection has been terminated on the client side. \n This program will self distruct");
                        System.exit(1);
                    }
                    String command = in.readLine();
                    if(command == null){return;}
                    agent.sendIncoming(command);
            }
        }
        catch (Exception e) {
                System.out.println("Agent died: " + e);
        }
        finally {
                try {sock.close();} catch (IOException e) {}
        
        }
    }
}

