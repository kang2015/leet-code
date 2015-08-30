class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int left=0,right=nums.size()-1;
        while(left<=right){
            if(nums[left] == left){
                left++;
            }else if(nums[left] > right){
                swap(nums[left],nums[right]);
                right--;left++;
                //nums[left] = -1;
            }else if(nums[left] == -1){
                left++;
            }else{
                swap(nums[left],nums[nums[left]]);
            }
        }
        for(int i=0;i<=right;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return right+1;
        
    }
};
