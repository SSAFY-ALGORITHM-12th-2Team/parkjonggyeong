import java.util.*;
class Solution {
    static int max, min;
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        max = 7;
        min = 7;
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j <  win_nums.length; j++){
                if(lottos[i] == 0){
                max -= 1;
                    break;
                }
                else if(lottos[i] == win_nums[j]){
                    max -= 1;
                    min -= 1;
                    break;
                }
            }
        }
        answer[1] = (min > 6) ? 6 : min;
        answer[0] = (max > 6) ? 6 : max;
        return answer;
    }
}