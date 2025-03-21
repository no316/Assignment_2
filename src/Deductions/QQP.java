//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass QQP (Quebec Pension Plan) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;

public class QQP extends Deductions {
    //interest
    private final double INTEREST = 0.108;

    /**
     * Calculates the QQP ffor a given gross salary
     *
     * @param grossSalary gross salary of the employee
     * @return returns calculated QQP or 7700.40 if gross salary is more than 71300
     */
    @Override
    public double calculateTax(double grossSalary) {
        //check is the salary is smaller
        if (grossSalary <= 71300)
            return grossSalary * INTEREST;
        return 7700.40;
    }
}