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
import apple.laf.JRSUIUtils;

/**
 * Created by kangyanli on 15/7/18.
 */

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
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right =r;
        Solution s = new Solution();
        TreeNode ans = s.lowestCommonAncestor(root,l,r);
        System.out.println(ans.val);
    }
}

/**
 * Created by kangyanli on 15/7/19.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

