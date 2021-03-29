
package console.views.createviews;


import console.utils.Style;
import console.utils.Input;
import console.views.menuviews.OtherViews;
import database.classes.DataBase;
import java.time.LocalDate;
import java.util.ArrayList;
import object.classes.Course;
import object.classes.Student;
import object.classes.Trainer;

/**
 *
 * @author tsepe
 * CreateCourse is a View that the program calls it every time the user
 * chooses to create a new course.
 */
public class CreateCourse {
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    
    /**
     * The method shows the view and starts the course's create procedure 
     */
    public static void show(){
        Style.addLines(1);
        boolean createMore = true;
        while(createMore == true){    
            courseCreator();                                                    //starts the course's create procedure.
            Style.addLines(1);
            Style.addUnderline();
            System.out.println(Style.yellow("DO YOU WANT TO CREATE ANOTHER COURSE?"));        //asks the user, if he want to create another course.
            System.out.println(Style.green("1 - YES"));
            System.out.println(Style.red("2 - NO"));
            Style.addUnderline();
            boolean more = Input.giveYesOrNo();
            
            if( more == true){
                Style.addLines(1);
                System.out.println(Style.green("LET'S CREATE THE NEXT COURSE!"));
                Style.addLines(1);}
            else{
                System.out.println(Style.green("THE COURCE'S CREATION PROGRESS IS OVER!"));
                createMore = false;
            }    
        }
    }
    
    
    
    /**
     * The method assignmentCreator() is the assignment creation procedure
     */
    private static void courseCreator(){
        String title;
        String stream;
        String type;
        LocalDate start_date;
        LocalDate end_date;
        Course course;
        boolean courseSaved = false;
        
        while(courseSaved == false){
            System.out.println(Style.yellow("GIVE THE COURSE'S TITLE:"));
            title = Input.input.nextLine();
            System.out.println(Style.yellow("GIVE THE COURSE'S STREAM:"));
            stream = Input.input.nextLine();
            System.out.println(Style.yellow("GIVE THE COURSE'S TYPE:"));
            type = Input.input.nextLine(); 
            System.out.println(Style.yellow("GIVE THE COURSE'S STARTING DATE:"));
            start_date = Input.giveADate(); 
            System.out.println(Style.yellow("GIVE THE COURSE'S ENDING DATE:"));
            end_date = Input.giveLaterDateThan(start_date); 
            Style.addLines(2);
            System.out.println(Style.yellow("CHOOSE STUDENTS:"));
            Style.addUnderline();
            ArrayList<Student> studentList = OtherViews.studentChoose.chooseMany(data.getStudents()); // Lets the user to choose some students
            if(studentList.size() == 0){
                System.out.println(Style.red("THERE ARE NO STUDENTS TO ADD YET!!! "));
                System.out.println(Style.red("YOU CAN ADD STUDENTS TO THIS COURSE FROM EDITING MENU!!!"));
                Input.pressToGoBack();
                Style.addLines(1);
            }
            System.out.println(Style.yellow("CHOOSE TRAINERS:"));
            Style.addUnderline();
            ArrayList<Trainer> trainerList = OtherViews.trainerChoose.chooseMany(data.getTrainers()); // Lets the user to choose some trainers
            
            if(trainerList.size() == 0){
                System.out.println(Style.red("THERE ARE NO TRAINERS TO ADD YET!!! "));
                System.out.println(Style.red("YOU CAN ADD STUDENTS TO THIS COURSE FROM EDITING MENU!!!"));
                Input.pressToGoBack();
            }
            
            
            course = new Course(title,stream,type,start_date,end_date);         // Creates a temporary course.
            
            if (!data.doesCourseExist(course)){                                 // Checks if the course allready exists,
                data.saveCourse(course,studentList,trainerList);                // if not saves it in the database.
                courseSaved = true;                                             // Here it stops the while loop.
            }
            else{
                Style.addLines(1);                                              // If course allready exists, the method starts again the course's creation procedure.
                System.out.println(Style.red("THIS COURSE ALLREADY EXISTS,PLEASE CREATE ANOTHER ASSIGNMENT."));
                break;}
        }
       
    }
    
}
