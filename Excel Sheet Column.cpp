// AA -> 27
class Solution {
public:
    int titleToNumber(string s) {
        int len = s.length();
        int ans = 0;
        for(int i=0;i<len;i++){
            ans = ans*26 + (s[i] - 'A'+1);
        }
        return ans;
    }
};

// 27 -> AA
class Solution {
public:
    string convertToTitle(int n) {
        string ans = "";
        while(n>0){
            ans = char ((--n)%26  + 'A') + ans;
            n = n/26;
        }
        return ans;
    }
};
