public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2;i<n;i++)
            isPrime[i] = true;
        for(int i=2;i*i<n;i++){
            if(!isPrime[i]){
                continue;
            }
            for(int j=i*i;j<n;j+=i){
                if(isPrime[j]) isPrime[j] = false;
            }
        }
        int ret = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                ret ++;
            }
        }
        return ret;
    }
}
