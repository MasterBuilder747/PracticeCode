package LeetCode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    private TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public String toString() {
        //go down the tree, left to right
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(this.left == null && this.right == null) {
            //BST has only one node and therefore one val
            if (this.val != 0) {
                sb.append(this.val);
            } else {
                sb.append("null");
            }
        } else {
            sb.append(this.val);
            if (this.left != null) {
                sb.append(this.left.toString());
            } else {
                sb.append("[null]");
            }
            if (this.right != null) {
                sb.append(this.right.toString());
            } else {
                sb.append("[null]");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
