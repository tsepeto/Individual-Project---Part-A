
package console.views.searchviews;

import console.utils.Style;
import console.utils.Input;
import console.views.menuviews.ObjectMenu;
import console.views.menuviews.OtherViews;
import database.classes.DataBase;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import object.classes.Assignment;
import object.classes.Course;
import object.classes.Student;
import object.classes.Trainer;

/**
 *
 * @author tsepe
 * 
 * In that View the user chooses what we want to search in courses
 */
public class SearchInCoursesView {
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    
    /**
     * Shows the View and ask the user to choose what to ask for a course
     */
    public static void show(){
        while(true){
            Style.addLines(1);
            System.out.println(Style.yellow("WHAT DO YOU WANT TO SEE?"));
            Style.addUnderline();
            System.out.println(Style.yellow("1")+" - SHOW ALL THE COURSES");
            System.out.println(Style.yellow("2")+" - SHOW A COURSE'S DETAILS");
            System.out.println(Style.yellow("3")+" - SHOW A COURSE'S STUDENTS");
            System.out.println(Style.yellow("4")+" - SHOW A COURSE'S TRAINERS");
            System.out.println(Style.yellow("5")+" - SHOW A COURSE'S ASSIGNMENTS");
            System.out.println(Style.yellow("6")+" - BACK ");
            Style.addUnderline();
            Style.addLines(1);
            int input = Input.giveOnlyInteger(1, 6);

            switch(input){
                case 1:
                    showCourses();
                    break;

                case 2:
                    showCourseDetails();
                    break;

                case 3:
                    showStudentsInCourse();
                    break;

                case 4:
                    showTrainersInCourse();
                    break;

                case 5:
                    showAssignmentsInCourse();
                    break;

                case 6:
                    ObjectMenu.showFor(DataBase.viewFor.SEARCH);
                    break;

            }
        }
    }
    
    
    /**
     * Prints all the courses we have in database
     * @param courses list
     */
    private static void printCourses(ArrayList<Course> courses){
        
        Style.addLines(1);
        System.out.println("COURSES");
        Style.addUnderline();
        int counter = 1;
        System.out.println(Style.yellow(Style.createFormat(new int[]{3,3,20,30,20},new String[]{"","","STREAM", "TITLE", "TYPE"})));
        
        for(Course course:courses){
            Style.printFormatted( new int[]{3,3,20,30,20},
                                new String[]{Style.yellow(counter +""), Style.yellow(" - "), course.getStream(), course.getTitle(), course.getType()});
            
            counter+=1;
        }
        Style.addUnderline();
        Style.addLines(1);
    }
    
    
    /**
     * The method prints Courses and waits the user to give something to go
     * to the previous view
     */
    private static void showCourses(){
        if(data.getCourses().size()>0){
            printCourses(data.getCourses());
            Input.pressToGoBack();
        }
        else{
            System.out.println(Style.red("THERE ARE NO TRAINERS IN DATABASE!!!"));
            System.out.println(Style.red("PLEASE CREATE SOME AND TRY TO SEARCH LATER!!!"));
            Input.pressToGoBack();
        }
    }
    
    
    /**
     * The method prints the details of the chosen Course
     */
    private static void showCourseDetails(){
         if(data.getCourses().size()>0){
            Course result = OtherViews.courseChoose.chooseOne(data.getCourses());//The user chooses Course

            Style.addLines(1);
            System.out.println(Style.yellow("COURSE DETAILS:"));
            Style.addUnderline();
            Style.printFormatted(new int[]{40, 30}, new String[]{Style.yellow("TITLE: "), result.getTitle()});
            Style.printFormatted(new int[]{40, 30}, new String[]{Style.yellow("STREAM: "), result.getStream()});
            Style.printFormatted(new int[]{40, 30}, new String[]{Style.yellow("TYPE: "), result.getType()});
            Style.printFormatted(new int[]{40, 30}, new String[]{Style.yellow("START DATE: "), result.getStart_date().format(DateTimeFormatter.ofPattern(data.daTiFormat))});
            Style.printFormatted(new int[]{40, 30}, new String[]{Style.yellow("END DATE: "), result.getEnd_date().format(DateTimeFormatter.ofPattern(data.daTiFormat))});

            Style.addUnderline();
            Style.addLines(1);

            Input.pressToGoBack();
            }
        else{
            System.out.println(Style.red("THERE ARE NO TRAINERS IN DATABASE!!!"));
            System.out.println(Style.red("PLEASE CREATE SOME AND TRY TO SEARCH LATER!!!"));
            Input.pressToGoBack();
        }
    }
    
    
    /**
     * The method prints the Students of the chosen Course
     */
    private static void showStudentsInCourse(){ 
        if(data.getCourses().size()>0){
            Course result = OtherViews.courseChoose.chooseOne(data.getCourses()); //Here the user chooses the curse he wants
            ArrayList<Student> students = data.getStudentsFromCourse(result);   //Here we take the curse's students from database
            int counter = 1;
            System.out.println(Style.yellow("STUDENTS IN C??URSE: ") + students.size());
            Style.addUnderline();
            if(students.size()>0){
                for(Student student:students){                                      //Prints the students
                    System.out.println(Style.yellow(counter + " - ")+ student);
                    counter ++;
                }
            }
            else{
                System.out.println(Style.red("THERE ARE NO STUDENTS IN THAT COURSE.PLEASE ADD SOME FROM EDITING MENU!!!"));
            }
            Style.addUnderline();
            Style.addLines(1);

            Input.pressToGoBack();
            }
        else{
            System.out.println(Style.red("THERE ARE NO COURSES!!! PLEASE ADD COURSE FIRST!!!)"));
            Input.pressToGoBack();
        }
    }
    
    
    /**
     * The method prints the Students of the chosen Course
     */
    private static void showTrainersInCourse(){  
        if(data.getCourses().size()>0){
            Course course = OtherViews.courseChoose.chooseOne(data.getCourses()); //Here the user chooses the curse he wants
            ArrayList<Trainer> trainers = data.getTrainersFromCourse(course);   //Here we take the curse's trainers from database
            int counter = 1;
            System.out.println(Style.yellow("TRAINERS IN CURSE :") + trainers.size());
            Style.addUnderline();
            if(trainers.size()>0){
                for(Trainer trainer:trainers){
                    System.out.println(Style.yellow(counter + " - ")+ trainer);     //Prints the students
                }
            }
            else{
                System.out.println(Style.red("THERE ARE NO TRAINERS IN THA COURSE.PLEASE ADD SOME FROM EDITING MENU!!!"));
            }
            Style.addUnderline();
            Style.addLines(1);

            Input.pressToGoBack();
        }
        else{
            System.out.println(Style.red("THERE ARE NO TRAINERS IN DATABASE!!!"));
            System.out.println(Style.red("PLEASE CREATE SOME AND TRY TO SEARCH LATER!!!"));
            Input.pressToGoBack();
        }
    }
    
    
    
    /**
     * The method prints the assignments of the chosen Course
     */
    private static void showAssignmentsInCourse(){   
        if(data.getCourses().size()>0){
            
            Course course = OtherViews.courseChoose.chooseOne(data.getCourses()); //Here the user chooses the curse he wants
            ArrayList<Assignment> assignments = data.getAssignmentsFromCourse(course); //Here we take the curse's assignments from database
            int counter = 1;
            System.out.println(Style.yellow("ASSIGNMENTS IN CURSE :") + assignments.size());
            Style.addUnderline();
            if(assignments.size()>0){
                for(Assignment assignment:assignments){                             //Prints the assignments
                    System.out.println(Style.yellow(counter + " - ")+ assignment);
                    counter++;
                }
            }
            else{
                System.out.println(Style.red("THERE ARE NO ASSIGNMENTS IN THAT COURSE.PLEASE ADD SOME FROM EDITING MENU!!!"));
            }
            Style.addUnderline();
            
            Style.addLines(1);

            Input.pressToGoBack();
        }
        else{
            System.out.println(Style.red("THERE ARE NO TRAINERS IN DATABASE!!!"));
            System.out.println(Style.red("PLEASE CREATE SOME AND TRY TO SEARCH LATER!!!"));
            Input.pressToGoBack();
        }
    }
}
