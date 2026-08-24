class Solution {
    class Node{
        Node[] child;
        boolean isEndOfWord;
        Node(){
            this.child = new Node[26];
            this.isEndOfWord = false;
        }
    }
    Node root = new Node();
    public void insert(String s){
        Node temp = root;
        for(char c: s.toCharArray()){
            int i = c - 'a';
            if(temp.child[i] == null){
                Node newNode = new Node();
                temp.child[i] = newNode;
            }
            temp = temp.child[i];
        }
        temp.isEndOfWord = true;
    }
    public String search(String s){
        Node temp = root;
        String ans = "";
        for(char c: s.toCharArray()){
            int i = c - 'a';
            if(temp.child[i] == null) return s;
            ans += c;
            temp = temp.child[i];
            if(temp.isEndOfWord) return ans;
        }
        return s;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String s: dictionary){
            insert(s);
        }
        String[] arr = sentence.split(" ");
        String res = "";
        for(String s: arr){
            res += search(s) + " ";
        }
        return res.trim();
    }
    
}
