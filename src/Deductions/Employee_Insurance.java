package Deductions;
import Employee.Employee;

public class Employee_Insurance extends Deductions{
    private final double premiumRate = 0.0164;
    @Override
    public double calculateTax(Employee employee) {
        double salary = employee.getCalculatedAnnualWorkSalary();
        if(salary <=65700)
            return premiumRate * employee.getCalculatedAnnualWorkSalary();
        return 1077.48;
    }
}
