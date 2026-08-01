class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = 0;

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int candy : candies) {

            if (candy + extraCandies >= max)
                ans.add(true);
            else
                ans.add(false);
        }

        return ans;
    }
}