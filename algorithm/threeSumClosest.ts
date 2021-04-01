function threeSumClosest(nums: number[], target: number): number {
    let span = Number.MAX_SAFE_INTEGER;
    let result = target;

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
        r = nums.length - 1;

        while (l2 < r) {
            const sum = nums[l1] + nums[l2] + nums[r];

            if (sum === target) {
                return sum;
            } else if (sum > target) {
                if (abs(sum - target) < span) {
                    span = abs(sum - target);
                    result = sum;
                };

                r--;
            } else if (sum < target) {
                if (abs(target - sum) < span) {
                    span = abs(target - sum);
                    result = sum;
                }
                l2++;

                while(nums[l1] === nums[l2]) {
                    l2++;
                }
            }
        }

        l1++;
    }

    return result;
};