package LeetCode;

public class prob563 {

    /*

    */

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) {
          this.val = val;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static int findTilt(TreeNode root) {
        int t1 = 0;
        int t2 = 0;
        if (root.left != null) {
            t1 = root.left.val;
            while (findTilt(root.left) != 0) {

            }
        }
        if (root.left != null) {
            t2 = root.right.val;
            while (findTilt(root.right) != 0) {

            }
        }
        int tilt = Math.abs(t1 - t2);
        return tilt;
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(findTilt(tn));
    }

}
