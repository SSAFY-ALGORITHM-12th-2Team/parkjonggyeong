import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans,(o1,o2) 
                    -> {
                        return o1[1].compareTo(o2[1]);
                        });
        
        return answer;
    }
}