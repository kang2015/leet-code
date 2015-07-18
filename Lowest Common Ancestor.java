/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//o(logn) for binary search tree
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val>root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}

//o(n) for unordered binary tree
public class Solution {
    private TreeNode ans = null;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean iscur = false,isleft = false,isright = false;
        if(root == p || root == q){
            iscur = true;
        }
        isleft = dfs(root.left,p,q);
        isright = dfs(root.right,p,q);
        if((iscur&&isright)||(iscur&&isleft)||(isleft&&isright)){
            ans = root;
        }
        return iscur||isleft||isright;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
}
