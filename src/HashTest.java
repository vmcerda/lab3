package src;

import java.lang.*;

import static java.lang.System.exit;

public class HashTest {

    public static void main(String[] args){
        if(args.length < 2){
            help();
            exit(0);
        }


    }

    private static void help() {
        System.out.println("---Incorrect arguments ---");
        System.out.println("Usage: java HashTest <input type> <load factor> [<debug level>]");
        System.out.println("Input type: 1, 2, 3");
        System.out.println("Load Factor: 0 < x < 1");
        System.out.println("Debug level: 0 (primary summary) or 1 (summary with hashtable, # of duplicates/probes into a files");
    }
}
