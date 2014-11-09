/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-1
 *Due Date:     9/14/2014 11:55 PM
 *Description:This assignment will focus on basic Java programming techniques.  These are the use of an IDE, creation of 
a Java class, plus its methods, fields and an object of that class, use of static methods of existing classes, use 
of public methods called from an object of an existing class and exploration of existing classes through 
Javadocs.
 */

package javaassignment1;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JavaAssignment1 {

    private String longString,cInput,shortString; // longString = long string input, cInput = char input, shortString = short string input.
    private Scanner s; //s = scanner object instance.
    private double doubleOne,doubleTwo; //doubleOne = first double input, doubleTwo = second double input.
   
/**
Prototype: JavaAssignment1();
Description: Constructor for class JavaAssignment1. 
Initializes Instance object of JavaAssignment1.
Precondition(s): Instance object of JavaAssignment1() must be created
Postcondition(s): A scanner instance object is created. A long String,Character, and short string is collected from the user.
* Two gui prompts pop up asking for a double in each. The input is sent to be processed. A message is displayed showing a random integer
* between 50 and 100.
Visibility: Public
*/
     
    public JavaAssignment1(){
        s = new Scanner(System.in);
        
        //Ask user for long string, char, and short string.
        System.out.println("Please enter a long string");
        longString = s.nextLine();//collect long string
        System.out.println("Please enter a char");
        cInput = s.nextLine();//collect char
        System.out.println("Please enter a short string");
        shortString = s.nextLine();//collect short string
        
        //Process and print data
        //Prints long string length
        System.out.println("The length of the long string is: " + longString.length());
        //Checks if long string is a palindrome and output results
        System.out.println("It is " + palindrome() + " that the string ' " + longString + " ' is a palindrome");
        //Checks the number of times the char appears in the long string and outputs results
        System.out.println("The number of times the char  appears in the long string is: " + countChar());
        //Checks if the short string is a suffix of the long string and outputs results
        System.out.println("It is " + isSuffix() + " that the long string ends with a suffix made up of the short string");
        
        //Ask user for two doubles and send to function to be processed.
        String stringOne = JOptionPane.showInputDialog("Enter a double");
        String stringTwo = JOptionPane.showInputDialog("Enter a second double");
        doubleOne = Double.parseDouble(stringOne);//collect first double
        doubleTwo = Double.parseDouble(stringTwo);//collect second double
        processDouble();//do things with doubles from user
        
        //output a random int between 50 and 100
        JOptionPane.showMessageDialog(null, "A random number between 50 and 100 is: " + ((int)(50 + Math.random()*51))); 
    }

        /**
Prototype: palindrome();
Description: Checks if longString is a palindrome.
Precondition(s): The constructor JavaAssignment1() must have been called.
Postcondition(s): True returned if is palindrome, false otherwise
Visibility: Public
*/
    public boolean palindrome(){
        
        String upperA = longString.toUpperCase();//Switch to upper case to ignore case
        
        return upperA.equals(new StringBuilder(upperA).reverse().toString());//Check if the long string is a palindrome
    }
    
            /**
Prototype: public void countChar();
Description: Processes the char taken from user.
Precondition(s): The constructor JavaAssignment1() must have been called.
Postcondition(s): An int denoting the number of times the char appears in the long string is returned.
Visibility: Public
*/
    public int countChar(){
     
        char temp = cInput.charAt(0);//change string b to a char
        char[] aArray = longString.toCharArray();//put string a into a char array
        int counter  = 0;
        for (char b : aArray){
            if (b == temp)//check if the char appears in the longer string
                counter++;
        }

        return counter;
    }
 
/**
Prototype: public void isSuffix();
Description: Checks if short string is suffix of long string
Precondition(s): The constructor JavaAssignment1() must have been called.
Postcondition(s): Returns true if suffix, false otherwise
Visibility: Public
*/
    public boolean isSuffix(){
        
        String []cStringArray = shortString.split(" ");
        
        return longString.endsWith(cStringArray[cStringArray.length-1]);//check for suffix of long and short string
    }
 
            /**
Prototype: public void processDouble();
Description: Processes the two doubles taken from user.
Precondition(s): The constructor JavaAssignment1() must have been called.
Postcondition(s): An output to the terminal displaying the results of the first double raised to the power of the second double
* Then that double is displayed using JOption GUI as a rounded integer.
Visibility: Public
*/
    public void processDouble(){
    
        double powDouble = Math.pow(doubleOne, doubleTwo);//first double raised to the power of the second
        System.out.println("The result of the first double raised to second double is : " + powDouble);
        int powInt = (int)(Math.round(powDouble)); //round and convert to int
        JOptionPane.showMessageDialog(null, "The rounded result is: " + powInt);
    }
    
    /**
     * @param args the command line arguments
     * Prototype: public static void main();
     * Description: Creates an instance object of JavaAssignment by calling the constructor.
     * Postcondition(s): instance object for JavaAssignment1() is created
     * Visibility: Public
     */ 
        public static void main(String[] args) {
            new JavaAssignment1();
    }
}
