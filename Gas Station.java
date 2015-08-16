public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length){
            return -1;
        }
        int len = gas.length;
        int[] gap = new int[len];
        for(int i=0;i<len;i++){
            gap[i] = gas[i]-cost[i];
        }
        int sum=0,total = 0;
        int ans = -1;
        for(int i=0;i<len;i++){
            total += gap[i];
            if(sum<=0){// if sum<=0 ,all before points can't be ans, start from this point
                sum = gap[i];
                ans = i;
            }else{
                sum += gap[i];
            }
        }
        return total<0?-1:ans;
    }
}
