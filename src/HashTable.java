import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class HashTable<T> {

    private final int tableSize;
    private HashObject<T>[] table;
    private HashType type;
    private int size;

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
            int position = (initPos + i*increment) % table.length;
            if(table[position] == null){
                table[position] = newObj;
                size++;
                break;
            }else if(newObj.equals(table[position])){
                table[position].incDuplicateCount();
                break;
            }
            newObj.incProbeCount();
        }
    }

    public float tableRatio(){
        return size/table.length;
    }

    public void dump(String debug, String dataType, double alpha){
        //print to a file method
        if(debug == "0"){
            System.out.format("A good table size if found %d\n Data source type: " + dataType + "\n\n\n", this.tableSize);
            System.out.println("Using " + table + "Hashing....");
            System.out.format("Input %d elements, of which %d duplicates\n" +
                    "load factor = %.2f, Avg. no. of probes %.16f\n\n\n", size,alpha,average());
        }
    }
    //method to get duplicates
    private int duplicateCount(){
        return table[0].getDuplicateCount();
    }
    //method number of probe values / number of objects
    private double average(){
        return table[0].getProbeCount()/size; // needs fixed
    }
}
