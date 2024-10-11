import java.util.*;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
 
        today = today.replace(".", "");
        int todayDate = Integer.parseInt(today);

        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            String termType = splitTerm[0];
            int termDuration = Integer.parseInt(splitTerm[1]) * 28; 
            termMap.put(termType, termDuration);
        }
        
        int cnt = 0;
        for (String privacy : privacies) {
            cnt++;
            String[] splitPrivacy = privacy.split(" ");
            String privacyDate = splitPrivacy[0].replace(".", "");
            String termType = splitPrivacy[1];
            
            int ls = Integer.parseInt(privacyDate);
            int year = (ls / 10000) % 100;
            int month = (ls / 100) % 100;
            int day = ls % 100;

            int days = day + termMap.get(termType);
            
            while (days > 28) {
                month += 1;
                days -= 28;
                if (month > 12) {
                    year += 1;
                    month -= 12;
                }
            }
      
            int totalDate = 20000000 + year * 10000 + month * 100 + days;
            
            if (todayDate >= totalDate) {
                answerList.add(cnt);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
