import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 1. Sort the array
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        // 2. Start backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Target became 0 → we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number from start
        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate numbers at the SAME LEVEL
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted, no need to continue
            if (candidates[i] > target) {
                break;
            }

            // Choose the number
            current.add(candidates[i]);

            // Move to i + 1
            // because each number can be used only ONCE
            backtrack(
                    candidates,
                    target - candidates[i],
                    i + 1,
                    current,
                    result
            );

            // Remove the number
            // so we can try another choice
            current.remove(current.size() - 1);
        }
    }
}