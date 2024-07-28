package LinkedList;

import java.util.List;

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
class LinkedListNthNodeFrmBack {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    ListNode res;
    int t =0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null){
            return null;
        };
        this.t = n;
        helper1(head);
        return head;

    }

    public int helper(ListNode head, int n){

        if(head == null){
            return --t;
        }


        int x = helper(head.next,n);
        if(t == 0 ){
            head.next = head.next.next;
        }
        return --t;

    }
    private int helper1(ListNode node) {
        if (node == null) {
            return 0;
        }

        int count = helper1(node.next) + 1;

        if (count == t + 1) {
            node.next = node.next.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;

        LinkedListNthNodeFrmBack l = new LinkedListNthNodeFrmBack();
        l.removeNthFromEnd(head,2);



    }


}