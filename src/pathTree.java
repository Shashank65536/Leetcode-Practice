public class pathTree {


    String res = "";
    static class Node{
        Node left, right;
        int val;

        public Node(Node left,Node right, int val){
            this.left  = left;
            this.right = right;
            this.val =  val;
        }
    }

    public String smallestFromLeaf(Node root) {
        res = (res + (char) ('a' + root.val));
        recurse(root);
        return res;
    }
    public void recurse(Node root){
        if(root == null ) return;
        if(root.left == null && root.right == null){
            res = ( res + (char)  ('a' + root.val));
            return;
        }
        if(root.left != null && root.right != null && root.left.val <  root.right.val){

            res = ( res + (char)  ('a' + root.left.val));
            System.out.println(res);
            recurse(root.left);
        }else if (root.left != null && root.right != null && root.left.val >  root.right.val){
            res = ( res + (char)  ('a' + root.left.val));
            System.out.println(res);
            recurse(root.right);
        }
        else if(root.left == null && root.right != null){
            res = ( res + (char)  ('a' + root.right.val));
            System.out.println(res);
            smallestFromLeaf(root.right);
        }else if (root.right == null && root.left != null){
            res = ( res + (char)  ('a' + root.left.val));
            System.out.println(res);
            smallestFromLeaf(root.left);
        }
    }

    public void preorder(Node root){
        if(root == null)return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String args[]){
        Node t4 = new Node(null,null,3);
        Node t5 = new Node(null,null,4);
        Node t9 = new Node(t4,t5,2);
        Node t7 = new Node(null,null,3);
        Node t8 = new Node(null,null,4);
        Node t6 = new Node(t7,t8,1);
        Node root = new Node(t6,t9,0);

        pathTree tree = new pathTree();
        String result = tree.smallestFromLeaf(root);

        System.out.println(result);
//        tree.preorder(root);

    }
}
