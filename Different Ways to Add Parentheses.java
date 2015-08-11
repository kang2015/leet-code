import java.util.*;
import java.io.*;
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();
        decode(input,nums,ops);
        List<Integer> ans = new ArrayList<Integer>();
        int len = nums.size();
        List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>();
        for(int i=0;i<len;i++) dp.add(new ArrayList<List<Integer>>());
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                dp.get(i).add(new ArrayList<Integer>());
        for(int i=0;i<len;i++) dp.get(i).get(i).add(nums.get(i));//dp[i][i]=nums[i]
        for(int dist=1;dist<len;dist++){
            //dp[begin][end] = dp[begin][k] ops[k] dp[k+1[end];(begin<=k<end)
            for(int begin=0;begin<len-dist;begin++){
                int end = begin+dist;
                for(int k=begin;k<end;k++){
                    for(int i=0;i<dp.get(begin).get(k).size();i++)
                        for(int j=0;j<dp.get(k+1).get(end).size();j++)
                            dp.get(begin).get(end).add(compute(dp.get(begin).get(k).get(i),ops.get(k),dp.get(k+1).get(end).get(j)));
                }
            }
        }
        return dp.get(0).get(len-1);
    }
    private int compute(Integer num1, Character op, Integer num2){
        switch (op){
            case '+':
                return num1+num2;

            case '-':
                return num1-num2;

            case '*':
                return num1*num2;

            case '/':
                return num1/num2;

            default:
                return 0;
        }
    }
    private void decode(String input, List<Integer> nums, List<Character> ops){
        int i=0,len = input.length();
        while(i<len){
            int cur = 0;
            while(i<len){
                char c = input.charAt(i);
                if(c < '0' || c> '9'){
                    break;
                }
                cur = cur *10 + c - '0';
                i++;
            }
            nums.add(cur);
            if(i<len){
                ops.add(input.charAt(i));
                i++;
            }
        }
    }
    public static void main(String[] argv){
        //int [] q = {1,2,3,5,4,8};//matrix is: q[1]*q[2],q[2]*q[3],q[3]*q[4],...,q[len-1][len]
        Solution solution = new Solution();
        List<Integer> ans = solution.diffWaysToCompute("2*3-4*5");
        System.out.println(ans);
    }
}

