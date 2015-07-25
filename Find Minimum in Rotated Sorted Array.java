//wangMeng's method of loop invariant
//For array without duplicates
public class Solution {
    public int findMin(int[] nums) {
        int left=0,right = nums.length - 1;
        while(left < right){
            int mid = (left+right) >> 1;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        return nums[right];
    }
}

//For array that may contain duplicates
public class Solution {
    public int findMin(int[] nums) {
        int left=0,right = nums.length - 1;
        while(left < right){
            int mid = (left+right) >> 1;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else if(nums[mid] <nums[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return nums[right];
    }
}
