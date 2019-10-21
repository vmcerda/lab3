import java.util.Hashtable;

public class HashTest {

    private static int arg2;
    private static String dataType;
    private static int debug;

    public static void main(String[] args) {
        System.out.println(args.length);
        if (args.length < 2) {
            help();
            System.exit(0);
        }
        if (args.length == 3) {
            debug = Integer.parseInt(args[0]);
        }
        if (args[0] == "1") {
            dataType = "Integer";
        }
        if (args[0] == "2") {
            dataType = "Long";
        }
        if (args[0] == "3") {
            dataType = "word-list";
        }



    }

    private static void help() {
        System.out.println("---Incorrect arguments ---");
        System.out.println("Usage: java HashTest <input type> <load factor> [<debug level>]");
        System.out.println("Input type: 1, 2, 3");
        System.out.println("Load Factor: 0 < x < 1");
        System.out.println("[Debug level: 0 (primary summary) or 1 (summary with hashtable, # of duplicates/probes into a files]");
    }
}