import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // Queue로 변환
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sumQ1 = 0;
        long sumQ2 = 0;
        
        // Queue 초기화 및 합계 계산
        for (int num : queue1) {
            q1.add(num);
            sumQ1 += num;
        }
        
        for (int num : queue2) {
            q2.add(num);
            sumQ2 += num;
        }
        
        long total = sumQ1 + sumQ2;
        int limit = queue1.length * 4;  

        // 총합이 홀수라면 나눌 수 없음
        if (total % 2 != 0) {
            return -1;
        }
        
        // 두 큐의 합이 같을 때까지 반복
        while (sumQ1 != sumQ2) {
            if (answer > limit) {  
                return -1;
            }

            // sumQ1이 더 클 때 q1의 요소를 q2로 이동
            if (sumQ1 > sumQ2) {
                int p1 = q1.poll();  
                q2.add(p1);       
                sumQ1 -= p1;
                sumQ2 += p1;
            } 
            // sumQ2가 더 클 때 q2의 요소를 q1으로 이동
            else {
                int p2 = q2.poll(); 
                q1.add(p2);         
                sumQ2 -= p2;
                sumQ1 += p2;
            }
            
            answer++;
        }
        
        return answer;
    }
}
