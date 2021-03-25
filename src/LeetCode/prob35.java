package LeetCode;

public class prob35 {

    /*

    Given a sorted array and a target value,
    return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    */

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6};
        int target = 5;
        System.out.println(searchInsert(a, target));
    }
}
