/**
 *@Author:      Terianne LeBlanc Bolding
 *CLID:         TLL6799
 *Class:        CMPS360
 *Assignment:   assignment-3
 *Due Date:     9/23/2014 23:55 PM
 *Description: Create a program that copies the contents of the file http://cs.armstrong.edu/liang/data/Salary.txt to the 
    local file “mycopy.txt”.  When the copy is complete, the following output is to be displayed to the 
    program user with appropriate labels.
        ● the number of assistant professors 
        ● the average, high and low salaries of assistant professors 
        ● the number of associate professors 
        ● the average, high and low salaries of associate professors 
        ● the number of full professors 
        ● the average, high and low salaries of full professors.
 */

package javaassignment3;

public class Teacher {
    String first,last,status; //first = first name, last = last name, status = profesional status rank.
    double pay; // yearly salary

        /**
Prototype: Teacher(String first, String last, String status, String pay);
Description: Constructor for class Teacher. 
Creates a Teacher object that has a first and last name, professional status and pay rate..
Precondition(s): Correct parameters sent to the constructor
Postcondition(s): First name, last name ,status, and pay initialized.
Visibility: Public
*/
    public Teacher(String first, String last, String status, String pay){
        this.first = first;
        this.last = last;
        this.status = status;
        this.pay = Double.parseDouble(pay);
    }
        /**
Prototype:  private void editStatus(String status)
Description: Change the professional status of the teacher.
Precondition(s): Teacher object must be created and valid string parameter passed.
Postcondition(s): status for teacher object status changed.
Visibility: private
*/    
    private void editStatus(String status){
        this.status = status;
    }
    
        /**
Prototype:  private void editPay(String pay)
Description: Change the yearly salary of the teacher.
Precondition(s): Teacher object must be created and valid string parameter passed containing a double.
Postcondition(s): status for teacher object pay changed.
Visibility: private
*/ 
    private void editPay(String pay){
        this.pay = Integer.parseInt(pay);
    
    }
         /**
Prototype: String getStatus()
Description: Get String status of teacher.
Precondition(s): Teacher object must be created.
Postcondition(s): String object returned represented the status of the teacher.
Visibility: public
*/ 
    public String getStatus(){
    
        return status;
    }
         /**
Prototype: String getPay()
Description: Get double pay of teacher.
Precondition(s): Teacher object must be created.
Postcondition(s): Double object returned represented the pay of the teacher.
Visibility: public
*/ 
    public double getPay(){
    
        return pay;
    }
         /**
Prototype: String toString()
Description: returns String with all valid information for the teacher object
Precondition(s): Teacher object must be created.
Postcondition(s): String object returning first, last, status, and pay of the teacher.
Visibility: public
*/     
    public String toString()
    {
        return(first+" "+last+" "+" "+status+" "+" "+pay);
    }
    
}
