public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int second = nums[0];
        int first = Math.max(nums[1],nums[0]);
        int cur;
        for(int i=2;i<nums.length;i++){
            cur = Math.max(nums[i] + second,first);
            second = first;
            first = cur;
        }
        return first;
        
    }
}
