/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void dfs(TreeNode curRoot,List<Integer> ans, int curLevel){
        if(curLevel>ans.size()){
            ans.add(curRoot.val);
        }
        if(curRoot.right != null){
            dfs(curRoot.right,ans,curLevel+1);
        }
        if(curRoot.left != null){
            dfs(curRoot.left,ans,curLevel+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root == null){
            return ans;
        }
        dfs(root,ans,1);
        return ans;
    }
}
