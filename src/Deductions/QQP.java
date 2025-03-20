//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass QQP (Quebec Pension Plan) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
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