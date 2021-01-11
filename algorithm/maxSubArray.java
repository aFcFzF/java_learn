/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let max = nums[0];
	for (let i = 0; i < nums.length; i++) {
		let tmp = nums[i];
		let last = nums[i];
		for (let j = i + 1; j < nums.length; j++) {
			last += nums[j]
			last > tmp && (tmp = last);
		}
		tmp > max && (max = tmp);
	}
	return max;
};
