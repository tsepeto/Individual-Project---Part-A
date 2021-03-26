
package console.views.createviews;

import console.utils.Style;
import console.utils.Input;
import console.views.menuviews.OtherViews;
import database.classes.DataBase;
import java.time.LocalDate;
import java.util.ArrayList;
import object.classes.Assignment;
import object.classes.Course;

/**
 * @author tsepe
 * CreateAssignmet is a View that the program calls it every time the user
 * chooses to create a new assignment.
 */
public class CreateAssignment {
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    
    
    /**
     * The method shows the view and starts the assignment's create procedure 
     */
    public static void show(){
        Style.addLines(1);
        boolean createMore = true;
        while(createMore == true){    
            assignmentCreator();                                                //starts the assignment's creation procedure.
            Style.addLines(1);
            Style.addUnderline();
            System.out.println(Style.yellow("DO YOU WANT TO CREATE ANOTHER ONE ASSIGNMENT?"));//asks the user, if he want to create another assignment.
            System.out.println(Style.green("1 - YES"));
            System.out.println(Style.red("2 - NO"));
            Style.addUnderline();
            boolean more = Input.giveYesOrNo();
            
            if( more == true){
                Style.addLines(1);
                System.out.println(Style.green("LET'S CREATE THE NEXT ASSIGNMENT!"));
                Style.addLines(1);}
            else{
                System.out.println(Style.green("THE CREATION PROCESS IS OVER"));
                createMore = false;
            }    
        }
    }
    
    
    /**
     * The method assignmentCreator() is the assignment creation procedure
     */
    private static void assignmentCreator(){
        String title;
        String description;
        LocalDate subDateTime;
        int oralMark;
        int totalMark;
        Assignment assignment;
        boolean assignmentSaved = false;
        
        while(assignmentSaved == false){
            System.out.println(Style.yellow("PLEASE GIVE THE ASSIGNMENT'S TITLE:"));
            title = Input.input.next();
            System.out.println(Style.yellow("PLEASE GIVE THE ASSIGNMENT'S DESCRITION:"));
            description = Input.input.next();
            System.out.println(Style.yellow("PLEASE GIVE THE ASSIGNMENT'S DEADLINE:"));
            subDateTime = Input.giveADate(); //TODO giveDate
            System.out.println(Style.yellow("PLEASE GIVE THE ASSIGNMENT'S ORAL MARK:"));
            oralMark = Input.giveOnlyInteger(); //TODO giveDate
            System.out.println(Style.yellow("PLEASE GIVE THE ASSIGNMENT'S TOTAL MARK:"));
            totalMark = Input.giveOnlyInteger(); //TODO giveDate
            Style.addLines(2);
            System.out.println(Style.yellow("CHOOSE COURSES:"));
            Style.addUnderline();
            ArrayList<Course> courseList = OtherViews.courseChoose.chooseMany(data.getCourses());         // Lets the user to choose some Courses
            if(courseList.size()==0){
                System.out.println(Style.red("THERE ARE NO COURSES TO ADD YET!!! "));
                System.out.println(Style.red("YOU CAN ADD COURSES TO THIS ASSIGNMENT LATER, FROM EDITING MENU!!!"));
            }
            assignment = new Assignment(title,description,subDateTime,oralMark,totalMark);  // Creates a temporary Assignment
            
            if (!data.doesAssignmentExist(assignment)){             // Checks if the assignment allready exists,
                data.saveAssignment(assignment,courseList);         // if not saves it in the database.
                assignmentSaved = true;                                         // Here it stops the while loop.
            }
            else{
                Style.addLines(1);                                              // If assignment allready exists, the method starts again the assignment's creation procedure.
                System.out.println(Style.red("THIS ASSIGNMENT ALLREADY EXISTS,PLEASE CREATE ANOTHER ASSIGNMENT."));
                break;}
        }
       
    }
}
