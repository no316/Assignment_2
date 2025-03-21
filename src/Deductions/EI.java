//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass EI (Employment Insurance) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;
public class EI extends Deductions {
    //for every 100$, 1.64$ will be pay
    private final double PREMIUM = 1.64;

    /**
     * Calculates the EI of a given salary
     *
     * @param grossSalary
     * @return Returns the calculated amount of money, 1.64$ per 100$ or 1077.48 if salary is greater
     * than 65700
     */
    @Override
    public double calculateTax(double grossSalary) {
        //check if salary is acceptable to perform calculation or return max amount
        if (grossSalary <= 65700) {
            //check how many 100$ there are
            int every100Dollars = (int) (grossSalary / 100);
            return every100Dollars * PREMIUM;
        }
        return 1077.48;
    }
}