/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Terianne Bolding
 */
public class JavaApplication2 {

    /**
     * This program gives an example of how to use the Scanner class, String Array class, and Math class and Joption. 
     * This is an in class example from ULL CMPS 360 (Java Programming)--9/8/2014
     */
    public static void main(String[] args) {
        /*Scanner s = new Scanner(System.in); //initiate scanner
        
    //Integer Example
        System.out.print("Enter an Integer: ");
        int i = s.nextInt();
        System.out.println(i);
    
    //-----------------------------------------------   
    //String and array split example
        //System.out.print("Enter a sentence: ");
        s.nextLine();//Need this because NextIn() from above does not skip to next line.
        String t = s.nextLine();
        String []a= t.split(" ");//Split string into an array by space
        
        for (int x = 0; x < a.length; x++){
            System.out.println(a[x]);
            

        }
    //-----------------------------------------------       
    //Math Example
            System.out.println(Math.cos(1));//radians
            System.out.println(Math.random());
    
    //-----------------------------------------------*/
            //Joption Example
    String input = javax.swing.JOptionPane.showInputDialog("Gimme your age");
        int days= Integer.parseInt(input) *365;
        System.out.println(days);
        JOptionPane.showMessageDialog(null, "You are at least"+ days +"days old");
    }
    
    
}
