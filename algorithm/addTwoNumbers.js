/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let n1 = [];
    let n2 = [];

    while (l1) {
        const {val, next} = l1;
        l1 = next;
        n1.push(val);
    }

    while (l2) {
        const {val, next} = l2;
        l2 = next;
        n2.push(val);
    }

    let len = Math.max(n1.length , n2.length);

    let ex = 0;
    let result = [];
    let i = 0;

    while (i < len) {
        const num1 = n1[i] || 0;
        const num2 = n2[i] || 0;

        let sum = num1 + num2 + ex;
        sum > 9 ? (ex = 1, sum = sum % 10) : ex = 0;

        result.push(sum);
        i++;
    }

    ex && result.push(ex);

    let node = new ListNode(result.shift(0));
    let head = node;
    for (const i of result) {
        node.next = new ListNode(i);
        node = node.next;
    }

    return head;
};