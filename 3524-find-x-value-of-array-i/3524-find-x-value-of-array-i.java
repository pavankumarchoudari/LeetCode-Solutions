class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int rem = num % k;
            long[] nextDp = new long[k];

            for (int x = 0; x < k; x++) {
                if (dp[x] > 0) {
                    nextDp[(x * rem) % k] += dp[x];
                }
            }

            nextDp[rem] += 1;

            for (int x = 0; x < k; x++) {
                result[x] += nextDp[x];
            }

            dp = nextDp;
        }

        return result;
    }
}
