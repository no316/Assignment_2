import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import Employee.*;
import Deductions.*;

public class FileOperations {
    static Employee[] employees = null;
    static int count = 0;
    static int err_count = 0;

    public static void writeToFile(Employee[] employees, String fn) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fn))) {
            pw.println(">" + employees.length + " lines read from file payroll\n" +
                    ">" + err_count + " lines written to error file\n" +
                    ">Calculating deductions\n" +
                    ">Writing report file");

            pw.printf("%49s%n", "iDroid Solutions");
            pw.println("-".repeat(82));
            pw.printf("%-10s %-12s %-12s %-15s %-15s %-13s%n",
                    "Employee", "First name", "Last Name", "Gross salary", "Deductions", "Net salary");
            pw.printf("%-10s%n", "Number");
            pw.println("-".repeat(82));

            for(Employee element : employees){
                if(element == null || element.getHours() == 0 || element.getWage() == 0) continue;

                double ei = new EI().calculateTax(element.getGrossSalary());
                double fit = new FIT().calculateTax(element.getGrossSalary());
                double pit = new PIT().calculateTax(element.getGrossSalary());
                double qpip = new QPIP().calculateTax(element.getGrossSalary());
                double qqp = new QQP().calculateTax(element.getGrossSalary());
                double deductions = ei + fit + pit + qpip + qqp;
                double net = element.getGrossSalary() - deductions;

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
            System.exit(0);
        }
    }

    public static Employee[] readFromFile(String fn) {
        try (Scanner sc = new Scanner(new FileInputStream(fn))) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.exit(0);
        }

        try (Scanner sc = new Scanner(new FileInputStream(fn));
             PrintWriter err = new PrintWriter(new FileOutputStream("payrollError.txt"))) {
            employees = new Employee[count];
            count = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try (Scanner in = new Scanner(line)) {
                    employees[count] = new Employee();
                    employees[count].setEmployeeNum(in.nextLong());
                    employees[count].setFirstName(in.next());
                    employees[count].setLastName(in.next());
                    employees[count].setHours(in.nextDouble());
                    double wage = in.nextDouble();
                    if(wage < 15.75){
                        throw new MinimumWageException();
                    }
                    employees[count].setWage(wage);
                    employees[count++].calculateGrossSalary();
                } catch(InputMismatchException | MinimumWageException e){
                    err.println(line);
                    err_count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.exit(0);
        }
        return employees;
    }
}