import javax.sound.midi.Soundbank;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class HashTable<T> {

    private final int tableSize;
    private HashObject<T>[] table;
    private HashType type;
    private int size = 0;
    private int numDuplicates = 0;
    private int numProbes =0;

    public enum HashType {
        LINEAR(),
        DOUBLE()
    }

    public HashTable(int tableSize, HashType hashType) {

        table = new HashObject[tableSize];
        type = hashType;
        this.tableSize = tableSize;
    }

    private int getIncrement(T obj) { // handling both difference between linear and double hashing
        if (type.equals(HashType.LINEAR)) {
            return 1;
        }
        //double hashing
        int secondary = obj.hashCode() % (table.length - 2);
        if (secondary < 0) {
            secondary += table.length - 2;
        }
        return secondary + 1;
    }

    private int primaryHash(T obj){
        int initialPosition = obj.hashCode() % table.length;
        if(initialPosition < 0){  // If initial position is negative add table length to position;
            initialPosition += table.length;
        }
        return initialPosition;
    }

    public void add(T obj) {
        HashObject<T> newObj = new HashObject<>(obj);
        int initPos = primaryHash(obj);
        int increment = getIncrement(obj);
        for(int i = 0; i < table.length;i++){
            BigInteger b1,b2,b3;
            b1 = BigInteger.valueOf(initPos);
            b2 = BigInteger.valueOf(i * increment);
            b3 = BigInteger.valueOf(table.length);
            b1 = b1.add(b2);
            int position = b1.mod(b3).intValue();
            //int position = (initPos + i*increment) % table.length;
            if(table[position] == null){
                table[position] = newObj;
                size++;
                table[position].incProbeCount();
                break;
            }else if(newObj.equals(table[position])){
                table[position].incDuplicateCount();
                table[position].incProbeCount();
                break;
            }
            //newObj.incProbeCount();
        }
    }

    public float tableRatio(){
        return this.size/table.length;
    }

    public void dump(String debug, String dataType, double alpha) throws IOException {
        //print to a file method

        if(debug.equals("1")){
            //dump into file
            FileWriter fw = new FileWriter(type.toString().toLowerCase() +"-dump");
            for(int i=0;i<table.length;i++){
                fw.write("table[" + i +"]: " +table[i].toString() + "\n");
            }
            fw.close();

        }else{
            System.out.format("A good table size is found: %d\nData source type: %s" + "\n\n\n", this.tableSize,dataType);
            System.out.format("Using %s Hashing....\n",type.toString());
            System.out.format("Input %d elements, of which %d duplicates\n" +
                    "load factor = %s, Avg. no. of probes %.16f\n\n\n",table.length,duplicateCount(),String.valueOf(alpha),average());
        }
    }
    //method to get duplicates
    private int duplicateCount(){
        for(int i = 0 ;i < table.length;i++){
            numDuplicates += table[i].getDuplicateCount();
        }
        return numDuplicates;
    }
    //method number of probe values / number of objects
    private double average(){
        for(int i = 0 ;i < table.length;i++){
            numProbes += table[i].getProbeCount();
        }
        return numProbes/table.length; // needs fixed
    }
}
