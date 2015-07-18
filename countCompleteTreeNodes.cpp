/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 //O(n)
class Solution {
public:
    int countNodes(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        if(root->left == NULL && root->right == NULL){
            return 1;
        }
        if(root->right == NULL){
            return 2;
        }
        return countNodes(root->left)+countNodes(root->right)+1;
    }
};

//O(log(n))
class Solution {
private:
    int getlen(TreeNode *root){
        int ans = 0;
        while(root){
            ans++;
            root = root->left;
        }
        return ans;
    }
public:
    int countNodes(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        int llen = getlen(root->left);
        int rlen = getlen(root->right);
        if(llen == rlen){
            return (1<<llen) + countNodes(root->right);
        }else{
            return (1<<rlen) + countNodes(root->left);
        }
    }
};
