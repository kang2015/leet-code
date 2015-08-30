class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        if(nums.size()<=1 || t <0 || k<=0){
            return false;
        }
        multiset<long long> window;
        for(int i=0;i<nums.size();i++){
            for(auto it = window.lower_bound((long long)nums[i]-(long long)t);it!=window.upper_bound((long long)nums[i]+(long long)t);it++){
                return true;
            }
            window.insert(nums[i]);
            if(i>=k){
                window.erase(window.find(nums[i-k]));
            }
        }
        return false;
        
    }
};
