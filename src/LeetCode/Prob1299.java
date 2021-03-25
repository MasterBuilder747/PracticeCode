package LeetCode;

import java.util.Arrays;

public class Prob1299 {

    /*
    Given an array arr, replace every element in that array
    with the greatest element among the elements to its right,
    and replace the last element with -1.
    */

    public static int[] replaceElements(int[] arr) {
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i + 1];
            for (int j = i + 1; j < arr.length - 1; j++) {
                num = Math.max(num, arr[j+1]);
            }
            out[i] = num;
        }
        out[arr.length-1] = -1;
        return out;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        int[] arr2 = {12, 8, 17, 8, 7};
        //solution: 18,6,6,6,1,-1
        System.out.println(Arrays.toString(replaceElements(arr2)));
    }
}
