
package database.classes;

/**
 *
 * @author tsepe
 * 
 * The RowForTable Class is a generic Class and represents a table's row that 
 * has 2 arguments.It can contains 2 different types of objects
 * 
 */
public class RowForTable<A, B> {
    A valueA;
    B valueB;
    
    
    /**
     * The method sets every value in the correct place.
     * @param valueA
     * @param valueB 
     */
    public void add(A valueA, B valueB){
        this.valueA = valueA;
        this.valueB = valueB;
    }
    
    
    /**
     * The method sets a value in the first row's variable
     * @param value 
     */
    public void setValueA(A value){
        this.valueA = value;}
    
    
    /**
     * The method gets a value from the first row's variable
     * @param value 
     */
    public A getValueA(){
        return this.valueA;}
    
    
    /**
     * The method sets a value in the second row's variable
     * @param value 
     */
    public void setValueB(B value){
        this.valueB = value;}
    
    
    /**
     * The method gets a value from the second row's variable
     * @param value 
     */
    public B getValueB(){
        return this.valueB;}
    
    
    /**
     * Returns true if variableA is equal to the given value.
     * Else returns false
     * @param valueA
     * @return boolean
     */
    public boolean aIsEqual(A valueA){
        if(this.getValueA() == valueA){
            return true;}
        else{
            return false;}}
    
    
    /**
     * Returns true if variableB is equal to the given value.
     * Else returns false
     * @param valueB
     * @return boolean
     */
    public boolean bIsEqual(B valueB){
        if(this.getValueB() == valueB){
            return true;}
        else{
            return false;}}
}
