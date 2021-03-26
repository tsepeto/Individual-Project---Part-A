
package database.classes;

import java.util.ArrayList;


/**
 *
 * @author tsepe
 * The DataConnectorTable class is a generic class. Represents a table that connects
 * two different Objects and it acts like a database table with two object types.
 * Actually is an ArrayList that contains RowForTables.
 */
public class DataConnectorTable<A, B> {
    
    
    ArrayList<RowForTable> rows = new ArrayList();                              //We create an an ArrayList that contains
                                                                                //RowForTables
    
    /**
    * 
    * The add method adds the data to the table.
    * For example if we add the students Nick and George in Java Course
    * the table will be like this.<p>
    * 
    *    +--------+---------+      <br>
    *    |  Course  | Student |   <br>
    *    +--------+---------+      <br>
    *    |   Java   |  Nick   |    <br>
    *    +--------+---------+      <br>
    *    |   Java    | George |   <br>
    *    +--------+---------+
    */
    public void add(A column1, B column2){
        RowForTable<A, B> row = new RowForTable();
        row.add(column1, column2);
        this.rows.add(row);
    }
        
    
    
    /**
     * The getBwhenA returns a list of data,of column B, if the value of
     * column A is the same as the value we gave.
     *  
     *@param A
     *@return ArrayList B
    */
    public ArrayList<B> getBWhenA(A value){
        ArrayList<B> result = new ArrayList<B>();
        for (int i = 0;i < this.rows.size(); i++){  //Looking for inside  Α (object1) list
            RowForTable<A, B> row = this.rows.get(i);
            if(row.aIsEqual(value)){                //If the value we gave is equals to A
            result.add(row.getValueB());}
        }                                           //saves the B value into result.
        return result;                              // Returns a list with the results.
    }
    
    
    
    /**
    * The getAwhenB returns a list of data,of column A, if the value of
    * column B is the same as the value we gave.
    *@param B
    *@return ArrayList A
    */
    public ArrayList<A> getAWhenB(B value){
        ArrayList<A> result = new ArrayList<A>();
        for( int i = 0;i < this.rows.size(); i++){  //Looking for inside  Α (object1) list
            RowForTable<A, B> row = this.rows.get(i);
            if( row.bIsEqual(value)){               //If the value we gave is equals to A
            result.add(row.getValueA());}           //saves the B value into result.
            }                                       
        return result;}                             //  Returns a list with the results.
    
    
    
    
    /**
     * Deletes all rows from the Table, if the value of the A column is equal to
     * valueA
     * @param valueA 
     */
    public void deleteRowsWhenAIs( A valueA){
        
        ArrayList<RowForTable> valueARows = new ArrayList();                    //Creates a temporary list
        
        for(RowForTable row : this.rows){                                       //Checks in every row in the table
            if(row.aIsEqual(valueA)){                                           //if row's A value is equal with valueA
                valueARows.add(row);                                            //then adds that row in valueARows (temporary list)
            }                                                                   //Now the program has all the rows with A valueA
        }
        for(RowForTable row : valueARows){                                      //Takes one by one all the rows it found
            this.rows.remove(row);                                              //and deletes it from the Table
        }
    }
    
    
    
    /**
     * Deletes all the rows from the Table, if the value of the B column is equal to
     * valueB
     * @param valueB 
     */
    public void deleteRowsWhenBIs( B valueB){
        ArrayList<RowForTable> valueBRows = new ArrayList();                    //Creates a temporary list
        
        for(RowForTable row : this.rows){                                       //Checks in every row in the table
            if(row.bIsEqual(valueB)){                                           //if row's B value is equal with valueB
                valueBRows.add(row);                                            //then adds that row in valueBRows (temporary list)
            }                                                                   //Now the program has all the rows with B valueB
        }
        for(RowForTable row : valueBRows){                                      //Takes one by one all the rows it found
            this.rows.remove(row);                                              //and deletes it from the Table
        }
        
    }
    
    
    
    /**
     * Deletes all the rows from the Table, if the value of the A column is equal to
     * valueA and the value of the B column is equal to ValueB
     * @param valueB 
     */
    public void deleteRowsWhenAAndBAre(A valueA, B valueB){
        ArrayList<RowForTable> valueABRows = new ArrayList();
        for( RowForTable row : this.rows){
            if(row.aIsEqual(valueA) && row.bIsEqual(valueB)){
                valueABRows.add(row);
            }
        }
        for(RowForTable row:valueABRows){
            this.rows.remove(row);
        }
    }
    
    
    
    /**
     *  
     * The method returns how many entries have been made, with the value of the
     * first column being the same as the value we gave it. 
     * @param A
     * @return the number o B
     */
    public int howManyBWhenA(A value){       
        return getBWhenA(value).size();}
    
    
    
    /**
     *  The method returns how many entries have been made, with the value of the
     * second column being the same as the value we gave it.
     * @param B
     * @return the number o A
     */
    public int howManyAWhenB(B value){       
        return getAWhenB(value).size();}
    
    
    
    /**
     * 
     * Returns how many rows has the table 
     * @return integer
     */
    public int size(){
        return this.rows.size();}
    
    
    /**
     * Returns the row that is in the same position as the value we give to the 
     * method
     * @param i is the row position in the table
     * @return RowForTable
     */
    public RowForTable get(int i){
        return this.rows.get(i);}
}


