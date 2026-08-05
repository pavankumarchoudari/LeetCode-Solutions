import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
        // Base case: The current string has reached the maximum valid length
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }

        // Rule 1: We can always add an open parenthesis if we haven't hit the limit
        if (open < max) {
            sb.append("(");
            backtrack(ans, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1); // Undo choice
        }

        // Rule 2: We can only add a close parenthesis if it doesn't exceed open ones
        if (close < open) {
            sb.append(")");
            backtrack(ans, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1); // Undo choice
        }
    }
}
