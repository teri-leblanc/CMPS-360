package secrethandler;
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

    public serverMessaging(){
        
    
    }
    
    public boolean connectServer() {
        try{
            sock = new Socket("localhost", 8000); //Connect to server on localhost 8000
            ps = new PrintStream(sock.getOutputStream()); // Connect to the servers output stream
            dis = new DataInputStream(sock.getInputStream());  // Connect to servers input stream       
            bis = new BufferedReader(new InputStreamReader(dis));
            ps.println("handler");
            if(bis.readLine().equals("true")){
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
    
    public void sendMessage(String message){
        try{
            ps.print(message + "\n");
        }
        catch(Exception e){
            System.out.println("SendMessage SecretAgent Exception");
        }
    }

    @Override
    public void run(){
        String sendingMessage = "";
        String readMessage = "";
        try{
            while(true){
                if((readMessage = bis.readLine()) == null){
                    System.out.println("The connection has been terminated on the server side. \n This program will self distruct");
                    Thread.sleep(10000);
                    System.exit(1);} //If server terminates then both clients terminate
                else if(readMessage.equals("true")){}
                else if(readMessage.equals("agent")){}
                else if(readMessage.equals("\n")){}
                else if(readMessage.equals("")){}
                else{
                    sendingMessage = sendingMessage + readMessage + "\n";
                    System.out.println(readMessage);
                    FXMLDocumentController.SetTextArea(readMessage);
                }
            }
            
        
    }
    catch(Exception e){
       System.out.println("You are no longer connected to the server");
       System.exit(1);
    
    }
    
    }
    
    
    
}
