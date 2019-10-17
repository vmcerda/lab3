public class HashObject<V>{

    public int count = 0;
    public int probeCount = 0;

    public HashObject(){

    }

    public int duplicate(){
        return count;
    }

    public int probeCount(){
        return this.probeCount;
    }
}
