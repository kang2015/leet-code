/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // solutin 1 : with curFoot to record the lastone of pre
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flattenHelper(root);
    }
    private TreeNode flattenHelper(TreeNode root){
        TreeNode r = root.right;
        TreeNode curFoot = root;
        if(root.left != null){
            curFoot.right = root.left;
            curFoot.left = null;
            curFoot = flattenHelper(root.right);
        }
        if(r != null){
            curFoot.right = r;
            curFoot = flattenHelper(r);
        }
        return curFoot;
        
    }
}

//solutin 2 : without track the lastone of left, just find it from root
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode r = root.right;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        flatten(r);
        p.right = r;
    }
}
