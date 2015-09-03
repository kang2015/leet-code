class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int left=0,right=nums.size()-1;
        while(left<=right){
            if(nums[left] == left){
                left++;
            }else if(nums[left] > right){
                swap(nums[left],nums[right]);
                right--;
                //nums[left] = -1;
            }else if(nums[left] != nums[nums[left]]){
                swap(nums[left],nums[nums[left]]);
            }else{
                left++;
            }
        }
        return right+1;
        
    }
};
