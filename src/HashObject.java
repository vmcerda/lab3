public class HashObject<V>{

    public int count = 0;
    public int probeCount = 0;
    private int key;

    public HashObject(V obj, int key){

    }
    public boolean equals(){
        return true;
    }
    public String toString(){
        return null;
    }
    public int getKey(){
        return key;
    }
    public int duplicate(){
        return count;
    }
    public int probeCount(){
        return this.probeCount;
    }
}
