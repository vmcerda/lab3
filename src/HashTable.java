import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class HashTable<T> {

    private HashObject<T>[] table;
    private HashType type;
    private int size;

    public enum HashType {
        LINEAR(),
        DOUBLE()
    }

    public HashTable(int tableSize, HashType hashType) {

        table = (HashObject<T>[]) new Object[tableSize];
        type = hashType;
        size = tableSize;
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
        HashObject newObj = new HashObject(obj);
        if (table[hashCode()] == null) {
            table[hashCode()] = newObj;
            newObj.incProbeCount();
        }else{
            equals(newObj);
        }
    }
}
