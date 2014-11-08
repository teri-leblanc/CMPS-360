/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-5
 *Due Date:     10/2/2014 23:55 PM
 *Description: Create a Java project that reads the data directly from the file via its URL and stores the data in two 
TreeMap class objects.  In one object, the name of the state is the key and the capital is the value.  In the 
other object, the capital of the state is the key and the state is the value.  Once the data has been loaded from 
the file into the TreeMap class objects, the program should then present a menu to the user with the 
following selections:
● Spell the State – if the user selects this option, the user is prompted to input a state and, if the state 
input is correctly spelled, the capital of that state is output; otherwise, a message indicating that there
is no state with that spelling is output
● Spell the Capital – if the user selects this option, the user is prompted to input a state capital and, if 
the capital is correctly spelled, the state with that capital is ouput; otherwise, a message indicating 
that there is no state with a capital with that spelling is output
● Exit – the number of correctly and incorrectly spelled states and capitals from this run of the 
program is output and the program halts
 */

package javaassignment5;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.net.*;

public class JavaAssignment5{
    private Scanner S; //Scanner to input data
    private int control = 10, SspCo = 0, SspInc = 0,CspCo = 0, CspInc = 0; 
        //control  = menu item selected by user
        //SspCo = states spelled correctly; SspInc = states spelled incorrectly
        //CspCo = capitals spelled correctly; CspInc = capitals spelled incorrectly
    private TreeMap<String,String> state; //Key is the state and value is the Capital
    private TreeMap<String,String> capital; // Key is the capital and value is the state
    String tempState, tempCapital; //keep temp state and capital values from scanner object.
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JavaAssignment5();
        
    }
    /**
Prototype: JavaAssignment5();
Description: Constructor for class JavaAssignment5 that creates 2 TreeMaps for states and capitals. Also creates
* a menu that prompts a user to traverse either map by entering the keys. 
Precondition(s): Instance object of JavaAssignment5() must be created
Postcondition(s): All interactions with the user are outputted along with the final tally of how many
* correctly spelled states and Capitals were outputted along with how many incorrectly spelled states and capitals were
* inputted by the user.
Visibility: Public
*/
    public JavaAssignment5(){
            try{
        URL salaryTxt = new URL("http://fidelio.cacs.louisiana.edu/360/statecapitals.txt");
            S = new Scanner(salaryTxt.openStream()); //Initiate Scanner
            state = new TreeMap<String,String>();
            capital = new TreeMap();
            
           while(S.hasNextLine()) {
               tempState=S.nextLine();
               if(S.hasNextLine()){
               tempCapital = S.nextLine();
                    state.put(tempState,tempCapital);
                    capital.put(tempCapital, tempState);
               }
           }
           System.out.println();
           S.close();
           //state.values();
        }
        catch(IOException e){
        
        }
        //---Create Menu For User and ask for input as long as the control is not 0
            S = new Scanner(System.in);
            control = 10;
            while(control != 0){
                System.out.println("Select a number from the following choices: ");
                System.out.println("1 - Spell the State");
                System.out.println("2 - Spell the Capital");
                System.out.println("0 - Exit");
            control = Integer.parseInt(S.nextLine());
            switch(control){
            
                case 0://Exit case and ouput results to user
                    System.out.println("-------------------Final Results--------------------------------");
                       System.out.println("Number of correctly spelled States: "+ SspCo);
                       System.out.println("Number of incorrectly spelled States: "+ SspInc);
                       System.out.println();
                       System.out.println("Number of correctly spelled Capitals: "+ CspCo);
                       System.out.println("Number of incorrectly spelled Capitals: "+ CspInc);
                       System.out.println("--------------------------------------------------------------");
                    break;
                case 1: // Get State from user and output Capital
                    System.out.println();
                    System.out.println("-------------------State--------------------------------");
                    System.out.println("Enter the State: ");
                    tempState=S.nextLine();
                    if(state.containsKey(tempState)){ 
                        System.out.println(state.get(tempState)); 
                        SspCo++;
                    }
                    
                    else {
                        System.out.println("There is no State with that spelling.");
                        SspInc++;
                    } 
                    System.out.println("----------------------------------------------------------");
                    break;
                case 2://Get Capital from user and output State
                    System.out.println("------------------Capital---------------------------------");
                    System.out.println();
                    System.out.println("Enter the Capital: ");
                    tempCapital=S.nextLine();
                    if(capital.containsKey(tempCapital)){
                        System.out.println(capital.get(tempCapital));
                        CspCo++;
                    }
                    
                    else {
                        System.out.println("There is no Capital with that spelling.");
                        CspInc++;
                    }
                    System.out.println("---------------------------------------------------------------");
                    break;
            
            }
            }
            

    
    
    }
   
    
}
