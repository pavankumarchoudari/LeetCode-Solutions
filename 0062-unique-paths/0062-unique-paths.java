class Solution {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int choose = Math.min(m - 1, n - 1);

        long result = 1;

        for (int i = 1; i <= choose; i++) {
            result = result * (total - choose + i) / i;
        }

        return (int) result;
    }
}