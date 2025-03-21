//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass PIT (Provincial Income Tax) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;
public class PIT extends Deductions {
    //percentages
    private final double BRACKET1 = 0.14;
    private final double BRACKET2 = 0.19;
    private final double BRACKET3 = 0.24;
    private final double BRACKET4 = 0.2575;
    //incomes
    private final int INCOME1 = 18571;
    private final int INCOME2 = 53225;
    private final int INCOME3 = 106495;
    private final int INCOME4 = 129590;

    /**
     * Calculates the provincial tax by breaking the gross Salary into different taxable brackets
     *
     * @param grossSalary gross salary of the employee
     * @return returns the total deduction from the gross salary
     */
    @Override
    public double calculateTax(double grossSalary) {
        if (grossSalary < INCOME1) {
            return 0;
        }
        double deduction = 0;
        if (grossSalary > INCOME4) {
            //check how much of the income is above income4
            double temp = grossSalary - INCOME4;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET4;
            //set grossSalary to the rest of un-tax salary (income 4)
            grossSalary = INCOME4;
        }
        if (grossSalary > INCOME3) {
            //check how much of the income is above income3
            double temp = grossSalary - INCOME3;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET3;
            //set grossSalary to the rest of un-tax salary (income 3)
            grossSalary = INCOME3;
        }
        if (grossSalary > INCOME2) {
            //check how much of the income is above income2
            double temp = grossSalary - INCOME2;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET2;
            //set grossSalary to the rest of un-tax salary (income 1)
            grossSalary = INCOME2;
        }
        if (grossSalary >= INCOME1) {
            //check how much of the income is above income1
            double temp = grossSalary - INCOME1;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET1;
            //set grossSalary to the rest of un-tax salary (income 1)
            grossSalary = INCOME1;
        }

        return deduction;
    }
}