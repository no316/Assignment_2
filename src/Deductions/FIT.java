//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass FIT (Federal Income Tax) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;

public class FIT extends Deductions {
    //percentages
    private final double BRACKET1 = 0.15;
    private final double BRACKET2 = 0.205;
    private final double BRACKET3 = 0.26;
    private final double BRACKET4 = 0.29;
    private final double BRACKET5 = 0.33;
    //incomes
    private final int INCOME1 = 16129;
    private final int INCOME2 = 57375;
    private final int INCOME3 = 114750;
    private final int INCOME4 = 177882;
    private final int INCOME5 = 253414;

    /**
     * Method that calculates the Federal tax breaking down the grossSalary into taxable brackets
     *
     * @param grossSalary gross salary of employee
     * @return Returns the total deduction from salary
     */
    @Override
    public double calculateTax(double grossSalary) {
        if (grossSalary < INCOME1) {
            return 0;
        }
        double deduction = 0;
        //check if salary is bigger than income5
        if (grossSalary > INCOME5) {
            //check how much of the income is above income5
            double temp = grossSalary - INCOME5;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET5;
            //set grossSalary to the rest of un-tax salary (income 5)
            grossSalary = INCOME5;
        }
        if (grossSalary > INCOME4 && grossSalary <= INCOME5) {
            //check how much of the income is above income4
            double temp = grossSalary - INCOME4;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET4;
            //set grossSalary to the rest of un-tax salary (income 4)
            grossSalary = INCOME4;
        }
        if (grossSalary > INCOME3 && grossSalary <= INCOME4) {
            //check how much of the income is above income3
            double temp = grossSalary - INCOME3;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET3;
            //set grossSalary to the rest of un-tax salary (income 3)
            grossSalary = INCOME3;
        }
        if (grossSalary > INCOME2 && grossSalary <= INCOME3) {
            //check how much of the income is above income2
            double temp = grossSalary - INCOME2;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET2;
            //set grossSalary to the rest of un-tax salary (income 1)
            grossSalary = INCOME2;
        }
        if (grossSalary >= INCOME1 && grossSalary <= INCOME2) {
            //check how much of the income is above income1
            double temp = grossSalary - INCOME1;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp * BRACKET1;
            //set grossSalary to the rest of un-tax salary (income 1)
        }
        return deduction;

    }
}