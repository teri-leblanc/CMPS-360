/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servertest;
import java.io.*;
import java.net.*;




/**
 *
 * @author Teri
 */
public class onceConnected implements Runnable{
    Socket sock;
    BufferedReader in = null;
    DataOutputStream out = null;
    Boolean pendingMessage;
    onceConnected agent;
    
    
    public onceConnected(Socket sock)throws Exception {
        this.sock = sock;
        in = new BufferedReader(new InputStreamReader(
                                    sock.getInputStream())
                               );
        out = new DataOutputStream(sock.getOutputStream());
        out.writeBytes("true"+"\n");
    }
    String getRequest() throws Exception {

        System.out.println("getRequet");
        return null;
    }
    public void getSecureAgent(onceConnected agent){
        this.agent = agent;
    }
    
    public void sendIncoming(String message){
        try{
        out.writeBytes(message + "\n");
        }
        catch(IOException e){
            System.out.println("SendIncoming Exception");
        }
    }
        
   
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

