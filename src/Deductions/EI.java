//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass EI (Employment Insurance) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
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