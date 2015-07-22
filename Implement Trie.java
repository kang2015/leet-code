class TrieNode {
    public List<TrieNode> child = new ArrayList<TrieNode>();
    boolean isTerminal = false;
    // Initialize your data structure here.
    public TrieNode() {
        for(int i=0;i<26;i++) child.add(null);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        int i=0;
        while(i< word.length() && p.child.get(word.charAt(i)-'a')!= null){
            p = p.child.get(word.charAt(i)-'a');
            i++;
        }
        while(i< word.length()){
            TrieNode tmp = new TrieNode();
            p.child.set(word.charAt(i)-'a',tmp);
            p = tmp;
            i++;
        }
        p.isTerminal = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = root;
        int i=0;
        while(i< word.length() && p!= null){
            p = p.child.get(word.charAt(i++)-'a');
        }
        if(i == word.length() && p!= null && p.isTerminal == true){
            return true;
        }else{
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        int i=0;
        while(i< prefix.length() && p!= null){
            p = p.child.get(prefix.charAt(i++)-'a');
        }
        if(i == prefix.length() && p!=null){
            return true;
        }else{
            return false;
        }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
