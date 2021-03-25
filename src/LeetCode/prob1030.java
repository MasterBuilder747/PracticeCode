package LeetCode;

import java.util.Arrays;

public class prob1030 {

    /*
    We are given a matrix with R rows and C columns has cells with integer coordinates (r, c),
    where 0 <= r < R and 0 <= c < C.

    Additionally, we are given a cell in that matrix with coordinates (r0, c0).

    Return the coordinates of all cells in the matrix,
    sorted by their distance from (r0, c0) from smallest distance to largest distance.
    Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance,
    |r1 - r2| + |c1 - c2|.
    (You may return the answer in any order that satisfies this condition.)

    */

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] out;

        //Math.abs(r1 - r2) + Math.abs(c1 - c2);

        return new int[1][1];
    }

    public static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(allCellsDistOrder(1, 2, 3, 4));
    }
}
