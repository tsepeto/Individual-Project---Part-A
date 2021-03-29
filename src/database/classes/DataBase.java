
package database.classes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import object.classes.Assignment;
import object.classes.Course;
import object.classes.Student;
import object.classes.StudentGrade;
import object.classes.Trainer;

/**
 * @author tsepe
 * 
 * 
 * The DataBase Class is the program's database.
 * Here the program saves all the data in ArrayLists and returns the results of
 * the queries that frond end classes(Views) do
 * 
 */
public class DataBase {
    
    private ArrayList<Course> courses = new ArrayList();                        //Here saves all the Courses 
    private ArrayList<Trainer> trainers = new ArrayList();                      //Here saves all the Trainers 
    private ArrayList<Student> students = new ArrayList();                      //Here saves all the Students 
    private ArrayList<Assignment> assignments = new ArrayList();                //Here saves all the Assignments 
    
                       
    private DataConnectorTable<Course, Student>     coursesStudents = new DataConnectorTable();     //Creates a connector Table for Courses and Students
    private DataConnectorTable<Course, Trainer>     coursesTrainers = new DataConnectorTable();     //Creates a connector Table for Courses and Trainers
    private DataConnectorTable<Course, Assignment>  coursesAssignments = new DataConnectorTable();  //Creates a connector Table for Courses and Assignments
    
    private DataConnectorTable<Student, StudentGrade> studentsGrades = new DataConnectorTable();    //Creates a connector Table for Students and StudentGrades
    
    public enum viewFor{CREATE, EDIT, SEARCH;} // We use them to call the Views of objectMenu, so that they know for what purpose we want them
    
    public final String daTiFormat = "dd/MM/yyyy";                              //The date time format
    
    private static DataBase instance;// = new DataBase();
    
    
    private DataBase(){}                                                        //We are going to make DataBase as a singletone class
    
    /**
     * Returns the DataBase's instance. If DataBase doesn't have an instance, then
     * instanciate a DataBase, and returns that instance.
     * @return DataBase instance
     */
    public static DataBase getInstance(){
        
        if( instance == null){
            instance = new DataBase();
        }
        return instance;
    }
    
    
    
    
    //All the methods for Course
    
    
    //A this.courses setter
    public void setCourses(ArrayList<Course> courses){
        this.courses = courses;
    }
    
    
    //A this.courses.getter
    public ArrayList<Course> getCourses(){
        return this.courses;
    }
    
    /**
     * Get all courses that are active in given date
     * @param localDate
     * @return ArrayList with courses
     */
    public ArrayList<Course> getCourses(LocalDate localDate){
        ArrayList<Course> courses = new ArrayList(this.getCourses());           //Takes a copy from all Courses
        Iterator<Course> iter = courses.iterator();
         while(iter.hasNext()){                                                 
             Course course = iter.next();
             if(course.getStart_date().isAfter(localDate) || course.getEnd_date().isBefore(localDate)){ //If the course is not active in the given date
                 iter.remove();                                                 //We remove that course from courses.
             }
         
         }
         return courses;                                                        //Returns only the active courses in the given date.
    }
    
    
    /**
     * Adds a course to this.courses
     * @param newCourse 
     */
    public void addCourse(Course newCourse){
        this.courses.add(newCourse);
    }
    
    
    /**
     * Save the given Course, and make the connection with the Students and the
     * Trainers
     * @param course 
     * @param Arraylist students
     * @param Arraylist trainers 
     */
    public void saveCourse(Course course,ArrayList<Student> students, ArrayList<Trainer> trainers){
        addCourse(course);
        for(Student student : students){
            coursesStudents.add(course, student);}
        for(Trainer trainer : trainers){
            coursesTrainers.add(course, trainer);}
    }
    
    
    /**
     * Checks if a given Course is already saved in database
     * @param Course
     * @return boulean
     */
    public boolean doesCourseExist(Course course){
        for(Course listedCourse:this.courses){
            if (course.getType().equals(listedCourse.getType())         && 
                course.getTitle().equals(listedCourse.getTitle())       &&
                course.getStream().equals(listedCourse.getStream())     &&
                course.getEnd_date().equals(listedCourse.getEnd_date()) &&
                course.getStart_date().equals(listedCourse.getStart_date())
                ){
                
                return true;}
        }
        return false;
    }
    
    
    
    
    /**
     * Deletes that course and it's associated rows from tables.
     * @param course 
     */
    public void deleteCourse(Course course){
        this.courses.remove(course);
        this.coursesAssignments.deleteRowsWhenAIs(course);
        this.coursesStudents.deleteRowsWhenAIs(course);
        this.coursesTrainers.deleteRowsWhenAIs(course);
    }
    
    
    
    
    
    //     All the methods for the Trainers
    
    
    
    //A this.trainers getter
    public ArrayList<Trainer> getTrainers(){
        return this.trainers;
    }
        
    
    /**
     * Saves the Trainer in database.
     * @param newTrainer 
     */
    public void saveTrainer(Trainer newTrainer){
        this.trainers.add(newTrainer);
    }
    
    //A this.trainers setter
    public void setTrainers(ArrayList<Trainer> trainers){
        this.trainers = trainers;
    }
    
    
    /**
     * Returns true if the Trainer is already saved in the database.
     * @param student
     * @return boolean
     */
    public boolean doesTrainerExist(Trainer trainer){
        
        for(Trainer listedTrainer:this.trainers){
            if (trainer.getLastName().equals(listedTrainer.getLastName())&&
                trainer.getFirstName().equals(listedTrainer.getFirstName())){
                
                return true;}
        }
        return false;
    }
    
    
    
    /**
     * Deletes the trainer from the system.
     * @param student 
     */
    public void deleteTrainer(Trainer trainer){
        this.trainers.remove(trainer);                                          //Renoves the Trainer from the trainer List
        this.coursesTrainers.deleteRowsWhenBIs(trainer);                        //Removes all the trainer's connection with the curses
    }
    
    
    
    
    
    //  All the methods for the students. 
    
    
    //A  this.students setter
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    
     
    //A  this.students setter 
    public void setStudents(ArrayList<Student> studentss){
        this.students = students;
    }   
    
    
    /**
     *  Saves the student
     * @param newStudent 
     */
    public void saveStudent(Student newStudent){
        this.students.add(newStudent);
    }
    
    /**
     * Deletes the student from the system.
     * @param student 
     */
    public void deleteStudent(Student student){
        this.students.remove(student);                                          //Renoves the Student from the Student List
        this.coursesStudents.deleteRowsWhenBIs(student);                        //Removes all the student's connection with the curses
    }
    
    
    /**
     * Returns true if the Student is already saved in the database.
     * @param student
     * @return boolean
     */
    public boolean doesStudentExist(Student student){
        for(Student listedStudent:this.students){
            if (student.getLastName().equals(listedStudent.getLastName())   &&
                student.getFirstName().equals(listedStudent.getFirstName()) &&
                student.getDateOfBirth().equals(listedStudent.getDateOfBirth())){
                
                return true;
            }
        }
        return false;
    }
    
    
    
    
    //All the methods for Assignments
    

    /**
     * Adds an assignment to the Assignment ArrayList
     * @param assignment 
     */
    public void addAssignment(Assignment assignment){
        this.assignments.add(assignment);
    }
    
    
    /**
     *this.assignments getter
     */
    public ArrayList<Assignment> getAssignments(){
        return this.assignments;
    }
    
    
    /**
     * this.Assignments setter
     */ 
    public void setAssignments(ArrayList<Assignment> assignment){
        this.assignments = assignment;
    }
    
    
    /**
     * Saves the Assignment, and saves the assignment's courses in the connector table
     * @param assignment
     * @param courses 
     */
    public void saveAssignment(Assignment assignment, ArrayList<Course> courses){
        addAssignment(assignment);
        for(Course course:courses){
            coursesAssignments.add(course, assignment);}
    }
    
    
    
    /**
     * Returns true if the assignment is already saved in the database.
     * @param assignment
     * @return boolean
     */
    public boolean doesAssignmentExist(Assignment assignment){
        for(Assignment listedAssignment:this.assignments){
            if (assignment.getTitle().equals(listedAssignment.getTitle())               &&  // Checks every assignment entry if is equal to
                assignment.getDescription().equals(listedAssignment.getDescription())   &&  //given assignment.
                assignment.getSubDateTime().equals(listedAssignment.getSubDateTime())){
                return true;
            }
        }
        return false;
    }
    
    
    
     /**
     * Deletes the assignment from the system.
     * @param assignment 
     */
    public void deleteAssignment(Assignment assignment){
        this.assignments.remove(assignment);                                    //Renoves the Assignment from the Assignment List
        this.coursesAssignments.deleteRowsWhenBIs(assignment);                  //Removes all the assignment's connection with the curses
    }
    
    
    
    /**
     * Takes a date and returns all the assignments who their deadline is over 
     * the same week as the given date's week.
     * We want to calculate the week from Monday to Sunday, not from Sunday to 
     * Saturday, as Default.
     * @param localDate
     * @return ArrayList with Assignments
     */
    public ArrayList<Assignment> AssignmentsMustDelivered(LocalDate localDate){
        ArrayList<Assignment> result = new ArrayList();
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
        int dateWeekNumber = localDate.get(woy);
        if(localDate.getDayOfWeek()== DayOfWeek.SUNDAY){                        //If the date is queal to SUNDAY
            dateWeekNumber -=1;                                                 //We minus the week by one. That's how we tell that the Sunday is in the previous week!!!
        } 
        for (Assignment assignment : this.getAssignments()){
            if(assignment.getWeekOfYearDeadlint() == dateWeekNumber){
                result.add(assignment);
            }
        }
        return result;
    }
    
    
    
    //connections and questions in database
    
    
    /**
     * Adds the given student in the given course.
     * @param student
     * @param course 
     */
    public void addStudentInCourse(Student student, Course course){
        this.coursesStudents.add(course, student);
    }
    
    
     /**
     * Adds the given trainer in the given course.
     * @param trainer
     * @param course 
     */
    public void addTrainerInCourse(Trainer trainer, Course course){
        this.coursesTrainers.add(course, trainer);
    }
    
    
    
    /**
     * Adds the given course in the given assignment.
     * @param course
     * @param assignment 
     */
    public void addCourseInAssignment( Course course,Assignment assignment){
        this.coursesAssignments.add(course, assignment);
    }
    
    
    
    /**
     * Removes the given student from the given course.
     * @param student
     * @param course 
     */
    public void removeStudentFromCourse(Student student, Course course){
        
        this.coursesStudents.deleteRowsWhenAAndBAre(course,student);
    }
    
    
     /**
     * Removes the given trainer from the given course.
     * @param student
     * @param course 
     */
    public void removeTrainerFromCourse(Trainer trainer, Course course){
        
        this.coursesTrainers.deleteRowsWhenAAndBAre(course,trainer);
    }
    
    
    
    /**
     * Removes the given course from the given assignment.
     * @param course
     * @param assignment 
     */
    public void removeCourseFromAssignment(Course course, Assignment assignment){
        
        this.coursesAssignments.deleteRowsWhenAAndBAre(course,assignment);
    }
    
    
    
    /**
     * The method takes an assignment and returns all the Courses from the database 
     * that are not associated with that assignment.
     * @param assignment
     * @return ArrayList with courses
     */
    public ArrayList<Course> getCoursesAreNotInAssignment(Assignment assignment){
        ArrayList<Course> coursesAreNotInAssignment = new ArrayList(getCourses());//the program copies all the assignments in coursesAreNotInAssignment list
        for(Course course:getCoursesFromAssignment(assignment)){                // program removes the courses that are associated with this assignment from coursesAreNotInAssignment list
            coursesAreNotInAssignment.remove(course);                           // and now the list coursesAreNotInAssignment, has only the trainers that are not associated with that assigment
        }
        return coursesAreNotInAssignment;
    }
    
    
    
    /**
    *
    * Returns all the Courses of a Student
    *@return ArrayList of Courses
    *@param Student
    */
    public ArrayList<Course> getCoursesFromStudent(Student student){
        ArrayList<Course> result = coursesStudents.getAWhenB(student);
        return result;
    }
    
    
    
    /**
    *
    * Returns all the Courses of a Trainer
    *@return ArrayList of Courses
    *@param Trainer
    */
    public ArrayList<Course> getCoursesFromTrainer(Trainer trainer){
        ArrayList<Course> result = coursesTrainers.getAWhenB(trainer);
        return result;
    }
    
    
    
    /**
    *
    * Returns all the Courses of an Assignment
    *@return ArrayList (Course)
    *@param Assignment
    */
    public ArrayList<Course> getCoursesFromAssignment(Assignment assignment){
        ArrayList<Course> result = coursesAssignments.getAWhenB(assignment);
        return result;
    }
    
    
    
    /**
    *
    * Returns all the Students of a Course
    *@return ArrayList of Students
    *@param Course
    */
    public ArrayList<Student> getStudentsFromCourse(Course course){
        ArrayList<Student> result = coursesStudents.getBWhenA(course);
        return result;
    }
    
    
    
    /**
     * The method takes a course and returns all the Students from the database 
     * who are not associated with that course.
     * @param course
     * @return ArrayList with students
     */
    public ArrayList<Student> getStudentsAreNotInCurse(Course course){
        ArrayList<Student> studentsAreNotInCourse = new ArrayList(getStudents());//the program copies all the students in studentsAreNotInCourse list
        for(Student student: getStudentsFromCourse(course)){                    // program removes the students that are associated with this course from studentsAreNotInCourse list
            studentsAreNotInCourse.remove(student);                             // and now the list studentsAreNotInCourse, has only the students that are not associated with that course
        }
        return studentsAreNotInCourse;
    }
    
    
    
    /**
     * Returns an ArrayList with the Students which are enrolled in more than 
     * a number of lessons that the variable lessons declares.
     * @param lessons
     * @return ArrayList with Students
     */
    public ArrayList<Student> getStudentsWhenLessonsMoreThan(int lessons){
        ArrayList<Student> result = new ArrayList();
        for(Student student : this.students){
            int courses = this.coursesStudents.howManyAWhenB(student);
            if(courses > lessons){ result.add(student);}
        }
        return result;
    }
    
    
    /**
     * The method takes a course and returns all the Trainers from the database 
     * who are not associated with that course.
     * @param course
     * @return ArrayList with students
     */
    public ArrayList<Trainer> getTrainersAreNotInCurse(Course course){
        ArrayList<Trainer> trainersAreNotInCourse = new ArrayList(getTrainers());//the program copies all the trainers in trainersAreNotInCourse list
        for(Trainer trainer: getTrainersFromCourse(course)){                    // program removes the trainers that are associated with this course from trainersAreNotInCourse list
            trainersAreNotInCourse.remove(trainer);                             // and now the list trainersAreNotInCourse, has only the trainers that are not associated with that course
        }
        return trainersAreNotInCourse;
    }
    
    
    
    /**
    *
    * Returns all the Trainers of a Course
    *@return ArrayList of Trainers
    *@param Course
    */
    public ArrayList<Trainer> getTrainersFromCourse(Course course){
        ArrayList<Trainer> result =coursesTrainers.getBWhenA(course);
        return result;
    }
    
    
    /**
    *
    * Returns all the assignments of a Course
    *@return ArrayList of Assignments
    *@param Course
    */
    public ArrayList<Assignment> getAssignmentsFromCourse(Course course){
        ArrayList<Assignment> result = coursesAssignments.getBWhenA(course);
        return result;
    }
    
    
    /**
    *
    * Returns all the assignments of a Student
    *@return DataConnectorTable table of (list of Courses, list of Assignments)
    *@param Student
    */
    public DataConnectorTable<Course, Assignment> getAssignmentsFromStudent(Student student){
        DataConnectorTable<Course, Assignment> result = new DataConnectorTable();           //Creates an DataConnectorTable for Courses and Assignments,and we add the results in it.
        ArrayList<Course> userCourses = getCoursesFromStudent(student);                     //Creates a list of the Student's courses 
        for(Course course: userCourses){                                                    //For every course inside the list    
            ArrayList<Assignment> listCourseAssignments = getAssignmentsFromCourse(course); // finds the course's assignments and adds them to the list.
            for(Assignment assignment : listCourseAssignments){             
                result.add(course, assignment);}
            }
        return result;
    }

    
//  <----------------------        Whatever the database needs for StudenGrades      ---------------------------->
    
    
    
    
    public void saveStudentGrade(Student student, StudentGrade studentGrade){
        this.studentsGrades.add(student, studentGrade);
    }
    
    /**
     * Looking for all Student's StudentGrades and returs StudentGrades list of a specific 
     * course.
     * @param student
     * @param course
     * @return ArrayList of StudentGrade
     */
    public ArrayList<StudentGrade> getStudentGradesFromCourse(Student student, Course course){
        ArrayList<StudentGrade> result = new ArrayList();                       //Here saves only the StudentGrades of the given Course
        ArrayList<StudentGrade> allStudentGrade = studentsGrades.getBWhenA(student);//Takes all the Student's StudentGrades
        Iterator<StudentGrade> iter = allStudentGrade.iterator();
        while(iter.hasNext()){                                                  //Checks if there are StudentGrades of this course
            StudentGrade i = iter.next();                                       //If there is a course's StudentGrade it adds it in result list
            if(course.equals(i.getCourse())== true ){
                result.add(i);
            }
        }
        return result;                                                          //returns the result list
    }
    
    
    
    /**
     * Checks if the student has grades for a specific course's assignment.
     * @param student
     * @param course
     * @param assignment
     * @return 
     */
    public boolean doesExistStudentGradeForAssignment(Student student, Course course,Assignment assignment){
        boolean result = false;
        ArrayList<StudentGrade> studentGrades = getStudentGradesFromCourse(student,course);
        for(StudentGrade sg : studentGrades){
            if( sg.getAssignment().equals(assignment)){
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Returns all unrated user's assignments for a specific Course
     * @param student
     * @param course
     * @return ArrayList of unrated Assignments
     */
    public ArrayList<Assignment> getStudentUnratedAssignmentsFromCourse(Student student, Course course){
        ArrayList<Assignment> courseAssignments = new ArrayList(getAssignmentsFromCourse(course)); //A copy of all course's assignments
        Iterator<Assignment> iter = courseAssignments.iterator();
         while(iter.hasNext()){                                                 //Checks all course's assignment
             Assignment assignment = iter.next();
             if(doesExistStudentGradeForAssignment(student,course,assignment)){ //If the Student is rated in that assignment
                 iter.remove();                                                 //We remove that assignment from courseAssignments.
             }
         
         }
         return courseAssignments;                                              //Returns all unreated user's assignment for that course
    }
    
    
    
    
    /**
     * Returns all rated user's assignments for a specific Course
     * @param student
     * @param course
     * @return ArrayList of unrated Assignments
     */
    public ArrayList<Assignment> getStudentRatedAssignmentsFromCourse(Student student, Course course){
        ArrayList<Assignment> courseAssignments = new ArrayList(getAssignmentsFromCourse(course)); //A copy of all course's assignments
        Iterator<Assignment> iter = courseAssignments.iterator();
         while(iter.hasNext()){                                                 //Checks all course's assignment
             Assignment assignment = iter.next();
             if(doesExistStudentGradeForAssignment(student,course,assignment) == false){ //If the Student is not rated in that assignment
                 iter.remove();                                                 //We remove that assignment from courseAssignments.
             }
         
         }
         return courseAssignments;                                              //Returns all reated user's assignment for that course
    }
    
    
    
    
    /**
     * Returns the StudentGrade that has the given parameters.
     * @param student
     * @param course
     * @param assignment
     * @return StudentGrade
     */
    public StudentGrade getStudentGradeForAssignment(Student student, Course course,Assignment assignment){
        StudentGrade result=null;
        ArrayList<StudentGrade> studentGrades = getStudentGradesFromCourse(student,course);
        for(StudentGrade sg : studentGrades){
            if( sg.getAssignment().equals(assignment)){
                result = sg;
            }
        }
        return result;
    }
}
    
