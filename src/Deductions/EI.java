package Deductions;

public class EI extends Deductions{
    private final double premiumRate = 0.0164;

    @Override
    public double calculateTax(double grossSalary) {
        double salary = grossSalary;
        if(salary <=65700)
            return premiumRate * grossSalary;
        return 1077.48;
    }
}