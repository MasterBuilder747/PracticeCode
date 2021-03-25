package LeetCode;

public class prob450 {
    public static TreeNode deleteNode(TreeNode t, int key) {
        if (t == null) {
            return null;
        }
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
                TreeNode[] nodes = {t, t.left, null, null};
                if (t.left.left != null) {
                    nodes[2] = t.left.left;
                }
                if (t.left.right != null) {
                    nodes[3] = t.left.right;
                }
                findNode(nodes, key);
            } else if (t.right != null && t.left == null) {

            } else if (t.left != null) {

            }
        }
        return t;
    }
    //{parent, child, child.left, child.right}; null if doesn't exist
    public static TreeNode[] findNode(TreeNode[] t, int key) {
        TreeNode[] output = new TreeNode[4];
        if (t[1] != null && t[0] != null) {
            if (t[1].val == key) {
                output = t;
            } else {
                TreeNode[] nodes = new TreeNode[4];
                if (t[1].left != null && t[1].right == null) {
                    nodes[0] = t[1].left;
                    if (t[1].left.left != null && t[1].left.right == null) {
                        nodes[1] = t[1].left.left;

                    }
                    if (t[1].left.right != null) {
                        nodes[3] = t[1].left.right;
                    }
                    output = findNode(nodes, key);
                } else if (t[1].left == null && t[1].right != null) {

                } else if (t[1].left != null) {

                }
            }
        }
        return output;
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
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
//        TreeNode answer = new TreeNode(2, new TreeNode(4, new TreeNode(5, new TreeNode(3), null), null), null);
//        System.out.println(answer);
        System.out.println(deleteNode(root, 3));
    }
}
