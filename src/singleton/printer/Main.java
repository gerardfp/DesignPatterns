package singleton.printer;

class PrinterSpooler {
    private static PrinterSpooler instance;
    private int jobCount;

    private PrinterSpooler() {
        // private constructor to prevent outside instantiation
        jobCount = 0;
    }

    public static synchronized PrinterSpooler getInstance() {
        if (instance == null) {
            instance = new PrinterSpooler();
        }
        return instance;
    }

    // The synchronized keyword ensures that only one thread can access this method at a time, preventing conflicts when managing the printing queue.
    public synchronized void printJob(String job) {
        System.out.println("Printing job " + (++jobCount) + ": " + job);
    }
}
public class Main {
    public static void main(String[] args) {
        PrinterSpooler spooler1 = PrinterSpooler.getInstance();
        spooler1.printJob("Document1");

        PrinterSpooler spooler2 = PrinterSpooler.getInstance();
        spooler2.printJob("Document2");
    }
}
