package LeetCode;

public class prob450 {
    public static TreeNode deleteNode(TreeNode t, int key) {
        //1) node is the root
        if (t.val == key) {
            if (t.left != null && t.right == null) {
                return t.left;
            } else if (t.left == null && t.right != null) {
                return t.right;
            } else if (t.left != null) {
                //has both children, doesn't matter what child becomes the root
                //just go down the left side until we find an available child slot
                TreeNode right = t.right; //what we will be adding
                t = t.left; //what we will be returning
                TreeNode hop = t.left; //where it will be added
                //find where the node will have the right side added to it
                while (hop.left != null) {
                    hop = hop.left;
                }
                hop.left = right;
            } else {
                //the only node is deleted, resulting in an empty tree
                return null;
            }
        } else {
            //2) node is a child from the left/right with no children (at the end of a tree)
            //3) node is a child from the left/right with some child on the left/right
            if (t.left != null && t.right == null) {
                TreeNode parent = findParentNode(t.left, t, key);
                if (parent.left != null) {

                }
            } else if (t.left == null && t.right != null) {

            } else if (t.left != null) {

            }
        }
        return t;
    }
    public static TreeNode findParentNode(TreeNode child, TreeNode parent, int key) {
        if (child.val != key) {
            if (child.left != null) {
                return findParentNode(child.left, child, key);
            }
            if (child.right != null) {
                return findParentNode(child.right, child, key);
            }
        }
        return parent;
    }
//    public static TreeNode shiftNode(TreeNode t, TreeNode dir) {
//        //find the node that can be shifted up
//        //this node has at least one child that is null
//        //we don't know what side of the returned TreeNode would have no child,
//        //so we will need to test this when calling the function outside
//        if (t.left == null || t.right == null) {
//            return t;
//        } else {
//            //who cares how far it goes down!... :/
//            return shiftNode(t.left);
//        }
//    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null), new TreeNode(3));
        TreeNode answer = new TreeNode(2, new TreeNode(4, new TreeNode(5, new TreeNode(3), null), null), null);
        System.out.println(answer);
        System.out.println(deleteNode(root, 1));
    }
}
