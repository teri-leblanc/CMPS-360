/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package composition;
import newpackage.AnotherClass;
/**
 *
 * @author Teri
 */

public class Composition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NewClass a = new NewClass();
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        a.setNc(input.nextInt());
        System.out.println(a.getNc());
        
        AnotherClass []ac= new AnotherClass[5]; //AnotherClass ac[]
        for(int i=0; i <ac.length;i++){
            ac[i] = new AnotherClass();
            ac[i].setD(Math.random());
        }
        for(int i=0; i<ac.length;i++)
            System.out.println(ac[i].getD());
        
        for(AnotherClass b : ac)
           b.setD(.1);
        
        for(AnotherClass b : ac)
            System.out.println(b.getD());
    }
    
}
