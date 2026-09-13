class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;

        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {
            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {

                int count = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int ni = i + rowShift;
                        int nj = j + colShift;

                        if (ni >= 0 && ni < n &&
                            nj >= 0 && nj < n &&
                            img1[i][j] == 1 &&
                            img2[ni][nj] == 1) {

                            count++;
                        }
                    }
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}