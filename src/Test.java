import java.math.BigInteger;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Test {

    public static void main(String[] args) {
//        PrimeCheck check = new PrimeCheck(95790, 95791);
//        System.out.println("HERE");
//        System.out.println(check.getPrime());
        Random rand = new Random();
//        for(int i = 0; i < 10; i++){
//            //System.out.println(rand.nextInt((10-5)+1)+5);
//            //int num = rand.nextInt((5 - 1) - 1 ) + 2;
//            int start = 5;
//            int num = rand.nextInt(start - 2) + 2;
//            System.out.println(num);
//        }
        int n = 95791;
        int a = 0;
        int b = (int)(Math.log(n) / Math.log(2));
        int randNum = rand.nextInt(n - 2) + 2;
        b = b-1; // start on 2nd MSB
        //msb = (int)(Math.log(n) / Math.log(2));
        //int a = (int)(Math.pow(2, msb));
        //System.out.println(a);
        int holdNum = 0;
        while (b >= 0) {
            a = (n >> (b));
            //System.out.println(a%2);
            if(a%2 == 1){
                holdNum = ((int)(Math.pow(randNum, 2)) % n);
//                if(holdNum == 0) {
//                    //holdNum = (((int) ((Math.pow(randNum, 2)) % n) * randNum) % n);
//                }else{
//                    //holdNum = (((int) ((Math.pow(holdNum, 2)) % n) * randNum) % n);
//                }
            }else{
                holdNum = ((int)(Math.pow(randNum, 2)) * randNum) % n;
//                if(holdNum == 0){
//                    holdNum = (int)((Math.pow(randNum,2)) % n);
//                }else {
//                    holdNum = (int) ((Math.pow(holdNum, 2)) % n);
//                }
            }
            b = b -1;
        }
        System.out.println(randNum);
        System.out.println(holdNum);
    }
}
