package LeetCode;

public class Prob342 {

    /*
    Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
    */

    public static boolean isPowerOfFour(int num) {
        int i = 0;
        while (Math.pow(4, i) <= num) {
            if (Math.pow(4, i) == num) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPowerOfFour(num));
    }

}
