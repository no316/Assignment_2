//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Noé Menacho (40306031) & Timothy Lee Kwan Weng (40241060)
//Implementation of Subclass FIT (Federal Income Tax) that extends Deductions.
//------------------------------------------------------------------------------------------------------------------
package Deductions;
public class FIT extends Deductions{
    //percentages
    private double percentage1 = 0.15;
    private double percentage2 = 0.205;
    private double percentage3 = 0.26;
    private double percentage4 = 0.29;
    private double percentage5 = 0.33;
    //incomes
    private int income1 = 16129;
    private int income2 = 57375;
    private int income3 = 114750;
    private int income4 = 177882;
    private int income5 = 253414;

    /**
     * Method that calculates the Federal tax breaking down the grossSalary into taxable brackets
     * @param grossSalary gross salary of employee
     * @return Returns the total deduction from salary
     */
    @Override
    public double calculateTax(double grossSalary) {
        if(grossSalary<income1){
            return 0;
        }
        double deduction = 0;
        //check if salary is bigger than income5
        if(grossSalary>income5) {
            //check how much of the income is above income5
            double temp = grossSalary - income5;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage5;
            //set grossSalary to the rest of un-tax salary (income 5)
            grossSalary = income5;
        }
        if(grossSalary>income4 && grossSalary <=income5){
            //check how much of the income is above income4
            double temp = grossSalary - income4;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage4;
            //set grossSalary to the rest of un-tax salary (income 4)
            grossSalary = income4;
        }
        if(grossSalary>income3 && grossSalary<=income4){
            //check how much of the income is above income3
            double temp = grossSalary - income3;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage3;
            //set grossSalary to the rest of un-tax salary (income 3)
            grossSalary = income3;
        }
        if(grossSalary>income2 && grossSalary<=income3){
            //check how much of the income is above income2
            double temp = grossSalary - income2;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage2;
            //set grossSalary to the rest of un-tax salary (income 1)
            grossSalary = income2;
        }
        if(grossSalary>=income1 && grossSalary<=income2){
            //check how much of the income is above income1
            double temp = grossSalary - income1;
            //adds to deduction the amount of deduction it got for that salary
            deduction += temp*percentage1;
            //set grossSalary to the rest of un-tax salary (income 1)
        }
        return deduction;

    }
}