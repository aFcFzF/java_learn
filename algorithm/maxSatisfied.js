/**
 * @param {number[]} customers
 * @param {number[]} grumpy
 * @param {number} X
 * @return {number}
 */

var maxSatisfied = function(customers, grumpy, X) {
    let i = 0;
    let max = 0;
    const sum = customers.reduce((a, b, i) => a + (grumpy[i] ? 0 : b), 0);

    while (i < customers.length) {

        let start = i;
        let end = i + X;

        let diff = 0;

        while (start < end) {
            const num = customers[start];
            diff = diff + (grumpy[start] ? num : 0);
            start++;
        }

        diff > max && (max = diff);
        i++;
    }

    return max + sum;
};