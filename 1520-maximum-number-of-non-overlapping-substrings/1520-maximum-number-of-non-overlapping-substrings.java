import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int start = first[i];
            int end = last[i];
            boolean isValid = true;

            for (int j = start; j <= end; j++) {
                int idx = s.charAt(j) - 'a';
                if (first[idx] < start) {
                    isValid = false;
                    break;
                }
                end = Math.max(end, last[idx]);
            }

            if (isValid) {
                intervals.add(new int[]{start, end});
            }
        }

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {
                ans.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return ans;
    }
}
