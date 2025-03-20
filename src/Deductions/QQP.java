package Deductions;

public class QQP extends Deductions {
    private double interest = 0.108;
    @Override
    public double calculateTax(double grossSalary) {
        double salary = grossSalary;
        if(salary<= 71300)
            return salary*interest;
        return 7700.40;
    }
}