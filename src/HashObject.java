public class HashObject<T>{

    public int duplicateCount = 0;
    public int probeCount = 0;
    private int key;
    private int loadFactor;

    public HashObject(T key, int loadFactor){
        this.key = Integer.parseInt((String)key);
        System.out.println(this.key);System.exit(0);
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
        //Is this right, not sure what the Input value needs to be?????
        String str = "Input " + "??" + " elements, of which " + duplicateCount +
                "\n load factor = " + loadFactor + ", Avg. no. of probes " + probeCount;
        return str;
    }
    public int getKey(){
        return this.key;
    }
    //Do I need these methods
    public int duplicate(){
        return duplicateCount;
    }
    public int probeCount(){
        return this.probeCount;
    }
}