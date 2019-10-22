import java.util.Random;

public class PrimeCheck {

    private Random rand;
    private int result;
    private boolean check;

    public PrimeCheck(int minSize, int maxSize){
//        int start = minSize;
//        int holdNum = 0;
        check(minSize,maxSize);
//        while(start != maxSize){
//            int randNum = rand.nextInt();
//            String biNum = Integer.toBinaryString(minSize-1);
//            for(int i = 1; i < biNum.length(); i++){
//                if (biNum.charAt(i) == '1') {
//                    if(holdNum == 0){
//                        holdNum = ((int)(Math.pow(randNum,2)%minSize)*randNum)%minSize;
//                    }else{
//                        holdNum = ((((int)Math.pow(holdNum,2))%minSize)*randNum)%minSize;
//                    }
//                }else{
//                    holdNum = (int)Math.pow(holdNum,2)%minSize;
//                }
//            }
//            if(holdNum ==1 ){
//                this.result = minSize;
//                this.check = true;
//                break;
//            }
//        }
    }
    private void check(int minSize,int maxSize){
        int start = minSize;
        int holdNum = 0;
        int prime1 = 0;
        int prime2 = 0;
        while(start != maxSize){
            rand = new Random();
            int randNum = rand.nextInt(start + 1) + 1;
            String biNum = Integer.toBinaryString(minSize-1);
            for(int i = 1; i < biNum.length(); i++){
                if (biNum.charAt(i) == '1') {
                    if(holdNum == 0){
                        holdNum = (int)(((Math.pow(randNum,2)%minSize)*randNum)%minSize);
                    }else{
                        holdNum = (((((int)Math.pow(holdNum,2))%minSize)*randNum)%minSize); // not working correctly
                    }
                }else{
                    if(holdNum == 0){
                        holdNum = (int)(Math.pow(randNum,2)%minSize);
                    }else {
                        holdNum = ((int)(Math.pow(holdNum, 2)) % minSize);
                    }
                }
            }
            if(holdNum == 1 && prime1 == 0){
                prime1 = minSize;
                continue;
            }
            if(holdNum == 1 && prime1 != 0){
                prime2 = minSize;
                if((prime2 -prime1) == 2){
                    result = prime1;
                }
            }
        }
    }

    public int getPrime(){
        return result;
    }
}
