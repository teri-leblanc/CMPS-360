/*Author: Terianne LeBlanc Bolding
CLID: TLL6799
Class: CMPS-360
Assignment: Project 3
Due Date: November 23rd 11:55 pm
Description:Using the provided NetBeans project, create a client system for the database that allows the user, via a selection from a menu, to
● list
◦ ids and student names in the database
◦ courses in the database 1
with course ids
◦ majors in the database with major ids
◦ students with a given major
◦ students in a course in the database
● list
◦ schedule of one student in the database
◦ name, address and major of one student in the database
● add a
◦ new student to the database
◦ new course to the database
◦ new major to the database
● enroll a student in a course in the database
● exit the program
*/

package socketmckoidb;

import java.util.Scanner;

public class Main {
public static Scanner scanner;
int exit;
    public Main() {

    
       scanner = new Scanner(System.in);
        exit = -1;
        while(exit != 0){
        System.out.println("---------------------------------------------------------");
        System.out.println("Please Select a number for what you would like to do:");
        System.out.println("List All: ");
        System.out.print("1: id's and Student Names \n2: Courses in the database with course ids \n3: Majors in the database with major ids \n4: Students with a given major \n5: Students in a course in the database\n");
        System.out.println("\nList The:");
        System.out.println("6: Schedule of one student in the database\n7:Name, address and major of one student in the database");
        System.out.println();
        System.out.println("Add:");
        System.out.println("8: Student\n9: Course\n10: Major");
        System.out.println();
        System.out.println("11: Enroll a student in a course");
        System.out.println();
        System.out.println("0: Exit");
        System.out.println("---------------------------------------------------------");
        int temp = scanner.nextInt();
        switch(temp){

            case 0: // Exit Program
                exit = 0;
                break;
            case 1: // Display All Student Names and IDs
                ListQuerys.IdandName();
                break;
            case 2: // Display all Courses with Course IDS
                ListQuerys.IdandCourse();
                break;
            case 3: // Display all Majors with Major IDS
                ListQuerys.IdandMajor();
                break;
            case 4: // Display studnets with given majors
                ListQuerys.StudentMajor();
                break;
            case 5:// Display Students with Enrolled Courses
                ListQuerys.StudentCourse();
                break;
            case 6://Display Studnets Schedule
                System.out.println("Please enter the Student ID");
                ListQuerys.StudentSchedule(scanner.nextInt());
                break;
            case 7: // Display Student Name, Address, and Major
                System.out.println("Please enter the Student ID");
                ListQuerys.StudentInfo(scanner.nextInt());
                break;
            case 8:// Add new Student and Address
                //Get studnt ID
                scanner.nextLine();
                System.out.println("Enter student id: ");
                String id = scanner.nextLine();
                //Get Student Name
                System.out.println("Enter student name: ");
                String name = scanner.nextLine();
                // Get Student Major
                System.out.println("Enter major id: ");
                String majorID = scanner.nextLine();
                // Get student Address
                System.out.println("Street Address:");
                String address = scanner.nextLine();
                // Get student City
                System.out.println("City:");
                String city = scanner.nextLine();
                // Get student zip
                System.out.println("Zip:");
                String zip = scanner.nextLine();
                //Get student state
                System.out.println("State:");
                String state = scanner.nextLine();
                
                AddQuerys.newStudent(id, name, majorID); //Add student
                AddQuerys.newAddress(id, address, city, state, zip); //Add student address
                break;
            case 9: // Add a new Course
                scanner.nextLine();
                System.out.println("Enter course id: ");
                id = scanner.nextLine();
                System.out.println("Enter course description: ");
                String desc = scanner.nextLine();
                AddQuerys.newCourse(id, desc);
                
                break;
            case 10: // Add new Major
                scanner.nextLine();
                System.out.println("Enter major id: ");
                id = scanner.nextLine();
                System.out.println("Enter major description: ");
                desc = scanner.nextLine();
                AddQuerys.newMajor(id, desc);
                break;
            case 11://Enroll Student in a Course
                scanner.nextLine();
                System.out.println("Enter Student id: ");
                id = scanner.nextLine();
                System.out.println("Enter Course id: ");
                String courseId = scanner.nextLine();
                AddQuerys.AddStudentCourse(id, courseId);
                break;
            default:
                System.out.println("Input not recognized");
                break;
        
        
        }
        }
    }
    
    public static void main(String[] args) {
      new Main(); //Start program
      
    }
    
}
