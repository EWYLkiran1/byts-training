class Trie {

    class Node{
        Node[] nxt;
        boolean isWord;
        public Node(){
            this.nxt = new Node[26];
            this.isWord = false;
        }
        
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        char[] w = word.toCharArray();
        Node rt = root;
        for (int i = 0; i < w.length; i++){
            int idx = w[i] - 'a';
            if (rt.nxt[idx] == null){
                rt.nxt[idx] = new Node();
            }
            rt = rt.nxt[idx];
        }

        rt.isWord = true;

    }
    
    public boolean search(String word) {
        Node rt = root;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++){
            int idx = w[i] - 'a';
            if (rt.nxt[idx] == null) return false;
            rt = rt.nxt[idx];
        }
        return rt.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node rt = root;
        char[] w = prefix.toCharArray();
        for (int i = 0; i < w.length; i++){
            int idx = w[i] - 'a';
            if (rt.nxt[idx] == null) return false;
            rt = rt.nxt[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */