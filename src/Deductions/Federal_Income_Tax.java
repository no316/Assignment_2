package Deductions;

import Employee.Employee;

public class Federal_Income_Tax extends Deductions{
    private double percentage1 = 0.15;
    private double percentage2 = 0.205;
    private double percentage3 = 0.26;
    private double percentage4 = 0.29;
    private double percentage5 = 0.33;

    private int income1 = 16129;
    private int income2 = 57375;
    private int income3 = 114750;
    private int income4 = 177882;
    private int income5 = 253414;
    @Override
    public double calculateTax(Employee e) {
        double salary = e.getCalculatedAnnualWorkSalary();
        if(salary<income1)
            return 0;
        if(salary>=income1 && salary<=income2)
            return salary*percentage1;
        if(salary>income2 && salary<=income3)
            return salary*percentage2;
        if(salary>income3 && salary<=income4)
            return salary*percentage3;
        if(salary>income4 && salary<=income5)
            return salary*percentage4;
        if(salary>income5)
            return salary*percentage5;
        return 0;
    }
}
