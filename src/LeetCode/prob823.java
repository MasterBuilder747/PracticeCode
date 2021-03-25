package LeetCode;

import java.util.Arrays;

public class prob823 {

    /*
    Given an array of unique integers, each integer is strictly greater than 1.

    We make a binary tree using these integers and each number may be used for any number of times.

    Each non-leaf node's value should be equal to the product of the values of it's children.

    How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.
    */

    public static void main(String[] args) {
        int[] a = {4, 2};
        int[] b = {2, 4, 5, 10};
        //3
        System.out.println(numFactoredBinaryTrees(a));
    }

    public static void print(int[][] a) {
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int numFactoredBinaryTrees(int[] A) {
        int out = A.length;
        int[][] mem = new int[A.length][A.length];
        for (int i = 0; i < mem.length; i++) {
            mem[i][0] = A[i];
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    if (A[i] % A[j] == 0/* && A[i] % A[j] > 1*/) {
                        for (int k = 0; k < mem.length; k++) {
                            if (mem[k][0] == A[i]) {
                                boolean chk = true;
                                for (int l = 1; l < mem[0].length; l++) {
                                    if (mem[k][l] == A[i] % A[j]) {
                                        chk = false;
                                        break;
                                    }
                                }
                                if (chk) {
                                    for(int h = 0; h < mem[0].length; h++) {
                                        if (mem[k][h] == 0) {
                                            mem[k][h] = (A[i] / A[j]);
                                            out++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = A.length-1; i > -1; i--) {
            for (int j = A.length-1; j > -1; j--) {
                if (i != j) {
                    if (A[i] % A[j] == 0/* && A[i] % A[j] > 1*/) {
                        for (int k = 0; k < mem.length; k++) {
                            if (mem[k][0] == A[i]) {
                                boolean chk = true;
                                for (int l = 1; l < mem[0].length; l++) {
                                    if (mem[k][l] == A[i] % A[j]) {
                                        chk = false;
                                        break;
                                    }
                                }
                                if (chk) {
                                    for(int h = 0; h < mem[0].length; h++) {
                                        if (mem[k][h] == 0) {
                                            mem[k][h] = (A[i] / A[j]);
                                            out++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        print(mem);
        return out;
    }



}
