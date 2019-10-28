import java.math.BigInteger;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Test {

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 95791;
        int b = (int)(Math.log(n) / Math.log(2) + 1) -1;
        //int randNum = rand.nextInt(n - 2) + 2;
        int randNum = 13;
        BigInteger holdNum = new BigInteger(Integer.toString(randNum)); //Holding randNumber so it can change after 1 or 0;
        BigInteger b1 = new BigInteger(Integer.toString(n)); // Holding table length;
        BigInteger b2 = new BigInteger(Integer.toString(randNum)); //Holding randNumber to be used consistently in equation
//        BigInteger holdNum = new BigInteger(("0"));
        while (b >= 0) {
            int a = (n >> (b));
            if(a%2 == 1){
                holdNum = holdNum.pow(2).multiply(b2).mod(b1);
//                holdNum = (((int) ((Math.pow(randNum, 2)) % n) * randNum) % n);
//                holdNum = (((int) ((Math.pow(holdNum, 2)) % n) * randNum) % n);
            }else{
                holdNum = holdNum.pow(2).mod(b1);
                //holdNum= ((int)(Math.pow(holdNum, 2)) % n);
            }
            b = b -1;
        }
        System.out.println(holdNum.toString());
    }
}
