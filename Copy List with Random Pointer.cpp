/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
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
