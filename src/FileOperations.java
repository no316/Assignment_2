//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Timothy Lee Kwan Weng (40241060)
//This class handles all file operations and formatting.
//------------------------------------------------------------------------------------------------------------------
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import Employee.*;
import Deductions.*;

public class FileOperations {
    static Employee[] employees = null; //declare array to store data from payroll.txt
    static int count = 0; //counter for the number of lines in payroll.txt
    static int err_count = 0; //counter for the number of lines skipped and written to payrollError.txt

    //Method writeToFile() takes the employee array output from readFromFile(), processes it, and outputs payrollReport.txt
    public static void writeToFile(Employee[] employees, String fn) { //will take "payrollReport.txt" as filename in Driver
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fn))) { //modern approach of trying-with-resources
            //Trivial descriptive lines
            System.out.println(">" + employees.length + " lines read from file\n" +
                    ">" + err_count + " lines written to error file\n" +
                    ">Calculating deductions...\n" +
                    ">Writing report file...");

            //Header formatting for output file payrollReport.txt
            pw.printf("%49s%n", "iDroid Solutions");
            pw.println("-".repeat(82));
            pw.printf("%-10s %-12s %-12s %-15s %-15s %-13s%n",
                    "Employee", "First name", "Last Name", "Gross salary", "Deductions", "Net salary");
            pw.printf("%-10s%n", "Number");
            pw.println("-".repeat(82));

            for (Employee element : employees) {
                if (element == null || element.getHours() == 0 || element.getWage() == 0) continue; //filter
                /*Detailed Explanation for "element.getHours() == 0 || element.getWage() == 0":
                 *In payroll.txt, the last line is: 96610 EMILE O'HARE 25,0 26.36
                 *This line should not make it to payrollReport.txt because "25,0" is an input mismatch, and yet it does
                 *with only "element == null" as condition. An InputMismatchException is indeed thrown and caught.
                 *However by that time, the Employee object is already partially filled. And since there is no next line
                 *in payroll.txt to overwrite it, the object makes it into payrollReport.txt.
                 *These two additional filters/conditions are set in place to account for such edge cases.*/

                //Tax & Net Salary Calculations
                double ei = new EI().calculateTax(element.getGrossSalary());
                double fit = new FIT().calculateTax(element.getGrossSalary());
                double pit = new PIT().calculateTax(element.getGrossSalary());
                double qpip = new QPIP().calculateTax(element.getGrossSalary());
                double qqp = new QQP().calculateTax(element.getGrossSalary());
                double deductions = ei + fit + pit + qpip + qqp;
                double net = element.getGrossSalary() - deductions;

                //Printing cleaned data with proper formatting
                pw.printf("%-10d %-12s %-12s $%-,12.2f   $%-,12.2f   $%-,12.2f%n",
                        element.getEmployeeNum(),
                        element.getFirstName(),
                        element.getLastName(),
                        element.getGrossSalary(),
                        deductions,
                        net);
            }
            pw.println("-".repeat(82));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.exit(0); //end program if file is not found
        }
    }

    //Method readFromFile() first counts the number of lines in payroll.txt, then reads the text file line by line and
    //cleans the data. Valid data is written onto Employee objects. Invalid data is written onto payrollError.txt
    public static Employee[] readFromFile(String fn) { //will take "payroll.txt" as filename in Driver
        //Counting number of lines in payroll.txt to initialize array employees[]
        try (Scanner sc = new Scanner(new FileInputStream(fn))) { //modern approach of trying-with-resources
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.exit(0);
        }

        try (Scanner sc = new Scanner(new FileInputStream(fn));
             PrintWriter err = new PrintWriter(new FileOutputStream("payrollError.txt"))) { //modern approach of trying-with-resources
            employees = new Employee[count];
            count = 0;

            //Trivial descriptive lines
            System.out.print("""
                    >Opening file...
                    >Reading file...
                    """);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try (Scanner in = new Scanner(line)) {
                    //Setting Employee object attributes
                    employees[count] = new Employee();
                    employees[count].setEmployeeNum(in.nextLong());
                    employees[count].setFirstName(in.next());
                    employees[count].setLastName(in.next());
                    employees[count].setHours(in.nextDouble());
                    double wage = in.nextDouble();
                    if (wage < 15.75) {
                        throw new MinimumWageException();
                    }
                    employees[count].setWage(wage);
                    employees[count++].calculateGrossSalary();//increment array index after successfully filling object
                    /*Detailed Explanation:
                     *If this above line of code is never reached, that means an exception was thrown and caught, and so
                     *the index is never incremented. This means the next line read from payroll.txt will overwrite the
                     *either empty or partially filled Employee object.*/
                } catch (InputMismatchException |
                         MinimumWageException e) { //catching either wrong input type or below minimum wage
                    if (err_count == 0) System.out.println(">Error line(s) found in file"); //trivial descriptive line
                    err.println(line); //write invalid line onto payrollError.txt
                    err_count++; //increment counter for number of lines written to payrollError.txt
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.exit(0);
        }
        return employees; //return array of Employee objects
    }
}