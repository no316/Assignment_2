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