import java.util.Random;

public class PrimeCheck {

    private Random rand;
    private int result;
    private boolean check;

    public PrimeCheck(int minSize, int maxSize){

        check(minSize,maxSize);

    }
    private void check(int minSize,int maxSize){
        int start = minSize;
        int holdNum = 0;
        int prime1 = 0;
        int prime2 = 0;
        rand = new Random();
        /*int randNum = rand.nextInt(start + 1) + 1;*/
        int randNum = rand.nextInt((maxSize - minSize) + 1) + minSize;
        while(start <= maxSize){
            String biNum = Integer.toBinaryString(start-1);
            for(int i = 1; i < biNum.length(); i++){
                if (biNum.charAt(i) == '1') {
                    if(holdNum == 0){
                        holdNum = (((int)((Math.pow(randNum,2)) % start) * randNum) % start);
                    }else{
                        holdNum = (((int)((Math.pow(holdNum,2)) % start) * holdNum) % start);
                    }
                }else{
                    if(holdNum == 0){
                        holdNum = (int)((Math.pow(randNum,2)) % start);
                    }else {
                        holdNum = (int)((Math.pow(holdNum, 2)) % start);
                    }
                }
            }
            if(holdNum == 1 && prime1 == 0){
                prime1 = start;
                start++;
                continue;
            }
            if(holdNum == 1 && prime1 != 0){
                prime2 = start;
                if((prime2 - prime1) == 2){
                    result = prime1;
                    break;
                }
            }
            start++;
        }
    }

    public int getPrime(){
        return result;
    }
}
