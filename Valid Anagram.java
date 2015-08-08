public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[256];
        Arrays.fill(hash,0);
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)] ++;
        }
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]--;
        }
        for(int i:hash){
            if(i !=0){
                return false;
            }
        }
        return true;
    }
}
