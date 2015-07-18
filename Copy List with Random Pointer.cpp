/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
 //solution 1- with a unordered_map
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        unordered_map<RandomListNode*,RandomListNode*> mp;
        RandomListNode *ret = NULL;
        RandomListNode **t = &ret;
        RandomListNode *p = head;
        while(p){
            *t = new RandomListNode(p->label);
            mp[p]=*t;
            t = &((*t)->next);
            p = p->next;
        }
        for(auto it=mp.begin();it!=mp.end();it++){
            p = it->first;
            if(p->random){
                auto it2 = mp.find(p->random);
                RandomListNode* tmp = it2->second;
                it->second->random = tmp;
            }
        }
        return ret;
    }
};

//solution 2 - without unorder_map, put new node just following old node
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode *p = head,*tmp=NULL;
        while(p){
            tmp = p->next;
            p->next = new RandomListNode(p->label);
            p->next->next = tmp;
            p = tmp;
        }
        p = head;
        while(p){
            p->next->random = p->random == NULL?NULL:p->random->next;
            p = p->next->next;
        }
        p = head;
        RandomListNode *ret = NULL;
        RandomListNode **t = &ret;
        while(p){
            tmp = p->next;
            p->next = tmp->next;
            *t = tmp;
            t = &(tmp->next);
            p = p->next;
        }
        return ret;
    }
};
