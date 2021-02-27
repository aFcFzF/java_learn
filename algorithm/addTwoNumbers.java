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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ext = 0;
        ListNode node = null;
        ListNode head = null;

        while (l1 != null || l2 != null) {
            int n1 = 0;
            int n2 = 0;

            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int sum = n1 + n2 + ext;

            if (sum > 9) {
                ext = 1;
                sum %= 10;
            } else {
                ext = 0;
            }

            ListNode tmp = new ListNode(sum, null);

            if (node == null) {
                node = head = tmp;
            } else {
                node.next = tmp;
                node = node.next;
            }
        }

        if (ext > 0) {
            node.next = new ListNode(ext, null);
        }

        return head;
    }
}