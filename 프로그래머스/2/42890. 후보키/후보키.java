import java.util.*;

class Solution {
    static int answer = 0;
    static List<Set<Integer>> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int colLen = relation[0].length;

        // 1. 1~colLen까지의 모든 속성 조합에 대해 DFS 수행
        for (int i = 1; i <= colLen; i++) {
            boolean[] visited = new boolean[colLen];
            dfs(visited, 0, 0, i, relation);
        }

        return answer;
    }

    private void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            // 현재 선택된 컬럼 조합을 확인
            Set<Integer> cols = new HashSet<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    cols.add(i);
                }
            }

            // 1. 유일성 검사
            if (!isUnique(cols, relation)) {
                return;
            }

            // 2. 최소성 검사
            if (!isMinimal(cols)) {
                return;
            }

            // 후보 키로 인정
            candidateKeys.add(cols);
            answer++;
            return;
        }

        // DFS 탐색
        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, i + 1, depth + 1, end, relation);
                visited[i] = false;
            }
        }
    }

    // 유일성을 검사하는 함수
    private boolean isUnique(Set<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for (int col : cols) {
                key.append(row[col]).append(",");
            }

            if (!seen.add(key.toString())) {
                return false; // 유일성 실패
            }
        }

        return true; // 유일성 만족
    }

    // 최소성을 검사하는 함수
    private boolean isMinimal(Set<Integer> cols) {
        for (Set<Integer> candidateKey : candidateKeys) {
            if (cols.containsAll(candidateKey)) {
                return false; // 최소성 실패
            }
        }

        return true; // 최소성 만족
    }
}