package Trees;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LC314 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<List<Integer>> verticalOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        dfs(root,0);
        System.out.println(map);
        return null;
    }

    public void dfs(TreeNode root,int level){
        if(root == null) return ;
        System.out.println(map.size());

        map.getOrDefault(level, new ArrayList<TreeNode>()).add(root);

        dfs(root.left,level-1);
        dfs(root.right,level+1);


    }

    public static void main(String[] args) {
        LC314 obj = new LC314();

        obj.verticalOrder();
    }
}