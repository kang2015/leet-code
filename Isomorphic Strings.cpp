class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.length()!=t.length()){
            return false;
        }
        unordered_map<char,char> hashst;
        unordered_map<char,char> hashts;
        for(int i=0;i<s.length();i++){
            auto its = hashst.find(s[i]);
            auto itt = hashts.find(t[i]);
            if((its != hashst.end() && its->second != t[i])||(itt != hashts.end() && itt->second != s[i])){
                return false;
            }else{
                if(its == hashst.end()){
                    hashst[s[i]] = t[i];
                }
                if(itt == hashts.end()){
                    hashts[t[i]] = s[i];
                }
            }
        }
        return true;
    }
};
