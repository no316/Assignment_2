public class Main {
    public static void main(String[] args)  {
        System.out.println("Hi welcome hooman! Greetings from Timothy Lee (40241060) and Noé Menacho (40306031)!!"); //welcome message
        System.out.println("Now starting file cleaning & processing...");
        FileOperations.writeToFile(FileOperations.readFromFile("payroll.txt"),"payrollReport.txt");
        System.out.println("Report successfully generated. Thank you for using iDroid Solution! Ciao!"); //closing message
    }
}