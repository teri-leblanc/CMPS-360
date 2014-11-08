/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secretserver;
import java.io.*;
import java.net.*;



/**
 *
 * @author Teri
 */
public class onceConnected implements Runnable{
    Socket sock;
    BufferedReader in;
    DataOutputStream out;
    
    public onceConnected(Socket sock)throws Exception {
        this.sock = sock;
        in = new BufferedReader(new InputStreamReader(
                                    sock.getInputStream())
                               );
        out = new DataOutputStream(sock.getOutputStream());
    } 
    public void run(){
    
    }
}
