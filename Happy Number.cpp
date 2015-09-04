class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> hash;
        hash.insert(n);
        while(1){
            n = getNext(n);
            if(n == 1){
                break;
            }
            if(hash.count(n)){
                return false;
            }else{
                hash.insert(n);
            }
            
        }
        return true;
    }
    int getNext(int n){
        int ans = 0;
        while(n>0){
            int cur = n%10;
            n /= 10;
            ans += cur*cur;
        }
        return ans;
    }
};
