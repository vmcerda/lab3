import java.util.ArrayList;
import java.util.Random;

public class HashTable<T>{

    private double alpha;
    private int debugSet;
    private int dataType;
    private Random rand = new Random(0);

    public HashTable(String dataType,String alpha, String debug){
        /* Next step is to create table size using prime values */
        this.alpha = Double.parseDouble(alpha);
        createPrimeTableSize(95500,96000);
        setDataType(dataType);
        ArrayList<T> table = new ArrayList();
        if(!debug.isEmpty()){
            debugSet = Integer.parseInt(debug);
        }
    }

    private void createPrimeTableSize(int minSize, int maxSize) {

    }

    // Not sure about this....may not need
    private void setDataType(String dataType) { // remove void and add return values for each dataType
        if(dataType == "1"){
            //Call method to setup Integer Objects with a random int value generated with nextInt() in java.utili.Random
            // Key is the Integer object inside???
        }else if(dataType == "2"){
            //Call method to setup Long Objects generated by method System.currentTimeMillis()
            //Key for HashObject is Long object inside????
        }else{
            // read from a file located in /home/jhyeh/cs321/labs/lab3/files
            //each HashObject contains a word form the file
            //key is the word from each object
        }
    }

    //create method with two args for hascode evaluation.  Handles both primary and secondary hash

}
