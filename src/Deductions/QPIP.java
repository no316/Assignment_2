//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass QPIP (Quebec Parental Insurance Plan) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;

public class QPIP extends Deductions {
    //interest for QPIP
    private final double INTEREST = 0.0494;

    /**
     * Method that calculates the QPIP of a given gross salary
     *
     * @param grossSalary gross salary of an employee
     * @return returns the total calculated amount or 494.12 if the gross salary is more than 9800
     */
    @Override
    public double calculateTax(double grossSalary) {
        //check is the salary is smaller
        if (grossSalary <= 98000)
            return grossSalary * INTEREST;
        return 494.12;
    }
}