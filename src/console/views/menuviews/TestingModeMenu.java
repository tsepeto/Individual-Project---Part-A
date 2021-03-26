
package console.views.menuviews;

import console.views.searchviews.SearchInTrainersView;
import console.views.searchviews.SearchInStudentsView;
import console.views.searchviews.SearchInCoursesView;
import console.views.searchviews.SearchInAssignmentsView;
import console.utils.Style;
import console.utils.Input;

/**
 *
 * @author tsepe
 * 
 * The TestingModeMenu is the first View that shows up if the user chooses to run the
 * program with random data.
 * Here the user chooses what he want to search.
 */
public class TestingModeMenu {
    
    
    /**
     * The show() method shows the user's choice procedure about the next move. 
     */
    public static void showMenu(){
        while(true){
            int result;
            Style.addLines(1);
            System.out.println(Style.yellow("SEARCH IN DATABASE"));
            Style.addUnderline();
            System.out.println(Style.yellow("1")+" -  STUDENTS");
            System.out.println(Style.yellow("2")+" -  TRAINERS");
            System.out.println(Style.yellow("3")+" -  COURSES");
            System.out.println(Style.yellow("4")+" -  ASSIGNMENTS");
            System.out.println(Style.yellow("5")+" -  GO BACK");
            Style.addUnderline();
            Style.addLines(1);

            result = Input.giveOnlyInteger(1,5);

            switch(result){
                case 1:
                    SearchInStudentsView.show();
                    break;

                case 2:
                    SearchInTrainersView.show();
                    break;

                case 3:
                    SearchInCoursesView.show();
                    break;

                case 4:
                    SearchInAssignmentsView.show();
                    break;

                case 5:
                    MainMenu.showMenu();
                    break;

            }
        }
    }
}