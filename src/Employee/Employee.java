package Employee;

public class Employee {
    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double wage;
    private double calculatedAnnualWorkSalary;
    private static Employee[] employees;

    private void internalCalculateAnnualWorkSalary() {
        calculatedAnnualWorkSalary = hoursWorked * wage * 52;

    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getWage() {
        return wage;
    }

    public double getCalculatedAnnualWorkSalary() {
        return calculatedAnnualWorkSalary;
    }

    public static Employee[] getEmployees() {
        return employees;
    }
}
