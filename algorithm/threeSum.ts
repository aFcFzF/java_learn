function threeSum(nums: number[]): number[][] {
    const map: Record<number, number[]> = {};
    const result = [];
    if (nums.length <= 3) {
        return nums.reduce((a, b) => a + b, 0) === 0 ? [nums] : result;
    }

    nums.sort((a, b) => a - b);


    let [l1, l2, r] = [0, 1, nums.length - 1];



    return result;
};