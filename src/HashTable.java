import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class HashTable<T> {

    private HashObject<T>[] table;
    private T[] test;
    private HashType type;
    private int size;

    public enum HashType {
        LINEAR(),
        DOUBLE()
    }

    public HashTable(int tableSize, HashType hashType) {

        table = new HashObject[tableSize];
        type = hashType;

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
        if(initialPosition < 0){
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

    public void dump(){
        //print to a file method
    }

    //method to get duplicates
    //method number of probe values / number of objects
}
