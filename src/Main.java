public class Main {
    public static void main(String[] args)  {
        FileOperations.writeToFile(FileOperations.readFromFile("payroll.txt"),"payrollReport.txt");
    }
}