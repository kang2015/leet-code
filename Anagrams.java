public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> ans = new ArrayList<String>();
        HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            String tmp = sortstring(str);
            if(hashmap.containsKey(tmp)){
                if(hashmap.get(tmp)!=-1){
                    ans.add(strs[hashmap.get(tmp)]);
                    hashmap.put(tmp,-1);
                }
                ans.add(str);
            }else{
                hashmap.put(tmp,i);
            }
        }
        return ans;
    }
    private String sortstring(String s){
        char[] c= s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
