import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] answer = {0, 0};
    private List<int[]> discount = new ArrayList<>();
    private int[] data = {10, 20, 30, 40};

    public void dfs(int[] tmp, int d, int emoticonCount) {
        if (d == emoticonCount) {
            discount.add(tmp.clone());
            return;
        } else {
            for (int i : data) {
                tmp[d] += i;
                dfs(tmp, d + 1, emoticonCount);
                tmp[d] -= i;
            }
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int emoticonCount = emoticons.length;

        dfs(new int[emoticonCount], 0, emoticonCount);
        
        for (int[] d : discount) {
            int totalPay = 0;
            int cnt = 0;
            
            for (int[] user : users) {
                int pay = 0;
                
                for (int j = 0; j < d.length; j++) {
                    if (user[0] <= d[j]) {
                        pay += emoticons[j] * (100 - d[j]) / 100.0;
                    }
                    if (pay >= user[1]) {
                        break;
                    }
                }
                
                if (pay >= user[1]) {
                    pay = 0;
                    cnt++;
                }
                totalPay += pay;
            }
            
            if (cnt >= answer[0]) {
                if (cnt == answer[0]) {
                    answer[1] = Math.max(answer[1], totalPay);
                } else {
                    answer[1] = totalPay;
                }
                answer[0] = cnt;
            }
        }

        return answer;
    }
}
