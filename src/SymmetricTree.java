
import java.util.*;

class TreeNode {
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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        fillInOrder(root,list);

        System.out.println(list);
        return true;

    }

    public void fillInOrder(TreeNode root, List<Integer> list){

        TreeNode temp = root;
        Map<Integer,Integer > map = new HashMap();

        if(temp!=null){
            list.add(temp.val);
            fillInOrder(temp.left,list);
            fillInOrder(temp.right,list);
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null ) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow;
        ListNode first = temp.next;

        while(first.next != null){
            ListNode second = first.next;
            first.next = temp;
            temp = first;
            first = second;
        }
        first.next = temp;

        ListNode rev = first;
        ListNode org = head;

        while(rev != org){
            if(rev.val != org.val){
                return false;
            }
            rev = rev.next;
            org = org.next;
        }
        return false;
    }
}*/
