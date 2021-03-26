
package object.classes;


import database.classes.DataBase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author tsepe
 * Student represents the program's student.
 */
public class Student {
    
    private String firstName ;
    private String lastName ;
    private LocalDate dateOfBirth ;
    private double tuitionFees ;
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.

    
    public Student(String firstName, String lastName, LocalDate dateOfBirth, double tuitionFees){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }
    
    
    
//  firstName's Getter and Setter 
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    
    
//  lastName's Getter and Setter 
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    
    
//  dateofBirth's Getter and Setter 
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    
    
    
//  tuitionFees's Getter and Setter 
    public void setTuitionFees(double tuitionFees){
        this.tuitionFees = tuitionFees;
    }
    
    public double getTuitionFees(){
        return this.tuitionFees;
    }
    
    
    /**
     * Saves the student mark in a course's assignment.
     * @param assignment
     * @param course
     * @param oralMark
     * @param totalMark 
     */
    public void saveAssignmentMark(Assignment assignment,Course course, int oralMark, int totalMark){
        data.saveStudentGrade(this,new StudentGrade(assignment,course,oralMark,totalMark));
    }
    

    
//  When we try to print a Student object, we return formatted the String we want to print. 
    @Override
    public String toString(){
        String format = "%1$-15s %2$-20s %3$-15s %4$-18s";
        return String.format(format, this.firstName, this.lastName, this.dateOfBirth.format(DateTimeFormatter.ofPattern(data.daTiFormat)),
                            "  -  " + this.tuitionFees +"€");
    }
    
    
}
