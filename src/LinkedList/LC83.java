package LinkedList;

public class LC83 {
    public  static  class ListNode{

        int val;
        ListNode next;
    }
//    remove duplicates from sorted linked list


    public static ListNode removeDuplicates(ListNode head){

        ListNode x = head;
        while(head.next != null){
            ListNode t = head;
            while(t.val == t.next.val){
                t = t.next;

            }
            head.next = t.next;
            head = head.next;
        }
        return x;
    }

    public static  ListNode removeElements(ListNode head, int val) {
        ListNode x = head;
        while(x!=null && x.next!=null){
            if(x.next.val == val){
                x.next = x.next.next;
            }else{
                x  = x.next;
            }

        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode head3 = new ListNode();
        ListNode h4 = new ListNode();

        head.val = 1;
        head1.val = 1;
        head2.val = 1;
        head3.val = 1;
        h4.val = 1;


        head.next  = head1;
        head1.next = head2;
        head2.next = head3;

//        ListNode x = LC83.removeDuplicates(head);
////        System.out.println(x.val);
//        while(x!=null){
//            System.out.println(x.val + " ");
//            x = x.next;
//        }
        LC83.removeElements(head,1);
    }



}
