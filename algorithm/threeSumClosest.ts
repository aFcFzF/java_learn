function threeSumClosest(nums: number[], target: number): number {
    let result = Number.MAX_SAFE_INTEGER;

    nums.sort((a, b) => a - b);

    let [l1, l2, r] = [0, 1, nums.length - 1];

    const abs = (n: number) => {
        if (n >= 0) {
            return n;
        }

        if (n < 0) {
            return 0 - n;
        }
    };

    while (l1 < r - 1) {
        l2 = l1 + 1;
        r--;

        while (l2 < r) {
            const sum = nums[l1] + nums[l2] + nums[r];

            if (sum === target) {
                return sum;
            } else if (sum > target && abs(sum - target) < abs(result)) {
                result = sum;
                r--;
            } else if (sum < target && abs(target - sum) < abs(result)) {
                result = sum;
                l2++;
            }
        }

        l1++;
    }

    return target;
};