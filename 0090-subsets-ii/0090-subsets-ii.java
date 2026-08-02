class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset) {
        ans.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            backtrack(nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}