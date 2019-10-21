public class HashObject<T>{

    public int duplicateCount = 0;
    public int probeCount = 0;
    private T obj;
    private int loadFactor;

    public HashObject(T obj, int loadFactor){
        this.obj = obj;
        this.loadFactor = loadFactor;
    }
    public boolean equals(HashObject obj){
        if(getKey() == obj.getKey()){
            duplicateCount++;
            probeCount++;
            return true;
        }
        probeCount++;
        return false;
    }
    public String toString(){
        //Is this right?????
        String str = "Input " + this.obj.toString().length() + " elements, of which " + duplicateCount +
                "\n load factor = " + loadFactor + ", Avg. no. of probes " + probeCount;
        return str;
    }
    public T getKey(){
        return this.obj;
    }
    public int duplicate(){
        return duplicateCount;
    }
    public int probeCount(){
        return this.probeCount;
    }
}