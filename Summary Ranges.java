public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<nums.length;i++){
            int start = nums[i];
            while(i+1 < nums.length && nums[i+1] == nums[i] +1 ){
                i++;
            }
            if(nums[i] == start){
                ans.add(new String(""+start));
            }else{
                ans.add(new String(start+"->"+nums[i]));
            }
        }
        return ans;
    }
}
