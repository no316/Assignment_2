package Deductions;

public class QPIP extends Deductions {
    private final double interest = 0.0494;
    @Override
    public double calculateTax(double grossSalary) {
        double salary = grossSalary;
        if(salary<= 98000)
            return salary*interest;
        return 494.12;
    }
}