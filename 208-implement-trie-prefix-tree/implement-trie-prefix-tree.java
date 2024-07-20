class Trie {
    class Node{
        char c;
        Map<Character,Node> children;
        int count;

        public Node(char c){
            this.c = c;
            children = new HashMap<>();
            count = 0;
        }
    }

    Node root;
    public Trie() {
        root = new Node(Character.MIN_VALUE);
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            if (null==temp.children.get(c)){
                temp.children.put(c,new Node(c));
            }
            temp = temp.children.get(c);
        }
        temp.count+=1;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            if (null!=temp && null!=temp.children.get(c)){
                temp = temp.children.get(c);
            }else{
                return false;
            }
        }
        return temp.count > 0;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char c: prefix.toCharArray()){
            if (null!=temp && null!=temp.children.get(c)){
                temp = temp.children.get(c);
            }else{
                return false;
            }
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