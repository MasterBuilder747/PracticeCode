package LeetCode;

public class prob1287 {
    public static int findSpecialInteger(int[] arr) {
        int min; //min of occurrences that a given element must be in order to be returned
        if (arr.length < 4) {
            return arr[0];
        } else {
            min = (int)(1 + (arr.length / 4.0)); //2 or greater
        }
        int output = arr[0];
        int count = 1;
        int i = 1;
        while (count < min) {
            if (arr[i] == output) {
                count++;
            } else {
                count = 1;
                output = arr[i];
            }
            i++;
        }
        return output;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(a));
    }
}
