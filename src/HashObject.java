public class HashObject<T>{

    public int duplicateCount = 0;
    public int probeCount = 0;
    private T key;
    private int loadFactor;

    public HashObject(T key){

        this.key = key;
    }
    public boolean equals(HashObject obj){
        if(getKey() == obj.getKey()){
            duplicateCount++;
            return true;
        }
        probeCount++;
        return false;
    }
    public String toString(){
        //Is this right, not sure what the Input value needs to be?????
        String str = "Input " + "??" + " elements, of which " + duplicateCount +
                "\n load factor = " + loadFactor + ", Avg. no. of probes " + probeCount;
        return str;
    }
    public T getKey(){
        return this.key;
    }
}