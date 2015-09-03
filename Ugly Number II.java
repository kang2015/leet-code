public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0){
            return 0;
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        int a=0,b=0,c=0;
        while(ans.size()<n){
            int next = Math.min(ans.get(a)*2,Math.min(ans.get(b)*3,ans.get(c)*5));
            if(ans.get(a)*2 == next) a++;
            if(ans.get(b)*3 == next) b++;
            if(ans.get(c)*5 == next) c++;
            ans.add(next);
        }
        return ans.get(n-1);
    }
}
