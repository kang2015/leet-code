class Solution {
public:
    string minWindow(string s, string t) {
        int pre=0,last=0;
        string ans;
        int need[128] = {0};
        int full[128] = {0};
        int need_reduced_count = 0;
        for(int i=0;i<t.length();i++){
            if(++need[t[i]] == 1){
                need_reduced_count ++;
            }
            ++full[t[i]];
        }
        while(last < s.length()){
            if(full[s[last]] > 0 && -- need[s[last]] == 0){
                need_reduced_count --;
            }
            last++;
            if(need_reduced_count > 0){
                continue;
            }
            while(pre < last){
                if(full[s[pre]]>0){
                    if(++ need[s[pre]] > 0){
                        need_reduced_count ++;
                        break;
                    }
                }
                pre++;
            }
            if(ans.length() == 0|| ans.length() > last-pre){
                ans = s.substr(pre,last-pre);
            }
            pre ++;
        }
        return ans;
    }
};
