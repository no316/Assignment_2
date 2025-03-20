//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass QPIP (Quebec Parental Insurance Plan) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
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