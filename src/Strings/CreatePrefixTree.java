package Strings;

class CreatePrefixTree {
    class Node{
        boolean flag;
        Node children[];

        public Node(){
            this.children = new Node[26];
            this.flag = false;
        }
    }
    private Node root;
    public CreatePrefixTree() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0;i< word.length();i++){

            if(curr.children[word.charAt(i)- 'a'] == null){
                Node n = new Node();
                curr.children[word.charAt(i)- 'a'] = n;
                curr = n;
            }
            if(i == word.length()-1){
                curr.flag =  true;
            }
        }
    }

    public boolean search(String word) {
        Node curr = root;
        boolean res = false;
        for(int i = 0;i< word.length();i++){
            if(curr.children[word.charAt(i)- 'a'] == null)return false;
            if(curr.children[word.charAt(i)- 'a'] != null){
                curr = curr.children[word.charAt(i)- 'a'];
            }
            if(i == word.length()-1 && curr.flag == true){
                res =  true;
                break;

            }

        }
        return res;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0;i< prefix.length();i++){
            Node temp = curr.children[prefix.charAt(i)- 'a'];
            if(temp != null){
                curr = temp;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "shashank";

        CreatePrefixTree c  =new CreatePrefixTree();
        c.insert(s);
        System.out.println(c.root);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */