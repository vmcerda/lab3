import java.util.Random;

public class PrimeCheck {

    private final int minSize, maxSize;
    private Random rand;
    private int result;
    private boolean check;

    public PrimeCheck(int minSize, int maxSize) {

        //check(minSize,maxSize);
        this.minSize = minSize;
        this.maxSize = maxSize;
        rand = new Random();

    }

    public int findPrime() {
//        int start = minSize;
//        if(minSize%2 == 0){
//            start = minSize + 1; // ensures odd numbers, start at 95501;
//        }
//        int randNum = rand.nextInt(start - 2) + 2;
//        int holdNum = 0;
//        //int bitLength =Integer.toBinaryString(start).length();
//        int b = (int)(Math.log(start) / Math.log(2)); //get's length of binary number
//        b = b-1; // start on 2nd MSB
//        while(b >=0){
//
//        }
        Random rand = new Random();
        int lastPrime = 0;
        for (int a = minSize; a <= maxSize; a++) {
            int randNum = rand.nextInt(a - 2) + 2;
            int num = randNum;
            String binary = Integer.toBinaryString(a - 1);
            for (int x = 1; x <= binary.length() - 1; x++) {
                if (binary.charAt(x) == '0') {
                    num = (int) (Math.pow(num, 2) % a);
                } else {
                    num = (int) (((Math.pow(num, 2)) * randNum) % a);
                }
            }
            if (num == 1) {
                if (lastPrime == a - 2) {
                    return a;
                } else {
                    lastPrime = a;
                }
            }
        }
        return lastPrime;
    }
}