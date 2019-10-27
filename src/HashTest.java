import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HashTest {

    private static String dataType, debug = "";
    private static int insert, randNum = 0;
    private static double alpha;
    private static Random rand = new Random();
    private static long longNum;

    public static void main(String[] args) {

        if (args.length < 2) {
            help();
            System.exit(0);
        }
        dataType = args[0];
        alpha = Double.parseDouble(args[1]);
        if (args.length == 3) {
            debug = args[2];
        }
        PrimeCheck prime = new PrimeCheck(95500, 96000);
        //int size = prime.getPrime();
        int size = 95791;
        HashTable linearTable = new HashTable(size, HashTable.HashType.LINEAR);
        HashTable doubleTable = new HashTable(size, HashTable.HashType.DOUBLE);
        // Should I do this with my while loop.  I feel that only do it once is better then repeated //
            if (dataType.equals("1")) {
                //Integer object using Random integer is created using nextInt()
                while(linearTable.tableRatio() < alpha) {
                    randNum = rand.nextInt();
                    linearTable.add(randNum);
                    doubleTable.add(randNum);
                }
            } else if (dataType.equals("1")) {
                //Long Object generated by System.currentTimeMillis()
                while(linearTable.tableRatio() < alpha) {
                    longNum = System.currentTimeMillis();
                    linearTable.add(longNum);
                    doubleTable.add(longNum);
                }
            } else if (dataType.equals("3")){
                //Contains a word from the list /home/JHyeh/cs321/lab/lab3/files
                try {
                    Scanner scanner = new Scanner(new File("word-list"));
                    while (scanner.hasNext() && linearTable.tableRatio() < alpha){
                        String word = scanner.nextLine();
                        linearTable.add(word);
                        doubleTable.add(word);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Incorrect Input Type");
                help();
                System.exit(0);
            }
            // print statement here with method to grab table values
        linearTable.dump(debug,dataType,alpha);


    }

    private static void help() {
        System.out.println("---Incorrect arguments ---");
        System.out.println("Usage: java HashTest <input type> <load factor> [<debug level>]");
        System.out.println("Input type: 1, 2, 3");
        System.out.println("Load Factor: 0 < x < 1");
        System.out.println("[Debug level: 0 (primary summary) or 1 (summary with hashtable, # of duplicates/probes into a files]");
    }
}