import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        solve(0, nums, subset, ans);

        return ans;
    }

    private void solve(int idx, int[] nums,
                       List<Integer> subset,
                       List<List<Integer>> ans) {

        // Base case
        if (idx == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        // TAKE
        subset.add(nums[idx]);
        solve(idx + 1, nums, subset, ans);

        // UNDO the TAKE
        subset.remove(subset.size() - 1);

        // NOT TAKE
        solve(idx + 1, nums, subset, ans);
    }
}