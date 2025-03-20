//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Timothy Lee Kwan Weng (40241060) & Noé Menacho (40306031)
//Custom Exception Class for cases where hourly wage is less than minimum wage.
//------------------------------------------------------------------------------------------------------------------
public class MinimumWageException extends Exception{
    //Attribute
    public static final double MINIMUM_WAGE = 15.75;

    //Constructors
    public MinimumWageException(){
        super("Error: Below Minimum Wage.");
    }

    public MinimumWageException(String s){
        super(s);
    }

    //Getter
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}