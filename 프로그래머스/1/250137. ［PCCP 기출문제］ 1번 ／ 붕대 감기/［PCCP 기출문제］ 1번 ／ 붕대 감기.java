import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = bandage[0];
        int heal = bandage[1];
        int bonus = bandage[2];
        int cnt = 0;
        int count = 0;
        
        int lastAtkTime = attacks[attacks.length - 1][0];
        
        for (int i = 0; i <= lastAtkTime; i++) {
            if (cnt < attacks.length && i == attacks[cnt][0]) {
                answer -= attacks[cnt][1];
                cnt++;
                count = 0;
            } else {
                if (answer < health) {
                    answer += heal;
                    if (answer > health) {
                        answer = health;
                    }
                    count++;
                }
                if (count == time) {
                    answer += bonus;
                    count = 0;
                    if (answer > health) {
                        answer = health;
                    }
                }
            }
            if (answer <= 0) {
                return -1;
            }
        }
        
        return answer;
    }
}
