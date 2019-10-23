import java.util.Hashtable;

public class HashTest {

    private static String dataType,alpha,debug = "";

    public static void main(String[] args) {

        double a = 2;
        double pwr = 2;
        System.out.println(Math.pow(a,pwr)%2.5);
        System.exit(0);

        if (args.length < 2) {
            help();
            System.exit(0);
        }
        dataType = args[0];
        alpha = args[1];
        if (args.length == 3) {
            debug = args[2];
        }
        PrimeCheck prime = new PrimeCheck(95500,96000);
        int size = prime.getPrime();
        HashTable tableL = new HashTable(size, HashTable.HashType.LINEAR);
        HashTable tableD = new HashTable(size, HashTable.HashType.DOUBLE);

    }

    private static void help() {
        System.out.println("---Incorrect arguments ---");
        System.out.println("Usage: java HashTest <input type> <load factor> [<debug level>]");
        System.out.println("Input type: 1, 2, 3");
        System.out.println("Load Factor: 0 < x < 1");
        System.out.println("[Debug level: 0 (primary summary) or 1 (summary with hashtable, # of duplicates/probes into a files]");
    }
}