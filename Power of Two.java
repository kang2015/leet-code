public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE){
            return false;
        }else{
            return (n & (n-1)) == 0? true:false;
        }
    }
}
