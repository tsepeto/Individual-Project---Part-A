/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sCOOL;



import console.views.menuviews.FirstWindow;
import database.classes.DataBase;




/**
 *
 * @author tsepe
 */


public class SCool {
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     
        
//        TestDataCreator.createData();
        DataBase data = DataBase.getInstance();                                 //The program creates the singleton class DataBase.
        FirstWindow.showMenu();
          
    }
    
}
