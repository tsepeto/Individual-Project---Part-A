/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object.classes;

/**
 *
 * @author tsepe
 */
public class StudentGrade {
    
    private Assignment assignment;
    private Course course;
    private int oralMark;
    private int totalMark;

    public StudentGrade() {
    }

    public StudentGrade(Assignment assignment, Course course, int oralMark, int totalMark) {
        this.assignment = assignment;
        this.course = course;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
    
}
