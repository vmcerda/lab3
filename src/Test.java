import java.math.BigInteger;
import java.util.Random;
import java.util.function.BinaryOperator;

public class Test {

    public static void main(String[] args) {
        Random rand = new Random();
        int p = 95785;
        int lastPrime = 0;
        for(int a = 95785; a <= 96000;a++){
            int randNum = rand.nextInt(a - 2) + 2;
            int num = randNum;
            String binary = Integer.toBinaryString(a-1);
            for(int x = 1; x <= binary.length()-1;x++){
                if(binary.charAt(x) == '0'){
                    num = (int)(Math.pow(num,2)% a );
                }else{
                    num = (int)(((Math.pow(num,2))*randNum)%a);
                }
            }
            if(num == 1) {
                if (lastPrime == a - 2) {
                    System.out.println(lastPrime);
                } else {
                    lastPrime = a;
                }
            }

        }
    }
}
