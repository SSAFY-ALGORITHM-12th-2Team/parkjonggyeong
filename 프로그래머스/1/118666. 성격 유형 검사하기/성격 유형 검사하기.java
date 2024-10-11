import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        // 성격 유형별 점수 저장
        HashMap<Character, Integer> scores = new HashMap<>();
        scores.put('A', 0);
        scores.put('N', 0);
        scores.put('C', 0);
        scores.put('F', 0);
        scores.put('R', 0);
        scores.put('T', 0);
        scores.put('J', 0);
        scores.put('M', 0);
        
        // 선택지에 따른 점수 변환
        HashMap<Integer, int[]> scoreMap = new HashMap<>();
        scoreMap.put(1, new int[]{3, 0});
        scoreMap.put(2, new int[]{2, 0});
        scoreMap.put(3, new int[]{1, 0});
        scoreMap.put(4, new int[]{0, 0});
        scoreMap.put(5, new int[]{0, 1});
        scoreMap.put(6, new int[]{0, 2});
        scoreMap.put(7, new int[]{0, 3});
        
        // 설문 조사 결과를 처리
        for (int i = 0; i < choices.length; i++) {
            char x = survey[i].charAt(0);
            char y = survey[i].charAt(1);
            
            int[] points = scoreMap.get(choices[i]);
            scores.put(x, scores.get(x) + points[0]);
            scores.put(y, scores.get(y) + points[1]);
        }
        
        // 결과 계산
        if (scores.get('R') >= scores.get('T')) answer += "R";
        else answer += "T";
        
        if (scores.get('C') >= scores.get('F')) answer += "C";
        else answer += "F";
        
        if (scores.get('J') >= scores.get('M')) answer += "J";
        else answer += "M";
        
        if (scores.get('A') >= scores.get('N')) answer += "A";
        else answer += "N";
        
        return answer;
    }
}
