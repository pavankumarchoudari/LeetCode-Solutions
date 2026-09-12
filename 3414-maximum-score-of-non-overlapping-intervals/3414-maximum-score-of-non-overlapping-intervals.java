class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[3], b[3]);
        });

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = i - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid][1] < arr[i][0]) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            prev[i] = ans;
        }

        long[][] dp = new long[n + 1][5];

        List<Integer>[][] path = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                path[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            int idx = i - 1;

            for (int k = 1; k <= 4; k++) {

                long notTake = dp[i - 1][k];

                long take = arr[idx][2];

                int p = prev[idx];

                if (p != -1) {
                    take += dp[p + 1][k - 1];
                }

                List<Integer> takePath = new ArrayList<>();

                if (p != -1) {
                    takePath.addAll(path[p + 1][k - 1]);
                }

                takePath.add(arr[idx][3]);

                if (take > notTake) {
                    dp[i][k] = take;
                    path[i][k] = takePath;
                } else if (take < notTake) {
                    dp[i][k] = notTake;
                    path[i][k] = new ArrayList<>(path[i - 1][k]);
                } else {
                    List<Integer> notTakePath = path[i - 1][k];

                    if (isSmaller(takePath, notTakePath)) {
                        dp[i][k] = take;
                        path[i][k] = takePath;
                    } else {
                        dp[i][k] = notTake;
                        path[i][k] = new ArrayList<>(notTakePath);
                    }
                }
            }
        }

        List<Integer> answer = path[n][4];

        Collections.sort(answer);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {
        List<Integer> x = new ArrayList<>(a);
        List<Integer> y = new ArrayList<>(b);

        Collections.sort(x);
        Collections.sort(y);

        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i);
            }
        }

        return x.size() < y.size();
    }
}