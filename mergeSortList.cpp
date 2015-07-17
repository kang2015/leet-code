/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
private:
    ListNode* merge(ListNode *l1,ListNode * l2){
        ListNode *ret = NULL;
        ListNode **cur = &ret;
        while(l1&&l2){
            ListNode *tmp = NULL;
            if(l1->val < l2->val){
                *cur = l1;
                cur = &((*cur)->next);
                l1 = l1->next;
            }else{
                *cur = l2;
                cur = &((*cur)->next);
                l2 = l2->next;
            }
        }
        if(l1){
            *cur = l1;
        }else if(l2){
            *cur = l2;
        }
        return ret;
        
    }
public:
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head->next == NULL){
            return head;
        }
        ListNode *slow=head,*fast = head,*pre = NULL;
        while(fast && fast->next){
            fast = fast->next->next;
            pre = slow;
            slow = slow->next;
        }
        pre->next = NULL;
        fast = sortList(head);
        slow = sortList(slow);
        return merge(fast,slow);
    }
};
