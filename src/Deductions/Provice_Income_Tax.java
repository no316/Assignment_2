package Deductions;

import Employee.Employee;

public class Provice_Income_Tax extends Deductions{
    private final double annualIncome1 = 0.14;
    private final double annualIncome2 = 0.19;
    private final double annualIncome3 = 0.24;
    private final double annualIncome4 = 0.2575;
    private final int income1 = 18571;
    private final int income2 = 53225;
    private final int income3 = 106495;
    private final int income4 = 129590;

    @Override
    public double calculateTax(Employee e) {
        double salary = e.getCalculatedAnnualWorkSalary();
        if(salary>income1 && salary<=income2)
            return salary*annualIncome1;
        if(salary>income2 && salary<=income3)
            return salary*annualIncome2;
        if(salary>income3 && salary<=income4)
            return salary*annualIncome3;
        if(salary>income4)
            return salary*annualIncome4;
        return 0;
    }
}
