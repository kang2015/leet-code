class Solution {
private:
    int partition(vector<int> &nums,int l,int r){
        int pivot = nums[l];
        while(l<r){
            while(l<r && nums[r] <= pivot) r--;
            nums[l] =nums[r];
            while(l<r && nums[l] >= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    int helper(vector<int>& nums, int l, int r, int k){
        int pos = partition(nums,l,r);
        if(pos == k){
            return nums[pos];
        }else if(pos < k){
            return helper(nums,pos+1,r,k);
        }else{
            return helper(nums,l,pos-1,k);
        }
    }
public:
    int findKthLargest(vector<int>& nums, int k) {
        int len = nums.size();
        return helper(nums,0,len-1,k-1);
    }
};
