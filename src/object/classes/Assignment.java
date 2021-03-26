
package object.classes;


import database.classes.DataBase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 *
 * @author tsepe
 * 
 * Assignment represents the program's assignment
 */
public class Assignment {
    
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    
    public Assignment(String title, String description, LocalDate subDateTime, int oralMark, int totalMark){
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;}
    
    
    
//  title's Getter and Setter
    public void setTitle(String title){
        this.title = title;}
    
    public String getTitle(){
        return this.title;}
    
    
    
//  description's Getter and Setter
    public void setDescription(String description){
        this.description = description;}
    
    public String getDescription(){
        return this.description;}
    
    
    
//  subDateTime's Getter and Setter
    public void setSubDateTime(LocalDate subDateTime){
        this.subDateTime = subDateTime;}
    
    public LocalDate getSubDateTime(){
        return this.subDateTime;}
    
    
    
//  oralMark's Getter and Setter
    public void setOralMark(int oralMark){
        this.oralMark = oralMark;}
    
    public int getOralMark(){
        return this.oralMark;}
    
    
    
//  totalMark's Getter and Setter
    public void setTotalMark(int totalMark){
        this.totalMark = totalMark;}
    
    public int getTotalMark(){
        return this.totalMark;}
    
    
    
    /**
     * returns the deadline's week's number of the year
     * @return int
     */
    public int getWeekOfYearDeadlint(){
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
        int weekNumber = this.getSubDateTime().get(woy);
        return weekNumber;
    }
    
    
//  When we try to print an Assignment object, we return formatted the String we want to print. 
    @Override
    public String toString(){
        String format = "%1$-30s %2$-55s %3$-15s %4$-5s %5$-5s %6$-5s %7$-5s";
        return String.format(format, this.title, this.description, this.subDateTime.format(DateTimeFormatter.ofPattern(data.daTiFormat)),
                "O.M.", this.oralMark, "T.M.", this.totalMark);}
    
    
}
