class Solution {
public:
    string largestNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end(),comp);
        string ans;
        for(int i=0;i<nums.size();i++){
            stringstream ss;
            ss << nums[i];
            ans += ss.str();
        }
        int i=0;
        while(i<ans.length()&&ans[i]=='0'){
            i++;
        }
        if(i==ans.length()){
            ans = '0';
        }else{
            ans = ans.substr(i);
        }
        return ans;
    }
    bool static comp(int n1,int n2){
        Solution s;
        return n1*pow(10,s.lens(n2))+n2 > n2*pow(10,s.lens(n1))+n1;
    }
    int lens(int n){
        if(n==0){
            return 1;
        }
        int ans = 0;
        while(n>0){
            ans++;
            n /= 10;
        }
        return ans;
    }
};
