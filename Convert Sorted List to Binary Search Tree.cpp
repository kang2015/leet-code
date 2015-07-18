/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(head == NULL){
            return NULL;
        }
        if(head->next == NULL){
            return new TreeNode(head->val);
        }
        ListNode *fast =head,*slow = head,*pre = NULL;
        while(fast && fast->next){
            fast = fast->next->next;
            pre = slow;
            slow = slow->next;
        }
        pre -> next = NULL;
        TreeNode *cur = new TreeNode(slow->val);
        cur -> left = sortedListToBST(head);
        cur-> right = sortedListToBST(slow -> next);
        return cur;
    }
};
