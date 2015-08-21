public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0,count2=0;
        int data1=0,data2=0;
        for(int i:nums){
            if(count1 == 0){
                data1 = i;
            }else if(count2 == 0 && i!= data1){
                data2 = i;
            }
            if(data1 == i){
                count1 ++;
            }else if(data2 == i){
                count2 ++;
            }else{
                count1 --;
                count2 --;
            }
        }
        int len = nums.length/3;
        count1 = 0; count2 = 0;
        for(int i:nums){
            if(i == data1) count1++;
            else if(i == data2) count2++;
        }
        List<Integer> ans = new ArrayList<Integer>();
        if(count1 > len){
            ans.add(data1);
        }
        if(count2 > len){
            ans.add(data2);
        }
        return ans;
    }
}
