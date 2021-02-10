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
    const reverse = num => {
        let sum = 0;
        while (num > 0) {
            const mod = num % 10;
            sum = sum * 10 + mod;
            num = num / 10 | 0;
        }

        return sum;
    };

    let n1 = 0;
    let n2 = 0;

    while (l1) {
        const {val, next} = l1;

        n1 = n1 * 10 + val;
        l1 = next;
    }

    while (l2) {
        const {val, next} = l2;

        n2 = n2 * 10 + val;
        l2 = next;
    }

    const sum = (reverse(n1) + reverse(n2)) + '';

    let trial = null;

    for (const val of sum) {
        const node = new TreeNode(val);

        node.next = trial;
        trial = node;
    }

    return trial;
};