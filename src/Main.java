//------------------------------------------------------------------------------------------------------------------
//COMP249-Winter2025-Assg2
//Written by: Timothy Lee Kwan Weng (40241060) & Noé Menacho (40306031)
//Driver implements main() that prints a welcome and closing message and initiates file processing.
//------------------------------------------------------------------------------------------------------------------
public class Main {
    public static void main(String[] args)  {
        System.out.println("Hi welcome hooman! Greetings from Timothy Lee (40241060) and Noé Menacho (40306031)!!"); //welcome message
        System.out.println(">Now initiating file operations..."); //trivial message
        FileOperations.writeToFile(FileOperations.readFromFile("payroll.txt"),"payrollReport.txt"); //file operations
        System.out.println("Report successfully generated. Thank you for using iDroid Solutions! Program will now terminate!"); //closing message
    }
}