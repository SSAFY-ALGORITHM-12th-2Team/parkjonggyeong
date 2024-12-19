import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    int max = 0;

    public void dfs(char[] order, StringBuilder key, int i, int end, int depth) {
        if (depth == end) {
            String combination = key.toString();
            map.put(combination, map.getOrDefault(combination, 0) + 1);
            max = Math.max(max, map.get(combination));
            return;
        }

        for (int j = i + 1; j < order.length; j++) {
            key.append(order[j]);
            dfs(order, key, j, end, depth + 1);
            key.deleteCharAt(key.length() - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();

        for (int c : course) {
            map = new HashMap<>();
            max = 0;

            for (String order : orders) {
                char[] strs = order.toCharArray();
                Arrays.sort(strs);
                dfs(strs, new StringBuilder(), -1, c, 0);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1 && entry.getValue() == max) {
                    ans.add(entry.getKey());
                }
            }
        }

        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }
}
