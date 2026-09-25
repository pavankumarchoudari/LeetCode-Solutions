import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(expression);
        Set<String> resultSet = new HashSet<>();

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str.indexOf('{') == -1) {
                resultSet.add(str);
                continue;
            }

            int right = str.indexOf('}');
            int left = str.lastIndexOf('{', right);

            String before = str.substring(0, left);
            String after = str.substring(right + 1);
            String[] options = str.substring(left + 1, right).split(",");

            for (String option : options) {
                StringBuilder sb = new StringBuilder();
                sb.append(before).append(option).append(after);
                queue.offer(sb.toString());
            }
        }

        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
