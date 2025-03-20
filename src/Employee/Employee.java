package Employee;

public class Employee {
    //Attributes
    private long employeeNum;
    private String firstName;
    private String lastName;
    private double hours;
    private double wage;
    private double grossSalary;

    //Constructor
    public Employee(){}

    //Getters
    public long getEmployeeNum() {
        return employeeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHours() {
        return hours;
    }

    public double getWage() {
        return wage;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    //Setters
    public void setEmployeeNum(long employeeNum) {
        this.employeeNum = employeeNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    //Calculate Gross Salary
    public void calculateGrossSalary(){
        this.grossSalary = this.hours * this.wage * 52;
    }
}