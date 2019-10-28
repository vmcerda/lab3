import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;


public class HashTable<T> {

    private final int tableSize;
    private HashObject<T>[] table;
    private HashType type;
    private int size = 0;
    private int numDuplicates = 0;
    private int numProbes =0;
    private int totalProbeCount = 0;

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
        int secondary = (obj.hashCode() % (table.length - 2)) + 1;
        if (secondary < 0) {
            secondary += table.length - 2;
        }
        return secondary;
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
            BigInteger b1,b2;
            b1 = BigInteger.valueOf(initPos + (i * increment));
            b2 = BigInteger.valueOf(table.length);
            int position = b1.mod(b2).intValue();
            //int position = (initPos + i*increment) % table.length;
            if(table[position] == null){
                table[position] = newObj;
                table[position].incProbeCount(i+1);
                size++;
                break;
            }else if(newObj.equals(table[position])){
                table[position].incDuplicateCount();
                //table[position].incProbeCount(i+1);
                break;
            }
            //newObj.incProbeCount();
        }
    }

    public double tableRatio(){

        return ((double)this.size/(double)table.length);
    }

    public void dump(String debug, double alpha) throws IOException {
        //print to a file method

        if(debug.equals("1")){
            //dump into file
            FileWriter fw = new FileWriter(type.toString().toLowerCase() +"-dump");
            for(int i=0;i<table.length;i++){
                if(table[i] != null) {
                    fw.write("table[" + i + "]: " + table[i].toString() + "\n");
                }
            }
            fw.close();

        }else{

            //System.out.format("A good table size is found: %d\nData source type: %s" + "\n\n", this.tableSize, dataType);
            System.out.format("Using %s Hashing....\n",type.toString());
            System.out.format("Input %d elements, of which %d duplicates\n" +
                    "load factor = %s, Avg. no. of probes %.16f\n\n\n",size + duplicateCount(),numDuplicates,String.valueOf(alpha),average());
        }
    }

    private int totalProbeCount() {
        for(int i = 0 ;i < table.length;i++){
            if(table[i]!=null) {
                totalProbeCount += table[i].getProbeCount();
            }
        }
        return totalProbeCount;
    }

    //method to get duplicates
    private int duplicateCount(){
        for(int i = 0 ;i < table.length;i++){
            if(table[i]!=null) {
                numDuplicates += table[i].getDuplicateCount();
            }
        }
        return numDuplicates;
    }
    //method number of probe values / number of objects
    private double average(){
        for(int i = 0 ;i < table.length;i++){
            if(table[i] != null) {
                numProbes += table[i].getProbeCount();
            }
        }
        return numProbes/(double)size; // needs fixed
    }
}
