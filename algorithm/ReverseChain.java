class ReverseChain {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode left = null;

        while (head != null){
            ListNode next = head.next;

            head.next = left;
            left = head;

            head = next;
        }

        return left;
    }
}