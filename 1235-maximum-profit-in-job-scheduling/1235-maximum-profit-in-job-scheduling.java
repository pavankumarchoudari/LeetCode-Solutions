import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int notTake = dp[i];

            int j = findPrevious(jobs, i);

            int take = jobs[i][2] + dp[j];

            dp[i + 1] = Math.max(notTake, take);
        }

        return dp[n];
    }

    private int findPrevious(int[][] jobs, int current) {
        int low = 0;
        int high = current;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (jobs[mid][1] <= jobs[current][0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}