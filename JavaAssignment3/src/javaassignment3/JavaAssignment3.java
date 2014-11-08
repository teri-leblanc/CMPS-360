/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-3
 *Due Date:     9/23/2014 23:55 PM
 *Description: Create a program that copies the contents of the file http://cs.armstrong.edu/liang/data/Salary.txt to the 
    local file “mycopy.txt”.  When the copy is complete, the following output is to be displayed to the 
    program user with appropriate labels.
        ● the number of assistant professors -
        ● the average, high and low salaries of assistant professors 
        ● the number of associate professors -
        ● the average, high and low salaries of associate professors 
        ● the number of full professors -
        ● the average, high and low salaries of full professors.
 */

package javaassignment3;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.net.*;


public class JavaAssignment3 {
    /**
     * @param args the command line arguments
     */
    private Scanner S; //Scanner to input data
    private PrintWriter P; //printer to print data
    private int numAssis, numProfs, numAssoc; //numAssis = number of assistant profs, numProfs = number of professors, numAssoc = number of associate
    private double highSalAssis = 0.0, highSalProfs = 0.0, highSalAssoc = 0.0;//keeps track of high sal for each group
    private double lowSalAssis = 10000000, lowSalProfs = 10000000, lowSalAssoc = 10000000; // keeps track of low sal for each group
    private double avSalA = 0, avSalP = 0, avSalAc =0; // keeps track of total salary and sends to average function to recieve average.

    private ArrayList<Teacher> teacherList; //ArrayList to keep track of all teacher objects created.

    /**
Prototype: JavaAssignment3();
Description: Constructor for class JavaAssignment3. 
Initializes Instance object of JavaAssignment3.
Precondition(s): Instance object of JavaAssignment3() must be created
Postcondition(s): 
Visibility: Public
*/
    public JavaAssignment3(){
        try
                {
            URL salaryTxt = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
            S = new Scanner(salaryTxt.openStream()); //Initiate Scanner
            P = new PrintWriter("mycopy.txt"); //Initiate PrintWriter
            teacherList= new ArrayList<Teacher>(); //Initiate ArrayList
            String []teacherInfo = new String[4]; //array used to split the String input stream
            String inputLine;
            while(S.hasNextLine()){//Check if anything in file
               inputLine =  S.nextLine(); // Getline
               P.println(inputLine);//Write line to file
               teacherInfo = inputLine.split(" "); //split string into array
               if(teacherInfo.length != 0){
               teacherList.add((new Teacher(teacherInfo[0],teacherInfo[1],teacherInfo[2],teacherInfo[3])));//Create teacher object
              }
            }
            S.close();//Close Scanner Stream
            P.close();//Close Print Stream
            for(Teacher b : teacherList){
                if (b.getStatus().compareTo("assistant") == 0){
                    numAssis++;
                    if(b.getPay() > highSalAssis) highSalAssis = b.getPay();
                    if(b.getPay() < lowSalAssis) lowSalAssis = b.getPay();
                    avSalA = avSalA + b.getPay();
                    
                }
                else if(b.getStatus().compareTo("associate") == 0){
                    
                    numAssoc++;
                    if(b.getPay() > highSalAssoc) highSalAssoc = b.getPay();
                    if(b.getPay() < lowSalAssoc) lowSalAssoc = b.getPay();
                    avSalAc = avSalAc + b.getPay();
                }
                else{
                    numProfs++;
                    if(b.getPay() > highSalProfs) highSalProfs = b.getPay();
                    if(b.getPay() <  lowSalProfs) lowSalProfs = b.getPay();
                    avSalP = avSalP + b.getPay();
                }
        }
            avSalA = average(numAssis,avSalA);
            avSalAc = average(numAssoc,avSalAc);
            avSalP = average(numProfs,avSalP);
            System.out.println("Number of Assistant: "+numAssis);
            System.out.println("High for Assistant: "+highSalAssis+"; Low for Assistant: "+lowSalAssis+"; Average: "+avSalA);
            System.out.println("Number of Associate: "+ numAssoc );
            System.out.println("High for Associate: "+highSalAssoc+"; Low for Associate: "+lowSalAssoc+"; Average: "+avSalAc );
            System.out.println("Number of Proffesors: "+ numProfs);
            System.out.println("High for Proffesor:"+highSalProfs+"; Low for Proffesor: "+lowSalProfs+"; Average: "+avSalP );

    }
        catch(IOException e){
                
                
                }

}
        /**
Prototype: average(int length, double total);
Description: Computes an average from a total sum with the length of items .
Precondition(s): valid int length and double total positive sum must be past
Postcondition(s): Rounded to 2 decimal place number will be returned. total/length.
Visibility: Public
*/
    public double average(int length, double total){
    
        return (Math.round((total/length)*100.0)/100.0);
        
    }
    
    public static void main(String[] args) {
            new JavaAssignment3();
    }
    

   
}
