import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = getMax(diffs);

        // 이진 탐색 수행
        while (left <= right) {
            int mid = (left + right) / 2;

            // 계산 결과가 true면 해당 레벨(mid)을 저장하고, 더 낮은 레벨을 탐색
            if (cal(diffs, times, (long)limit, mid)) { // limit을 long으로 변환
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    // 주어진 level에서 제한 시간 내에 해결 가능한지 확인하는 함수
    private static boolean cal(int[] diffs, int[] times, long limit, int level) {
        long timeAdded = 0;  // 시간 누적 변수를 long으로 설정

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            long timeCur = times[i];
            long timePre = 0;

            // 첫 번째 이외에는 이전 작업 시간(timePre)도 고려
            if (i != 0) {
                timePre = times[i - 1];
            }

            // 난이도가 레벨 이하라면 그대로 현재 작업 시간 더하기
            if (diff <= level) {
                timeAdded += timeCur;
            } else {
                // 난이도가 레벨보다 크다면 추가 시간을 계산
                long reCnt = diff - level;  // 초과한 난이도 만큼 작업을 반복해야 함
                long reCal = timePre + timeCur;  // 이전 작업 시간 + 현재 작업 시간
                long calTime = reCnt * reCal + timeCur;  // 추가 시간 계산
                timeAdded += calTime;
            }

            // 누적 시간이 limit을 넘으면 False 반환
            if (timeAdded > limit) {
                return false;
            }
        }

        return true;  // 제한 시간 내에 모두 완료 가능하다면 True 반환
    }

    // 배열 내에서 가장 큰 값을 반환하는 함수
    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
