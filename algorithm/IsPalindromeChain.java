/**
 * @file isPalindromeChain.java
 * @author afcfzf(9301462@qq.com)
 */

public class isPalindromeChain {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean main(ListNode head) {
        int num = 0;
        int len = 0;

        ListNode node = head;

        while (node != null) {
            len++;
            int val = node.val;
            num = num * 10 + val;
            node = node.next;
        }

        if (num < 10) {
            return true;
        }

        int mid = len / 2;
        int reverse = 0;

        while (mid >= 0) {
            int mod = num % 10;
            reverse = reverse * 10 + mod;
            num /= 10;
            mid--;
        }

        if ((float)len / 2 > 0) {
            num /= 10;
        }

        return num == reverse;
    }
}
