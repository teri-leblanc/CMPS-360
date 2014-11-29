/*
Author: Terianne LeBlanc Bolding
CLID: TLL6799
Class: CMPS-360
Assignment: Project 4
Due Date: December 6th 11:55 pm
Description:Reprise Project 3, but with a HTML/JavaServer Pages user interface or a JavaServer Faces user interface.  
The site must be password protected.  As there is no password table in the database, it is OK to embed the password in the JSP code,
but every page used in a session must be accessible only if the user has entered the correct password at the starting page.

 */

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import socketmckoidb.*;

@ApplicationScoped
@ManagedBean(name = "SchoolDB")
public class NewJSFManagedBean implements Serializable {
     ListQuerys openDb = new ListQuerys(); //For all List type querys
     AddQuerys insertDb = new AddQuerys(); //For all Insertion type querys

     int Param1; //Integer Parameter
     String ParamId; //String parameter for ID
     String ParamName; //String parameter for Name
     String ParamMajorId; // String Parameter for Major ID
     String ParamAddress;//String Parameter for Address
     String ParamCity; // String Parameter for City
     String ParamState; // String Parameter for State
     String ParamZip; // String Parameter for Zip
     String ParamCourseDesc; // String Parameter for Course Description
     private String resultString; //String returned from insertion type querys
     private List<Results> resultList; //List of dataset results from list querys
     /**Param1 getter
      * 
      * @return 
      */
    public int getParam1() {
        return Param1;
    }
    /**Param1 setter
     * 
     * @param Param1 
     */
    public void setParam1(int Param1) {
        this.Param1 = Param1;
    }
      /**
Prototype: void listIdandCourse()
Description: get a list of Ids and Courses
Visibility: Public   
*/
    public void listIdandCourse() {
       
        resultList= openDb.IdandCourse();
    }
       /**
Prototype: void listIdandMajor() 
Description: get a list of Ids and Majors
Visibility: Public   
*/
    public void listIdandMajor() {
       resultList = openDb.IdandMajor();
    }
       /**
Prototype: void listIdandName() 
Description: get a list of Ids and Names
Visibility: Public   
*/
    public void listIdandName() {
        
       resultList = openDb.IdandName();
      
    }
       /**
Prototype: void listStudentCourse()
Description: get a list of Students and Courses
Visibility: Public   
*/
    public void listStudentCourse() {
        resultList = openDb.StudentCourse();
    }
       /**
Prototype: void listStudentMajors()
Description: get a list of Students and Majors
Visibility: Public   
*/
    public void listStudentMajor() {
        resultList = openDb.StudentMajor();
    }
       /**
Prototype: void listStudentInfo()
Description: get a list of Student and information based on valid Student ID
Visibility: Public   
*/
    public void listStudentInfo(){
        resultList = openDb.StudentInfo(Param1);
    }
       /**
Prototype: void listStudenSchedule()
Description: get a list of Students classes based on valid Student ID
Visibility: Public   
*/
    public void listStudentSchedule(){
        resultList = openDb.StudentSchedule(Param1);
    }
       /**
Prototype: void addNewStudent()
Description: add a new student to the database
Visibility: Public   
*/
    public void addNewStudent(){
        resultString = insertDb.newStudent(ParamId,ParamName,ParamMajorId);
        resultString =insertDb.newAddress(ParamId, ParamAddress, ParamCity, ParamState, ParamZip);
    
    }
       /**
Prototype: void addNewCourse()
Description: add a new course to the database
Visibility: Public   
*/
    public String addNewCourse(){
        if(insertDb.newCourse(ParamId, ParamCourseDesc))return "index.xhtml";
        else return null;
    }
        /**
Prototype: void addNewMajor()
Description: add a new major to the database
Visibility: Public   
*/
    public String addNewMajor(){
        if(insertDb.newMajor(ParamId, ParamCourseDesc))return "index.xhtml";
        else return null;
    }
       /**
Prototype: void enrollStudent()
Description: enroll a student in the database
Visibility: Public   
*/
    public void enrollStudent(){
        if(insertDb.AddStudentCourse(ParamId, ParamCourseDesc)) resultString = "Student Added to the Course";
        else resultString = "Student was not added to the course";
    
    }
/**resultList getter
 * 
 * @return 
 */    
    public List<Results> getResults() {
        return resultList;
    }
/**resultString getter
 * 
 * @return 
 */
    public String getResultString() {
        return resultString;
    }
/**ParamId getter
 * 
 * @return 
 */
    public String getParamId() {
        return ParamId;
    }
/**ParamId setter
 * 
 * @param ParamId 
 */
    public void setParamId(String ParamId) {
        this.ParamId = ParamId;
    }
/**ParamName getter
 * 
 * @return 
 */
    public String getParamName() {
        return ParamName;
    }
/**ParamName setter
 * 
 * @param ParamName 
 */
    public void setParamName(String ParamName) {
        this.ParamName = ParamName;
    }
/**ParamMajorId getter
 * 
 * @return 
 */
    public String getParamMajorId() {
        return ParamMajorId;
    }
/**ParamMajorId setter
 * 
 * @param ParamMajorId 
 */
    public void setParamMajorId(String ParamMajorId) {
        this.ParamMajorId = ParamMajorId;
    }
/**ParamAddress getter
 * 
 * @return 
 */
    public String getParamAddress() {
        return ParamAddress;
    }
/**ParamAddress getter
 * 
 * @param ParamAddress 
 */
    public void setParamAddress(String ParamAddress) {
        this.ParamAddress = ParamAddress;
    }
/**ParamCity getter
 * 
 * @return 
 */
    public String getParamCity() {
        return ParamCity;
    }
/**ParamCity setter
 * 
 * @param ParamCity 
 */
    public void setParamCity(String ParamCity) {
        this.ParamCity = ParamCity;
    }
/**ParamState getter
 * 
 * @return 
 */
    public String getParamState() {
        return ParamState;
    }
/**ParamState setter
 * 
 * @param ParamState 
 */
    public void setParamState(String ParamState) {
        this.ParamState = ParamState;
    }
/**ParamZip setter
 * 
 * @return 
 */
    public String getParamZip() {
        return ParamZip;
    }
/**ParamZip setter
 * 
 * @param ParamZip 
 */
    public void setParamZip(String ParamZip) {
        this.ParamZip = ParamZip;
    }
/**ParamCourseDesc getter
 * 
 * @return 
 */

    public String getParamCourseDesc() {
        return ParamCourseDesc;
    }
/**ParamCourseDesc setter
 * 
 * @param ParamCourseDesc 
 */
    public void setParamCourseDesc(String ParamCourseDesc) {
        this.ParamCourseDesc = ParamCourseDesc;
    }







    
    
}
