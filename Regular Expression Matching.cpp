class Solution {
public:
    bool isMatch(string s, string p) {
        int slen = s.length(),plen = p.length();
       vector<vector<int>> dp(slen+1,vector<int>(plen+1,false));
       dp[0][0] = true;
       for(int i=1;i<plen && p[i] == '*';i = i+2){
            dp[0][i+1] = true;
       }
       for(int i=0;i<slen;i++){
           for(int j=0;j<plen;j++){
               if(s[i] == p[j] || p[j] == '.'){
                   dp[i+1][j+1] = dp[i][j];
               }else if(p[j] == '*'){
                   bool tmp1 = ((p[j-1] == s[i] || p[j-1]=='.') && dp[i][j+1]);//match s[i] with *
                   bool tmp2 = dp[i+1][j-1]; //skip *
                   dp[i+1][j+1] = tmp1 || tmp2;
               }
           }
       }
       return dp[slen][plen];
    }
};
