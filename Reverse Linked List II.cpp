/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* p = head,*ans = NULL;
        ListNode **t1 = &ans;
        int i=1;
        while(p){//before m; no-reverse;
            if(i == m){
                break;
            }
            *t1=p;
            t1=&((*t1)->next);
            p = p->next;
            i++;
        }
        ListNode *t2 = NULL;
        ListNode **t3 = &(p->next);//last node's next after reverse
        while(p){//between m and n; reverse;
            if(i > n){
                break;
            }
            ListNode *tmp = p->next;
            p->next = t2;
            t2 = p;
            p = tmp;
            i++;
        }
        *t1 = t2;
        *t3 = p;//after n; no-reverse;
        return ans; 
    }
};
