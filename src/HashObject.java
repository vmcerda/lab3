public class HashObject<T>{

    public int duplicateCount = 0;
    public int probeCount = 0;
    private T obj;

    public HashObject(T obj){
        this.obj = obj;
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
        //write output for dumping data into files page 3 of instruction
        return null;
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