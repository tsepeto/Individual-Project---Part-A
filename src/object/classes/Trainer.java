
package object.classes;

import console.utils.Style;

/*
 * @author tsepe
 * 
 * Trainer represents the school's teachers.
 */
public class Trainer {
    private String firstName;
    private String lastName;
    private String subject;

    
    
    public Trainer(String firstName,String lastName,String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;

        }
   
    
    
//  Getter και Setter for the Trainer's firstName   
    public String getFirstName(){
        return this.firstName;}
    
    public void setFirstName(String firstName){
        this.firstName = firstName;}
    
    
    
//  Getter και Setter for the Trainer's lasttName     
    public String getLastName(){
        return this.lastName;}
    public void setLastName(String lastName){
        this.lastName = lastName;}
    
    
    
//  Getter και Setter for the Trainer's subject     
    public String getSubject(){
        return this.subject;}
    public void setSubject(String subject){
        this.subject = subject;}
    

    
//  When we try to print a Trainer object, we return formatted the String we want to print. 
    @Override
    public String toString(){

        return Style.createFormat(new int[]{20,20,30},new String[]{this.firstName,this.lastName,this.subject});
    }
    
}
