
package console.utils;


import static console.utils.Style.addLines;
import database.classes.DataBase;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;



/**
 * In Input, are some utilities that help us now to write the same code again and again.
 * @author tsepe
 */
public class Input {
    
    // We create a scanner to take every input in the program
    public static Scanner input = new Scanner(System.in);
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    


    /**
     * We call giveYesOrNo() method to take an input from user, only between  1(yes) or 2 (no) 
     * @return true (yes) or false (no)
     */
    public static boolean  giveYesOrNo(){
        boolean isItYes = false;
        boolean inputIsValid = false;
        while(inputIsValid == false){
            String input = Input.input.nextLine();  //takes an input 
            switch(input){
                case "1":                       //if input is 1 return true
                    isItYes = true;
                    inputIsValid = true;
                    break;
                case "2":                       //if input is 2 return false
                    isItYes = false;
                    inputIsValid = true;
                    break;
                default:                        //if input is anything else than 1 or 2 we stay in while loop until user type the correct numbers
                    addLines(1);
                    System.out.println(Style.red("PLEASE CHOOSE BETWEEN 1 AND 2!"));
                    addLines(1);
            }
        }
        return isItYes;
    }
    
    
    
    
    /**
     * We call giveOnlyInteger() method to take an input from user that is only integer 
     * @return integer
     */
    public static int  giveOnlyInteger(){
        int result;
        while(true){
            try{
                String inp = input.nextLine();
                int number = Integer.parseInt(inp);             //the method tries to convert the number that user gave as a string, to int
                result=number;
                break;}
            catch(NumberFormatException e){                                     //if the user give a letter,and NumberFormatException shows up, program catches  
                System.out.println(Style.red("PLEASE GIVE AN INTEGER"));}       //the exception and tells to user to try again to give only an integer
        }
        return result;
    }
    
    
    
    /**
     * We call giveOnlyInteger() method to take an input from user that is only integer between minimum and maximum number
     * @param min for minimum number
     * @param max for maximum number
     * @return integer 
     */
    public static int  giveOnlyInteger(int min, int max){
        int number = giveOnlyInteger();
        while(number < min || number > max){
            System.out.println(Style.red("PLEASE GIVE THE RIGHT NUMBER:"));
            number = giveOnlyInteger();
            }
        return number;
    }
    
    
    
    /**
     * We call giveDate() method to take an input from user that is a date.
     * @return DateTime object
     */
    public static LocalDate giveADate(){
        DateTimeFormatter format =  DateTimeFormatter.ofPattern(data.daTiFormat);
        LocalDate result = LocalDate.now();
        boolean isNotValid = true;
        while(isNotValid){
            try{
                System.out.println("Please give a date (like 15/03/2000)");
                Scanner input = new Scanner(System.in);
                String in = input.nextLine();
                result = LocalDate.parse(in, format);
                isNotValid = false;
            }
            catch(java.time.DateTimeException e){
                
            }
        }
        return result;
    }
    
    
    /**
     * We call giveLaterDateThan method to take an input from user that is a date.
     * But first we check if the date that is given by the user is after the date
     * that is given in the method.
     * @return DateTime object
     */
    public static LocalDate giveLaterDateThan(LocalDate date){
        LocalDate givenDate = LocalDate.of(1989,9,19);
        boolean isNotValid = true;
        while(isNotValid){
            givenDate = giveADate();
            if(givenDate.isAfter(date)){
                isNotValid = false;
            }
            else{
                System.out.println(Style.red("PLEASE GIVE A DATETHAT IS AFTER THAN ")+ date.format(DateTimeFormatter.ofPattern(data.daTiFormat)) +Style.red(" !!!"));
            }
        }
        return givenDate;
    }
    
    
    /**
     * We call giveEarlierDateThan method to take an input from user that is a date.
     * But first we check if the date that is given by the user is before the date
     * that is given in the method.
     * @return DateTime object
     */
    public static LocalDate giveEarlierDateThan(LocalDate date){
        LocalDate givenDate = LocalDate.of(1989,9,19);
        boolean isNotValid = true;
        while(isNotValid){
            givenDate = giveADate();
            if(givenDate.isBefore(date)){
                isNotValid = false;
            }
            else{
                System.out.println(Style.red("PLEASE GIVE A DATE THAT IS BEFORE THAN ")+date.format(DateTimeFormatter.ofPattern(data.daTiFormat)) +Style.red(" !!!"));
            }
        }
        return givenDate;
    }
    
    /**
     * Takes a LocalDate from a user, and checks if the day of the week is from Monday to Friday. If the day is
     * Saturday or Sunday the program asks the user to give another LocalDate! 
     * @return LocalDate from Monday to Friday
     */
    public static LocalDate giveSubDate(){
        LocalDate givenDate = LocalDate.of(1989,9,19);
        boolean isNotValid = true;
        while(isNotValid){
            givenDate = giveADate();
            if(givenDate.getDayOfWeek()== DayOfWeek.SATURDAY || givenDate.getDayOfWeek() == DayOfWeek.SUNDAY){
                
                System.out.println(Style.red("PLEASE GIVE A DATE THAT IS BETWEEN MONDAY AND FRIDAY!!!"));
                
            }
            else{
                isNotValid = false;
            }
        }
        return givenDate;
    }
    
    
    
    
    /**
     * We call giveOnlyString() method to take an input from user that has only letters and spaces
     * @return 
     */
    public static String giveOnlyString(){
        
        String string=" ";
        boolean isValid = false;
        while ( isValid == false  ){
            string = input.nextLine();
            if( Pattern.matches("^[ A-Za-z]+$", string) == true ){              //checks if the input contains only letters
                isValid = true;}
            else{
                System.out.println(Style.red("PLEASE GIVE THE RIGHT TEXT (NO NUMBERS, ONLY ENGLISH)"));}
        }
        return string;
    }
    
    
    
    /**
     * We call giveOnlyDouble() method to take an input from user that is integer or decimal number
     * @return double
     */
    public static double giveOnlyDouble(){
        double result;
        while(true){
            try{
                String inp = input.nextLine();
                double number = Double.parseDouble(inp);
                result=number;
                break;}
            catch(NumberFormatException e){
                System.out.println(Style.red("PLEASE GIVE ONLY A NUMBER(INTEGER OR DECIMAL NUMBER)"));}
        }
        return result;
    }
    
   
    
    
    /**
     * pressToGoBack() asks the user to give whatever input, just to continue the program <p>
     * We use the method when we print some data, and we want to give some time to user to read them, until we continue the program.
     */
    public static void pressToGoBack(){
        System.out.println(Style.red("TYPE SOMETHING TO GO BACK"));
        String input = Input.input.nextLine();
    }
    

}


