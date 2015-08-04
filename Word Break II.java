public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Set<Integer> hist = new HashSet<Integer>();//for any h in hist, s[0 ~ h-1] is a possible solution
        List<List<Integer>> backt = new ArrayList<List<Integer>>();//backt[i] record possible source of pos i;
        for(int i=0;i<s.length();i++){
            backt.add(new ArrayList<Integer>());
        }
        hist.add(0);
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            flag = false;
            for(int begin:hist){
                if(wordDict.contains(s.substring(begin,i+1))){
                    flag = true;//if use hist.add(i+1) here, triger "ConcurrentModificationException"
                    backt.get(i).add(begin);
                }
            }
            if(flag) {
                hist.add(i+1);
            }
        }
        List<String> ans = new ArrayList<String>();
        String tmp = new String();
        dfs(ans,tmp,s,backt,s.length()-1);
        return ans;
    }
    private void dfs(List<String> ans, String tmp, String s,List<List<Integer>> backt, int pos){
        if(pos == -1){
            ans.add(new String(tmp.substring(0,tmp.length()-1)));//last one char of tmp is ' ',reomove it
            return;
        }
        for(int i=0;i<backt.get(pos).size();i++){
            int begin = backt.get(pos).get(i);
            dfs(ans,s.substring(begin,pos+1)+" "+tmp,s,backt,begin-1);
        }
    }
}
