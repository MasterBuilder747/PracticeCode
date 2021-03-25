package LeetCode;

public class prob81 {
    public static boolean search(int[] nums, int target) {
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] a = {2,5,6,0,0,1,2};
        int t = 3;
        System.out.println(search(a, t));
    }
}
