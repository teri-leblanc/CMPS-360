/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication12;


/**
 *
 * @author Teri
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ChoiceBox listAllChoice;
     @FXML
    public ChoiceBox listTheChoice;
     @FXML
     public ChoiceBox addChoice;
     @FXML
     public TextField studentID;


   
    public void handleButtonAction(ActionEvent event) {
        //ListQuerys.IdandName();
        //ListQuerys.IdandCourse();
        //ListQuerys.IdandMajor();
        //ListQuerys.StudentMajor();
        //ListQuerys.StudentCourse();
        //ListQuerys.StudentSchedule(9);
        //ListQuerys.StudentInfo(9);
        //label.setText("Hello World!");
        switch(listAllChoice.getValue().toString()){
            case"id's and Student Names":
                ListQuerys.IdandName();
                break;
            case"Courses in the database with course ids":
                ListQuerys.IdandCourse();
                break;
            case"Majors in the database with major ids":
                ListQuerys.IdandMajor();
                break;
            case"Students with a given major":
                ListQuerys.StudentMajor();
                break;
            case"Students in a course in the database":
                ListQuerys.StudentCourse();
                break;

            default:
                break;
        
        
        }
       
    }
    
    private void handleButtonAction2(ActionEvent event) {
    switch(listTheChoice.getValue().toString()){
                case "Schedule of one student in the database":
               
                    ListQuerys.StudentSchedule(9);
       
                break;
            case "Name, address and major of one student in the database":
                
                ListQuerys.StudentInfo(9);
                break;
    
    }}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

           listAllChoice.setItems (FXCollections.observableArrayList("id's and Student Names","Courses in the database with course ids",
           "Majors in the database with major ids","Students with a given major","Students in a course in the database"));
           
          listTheChoice.setItems (FXCollections.observableArrayList("Schedule of one student in the database",
                "Name, address and major of one student in the database"));

              
    }    
    
}
