package LeetCode;

public class prob1351 {

    /*
    Given a m * n matrix grid which is sorted in
    non-increasing order both row-wise and column-wise.

    Return the number of negative numbers in grid.
    */

    public static int countNegatives(int[][] grid) {
        int num = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt < 0) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {
                    1, -4, -1, 4
                }
        };
        System.out.println(countNegatives(grid));
    }
}
