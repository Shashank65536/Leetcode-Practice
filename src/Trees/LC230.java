package Trees;

import java.util.Stack;

public class LC230 {
    TreeNode root  = null;
    static int max = 0,count = 0;
    static class TreeNode {
        int value;
        TreeNode left, right;

        // Constructor to create a new node
        TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void recurseIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(root !=null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();

                root  = root.right;

            }

        }


    public void gg(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        max = root.value;
        while(root !=null || !stack.isEmpty()){
            while(root != null){
                if(root.value >= max){
                    count++;
                    max = root.value;
                }
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(stack.isEmpty()){
                max = root.value;
            }
            root  = root.right;

        }
    }

    public static void main(String[] args) {
        LC230 tree = new LC230();
        TreeNode root = new TreeNode(1);
        // Root node
        root.left = new TreeNode(2);          // Level 1 left child
        root.right = new TreeNode(3);         // Level 1 right child
        root.left.left = new TreeNode(4);     // Level 2 left child
        root.left.right = new TreeNode(5);    // Level 2 right child
        root.right.left = new TreeNode(6);    // Level 2 left child
        root.right.right = new TreeNode(7);   // Level 2 right child

        TreeNode root1 = new TreeNode(3);
        // Root node
        root1.left = new TreeNode(1);          // Level 1 left child
        root1.right = new TreeNode(4);         // Level 1 right child
        root1.left.left = new TreeNode(6);     // Level 2 left child
//        root1.left.right = new TreeNode(5);    // Level 2 right child
        root1.right.left = new TreeNode(1);    // Level 2 left child
        root1.right.right = new TreeNode(5);
        // Perform in-order traversal
        System.out.println("In-order traversal of the perfect binary tree:");
//        tree.recurseIterative(root);
//        tree.check(root,3);
        tree.gg(root1);
        System.out.println(count);

    }
}
