
package object.classes;


import database.classes.DataBase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;





/*
 *
 * @author tsepe
 * Course represents the program's course
 */
public class Course{
    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    
    public Course(String title,String stream, String type, LocalDate start_date,LocalDate end_date){
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    
    
//  title's Getter and Setter
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    
    
//  stream's Getter and Setter  
    public String getStream(){
        return this.stream;
    }
    public void setStream(String stream){
        this.stream = stream;
    }
    
    
    
//  type's Getter and Setter     
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    
    
//  start_date's Getter and Setter    
    public LocalDate getStart_date(){
        return this.start_date;
    }
    public void setStart_date(LocalDate start_date){
        this.start_date = start_date;
    }
  
    
    
//  end_date's Getter and Setter     
    public LocalDate getEnd_date(){
        return this.end_date;
    }
    public void setEnd_date(LocalDate end_date){
        this.end_date = end_date;
    }
    
    
    
//  When we try to print a Course object, we return formatted the String we want to print. 
    @Override
    public String toString(){
        String format = "%1$-30s %2$-20s %3$-20s %4$-12s %5$-3s %6$-12s";
        return String.format(format, this.title, this.stream, this.type,
                this.start_date.format(DateTimeFormatter.ofPattern(data.daTiFormat)), "-", this.end_date.format(DateTimeFormatter.ofPattern(data.daTiFormat)));}
}
