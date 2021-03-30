function threeSum(nums: number[]): number[][] {

    nums.sort((a, b) => a - b);
    let [l1, l2, r] = [0, 1, nums.length - 1];
    const result = [];

    while (l1 < r - 1) {
        if (l1 > 0 && nums[l1] === nums[l1 - 1]) {
            l1++;
            continue;
        }
        l2 = l1 + 1;
        r = nums.length - 1;

        while (l2 < r) {
            const sum = nums[l1] + nums[l2] + nums[r];

            if (sum > 0) {
                r--;
            } else if (sum < 0) {
                l2++;
            } else {
                result.push([nums[l1], nums[l2], nums[r]]);
                l2++;
                while (l2 < r && nums[l2] === nums[l2 - 1]) {
                    l2++;
                }
            }
        }

        l1++;
    }

    return result;
};