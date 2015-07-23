public class WordDictionary {
    class TrieNode{
        boolean isTerminate = false;
        List<TrieNode> child = new ArrayList<TrieNode>();
        TrieNode(){
            for(int i=0;i<26;i++) child.add(null);
        }
    }
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        int i=0;
        while(i<word.length() && p.child.get(word.charAt(i)-'a')!=null){
            p = p.child.get(word.charAt(i)-'a');
            i++;
        }
        while(i<word.length()){
            TrieNode tmp = new TrieNode();
            p.child.set(word.charAt(i)-'a',tmp);
            p = tmp;
            i++;
        }
        p.isTerminate = true;
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(root,word);
    }
    private boolean searchHelper(TrieNode p, String word){
        if(p!=null && p.isTerminate == true && word.length()==0){
            return true;
        }else if(p == null){
            return false;
        }else if(word.length()==0){
            return false;
        }
        if(word.charAt(0) == '.'){
            for(int i=0;i<26;i++){
                if(searchHelper(p.child.get(i),word.substring(1))){
                    return true;
                }
            }
            return false;
        }else{
            return searchHelper(p.child.get(word.charAt(0)-'a'),word.substring(1));
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
