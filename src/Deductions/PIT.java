//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass PIT (Provincial Income Tax) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;
public class PIT extends Deductions{
    //percentages
    private final double percentage1 = 0.14;
    private final double percentage2 = 0.19;
    private final double percentage3 = 0.24;
    private final double percentage4 = 0.2575;
    //incomes
    private final int income1 = 18571;
    private final int income2 = 53225;
    private final int income3 = 106495;
    private final int income4 = 129590;

    /**
     * Calculates the provincial tax by breaking the gross Salary into different taxable brackets
     * @param grossSalary gross salary of the employee
     * @return returns the total deduction from the gross salary
     */
    @Override
    public double calculateTax(double grossSalary) {
        if(grossSalary<income1){
            return 0;
        }
        double deduction = 0;
        if(grossSalary>income4) {
            //check how much of the income is above income4
            double temp = grossSalary - income4;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage4;
            //set grossSalary to the rest of un-tax salary (income 4)
            grossSalary = income4;
        }
        if(grossSalary>income3){
            //check how much of the income is above income3
            double temp = grossSalary - income3;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage3;
            //set grossSalary to the rest of un-tax salary (income 3)
            grossSalary = income3;
        }
        if(grossSalary>income2){
            //check how much of the income is above income2
            double temp = grossSalary - income2;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage2;
            //set grossSalary to the rest of un-tax salary (income 1)
            grossSalary = income2;
        }
        if(grossSalary>=income1){
            //check how much of the income is above income1
            double temp = grossSalary - income1;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage1;
            //set grossSalary to the rest of un-tax salary (income 1)
            grossSalary = income1;
        }

        return deduction;
    }
}