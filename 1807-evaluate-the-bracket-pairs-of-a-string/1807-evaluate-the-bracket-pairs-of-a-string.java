import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                String key = s.substring(i + 1, j);

                if (map.containsKey(key)) {
                    ans.append(map.get(key));
                } else {
                    ans.append("?");
                }

                i = j + 1;
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}