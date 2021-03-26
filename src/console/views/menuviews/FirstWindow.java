
package console.views.menuviews;


import console.utils.Style;
import console.utils.Input;
import database.classes.TestDataCreator;

/**
 *
 * @author tsepe
 * 
 * Is the first view that shows up in program.
 * Here the user chooses if he want to use the program in testing mode with random
 * data, or to use it with empty database.
 */
public class FirstWindow {
    
    
         
    /**
    *  The show() method welcomes the user and calls userChoice() method to let 
    * the user choose the next step
    */
    public static void showMenu(){
    
        System.out.println(Style.green("WELCOME TO sCOOL!!!"));
        System.out.println(Style.green("sCOOL IS THE APPLICATION THAT WILL MAKE THE SCHOOL MANAGMENT, BE A FUN"));
        Style.addLines(1);
        userChoice();                                                           //calls the choice procedure.
        
    }
    
    
    
    /**
     * The method let the user choose about the next move.<p>
     * Let him choose among:<p>
     * -Testing  mode with random data<p>
     * -Use the program with empty database<p>
     * -Exit the program<p>
     */
    private static void userChoice(){
        int correctInput;
        
        
        System.out.println(Style.magenta("WOULD YOU LIKE TO RUN THE PROGRAM IN TESTING MOD WITH RANDOM DATA OR"));
        System.out.println(Style.magenta("WOULD YOU LIKE TO RUN THE PROGRAM ONLY WITH YOUR OWN DATA?"));
        Style.addUnderline();
        Style.addLines(1);
        
        while(true){
       
            System.out.println(Style.yellow("PLEASE WRITE THE RIGHT NUMBER"));
            Style.addUnderline();
            System.out.println(Style.yellow("1")+" - CONTINUE IN TESTING MODE");
            System.out.println(Style.yellow("2")+" - LET'S START USE IT FOR MY SCHOOL");
            System.out.println(Style.yellow("3")+" - EXIT");
            Style.addUnderline();
            correctInput = Input.giveOnlyInteger(1,3);                          //Asks the user to choose an integer among the options.
            switch(correctInput){
            
                case 1:                                                         //After the user's choice the method calls the right View.
//                    TestingModeMenu.showMenu();
                    Style.addLines(2);
                    System.out.println(Style.red("TESTING MODE!!! YOU CAN TRY THE PROGRAM WITH RANDOM DATA"));
                    TestDataCreator.createData();
                    MainMenu.showMenu();
                    Style.addLines(2);
                    break;
                    
                case 2:
                    MainMenu.showMenu();
                    Style.addLines(2);
                    break;
                    
                case 3:
                    OtherViews.closeProgram();
                    break;
                    
                default:
                    System.out.println("A problem has occurred in FirstWindow file, Line 78");;
            }
            
        
        }
    
    }
    

    
}
