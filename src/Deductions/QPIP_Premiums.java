package Deductions;
import Employee.Employee;

public class QPIP_Premiums extends Deductions {
    private final double interest = 0.0494;
    @Override
    public double calculateTax(Employee e) {
        double salary = e.getCalculatedAnnualWorkSalary();
        if(salary<= 98000)
            return salary*interest;
        return 494.12;
    }
}
