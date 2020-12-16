import java.util.Map;

/**
 * @file twoSum.java
 * @author afcfzf(9301462@qq.com)
 */

class Solution {
    public int[] twoSum (int[] nums, int target) {
        Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}