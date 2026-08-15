class Solution {
    public int solve(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int add = solve(nums, target, i + 1, sum + nums[i]);
        int subtract = solve(nums, target, i + 1, sum - nums[i]);

        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }
}