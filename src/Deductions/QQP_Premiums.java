package Deductions;

import Employee.Employee;

public class QQP_Premiums extends Deductions {
    private double interest = 0.108;
    @Override
    public double calculateTax(Employee e) {
        double salary = e.getCalculatedAnnualWorkSalary();
        if(salary<= 71300)
            return salary*interest;
        return 7700.40;
    }
}
