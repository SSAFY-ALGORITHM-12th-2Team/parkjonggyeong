import java.io.*;
import java.util.*;

public class Solution {
    static int N, min, map[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수를 읽어옵니다.
        int T = Integer.parseInt(br.readLine());

        // 각 테스트 케이스를 처리합니다.
        for(int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;  // 최소 차이를 무한대로 초기화합니다.
            N = Integer.parseInt(br.readLine());  // 행렬의 크기(N)를 읽어옵니다.
            
            map = new int[N][N];  // NxN 크기의 행렬을 초기화합니다.
            
            // 행렬의 값을 읽어옵니다.
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 재귀적으로 두 집합을 나누는 함수 호출
            mix(0, 0, new boolean[N]);
            // 결과를 출력합니다.
            System.out.println("#" + t + " " + min);
        }       
    }
    
    // 집합을 나누기 위한 재귀 함수
    public static void mix(int index, int count, boolean[] visited) {
        // 모든 인덱스를 처리했을 때
        if(index == N) {
            // 두 집합의 크기가 같을 때만 차이를 계산합니다.
            if(count == N/2) {
                int sumA = 0;
                int sumB = 0;
                
                // 집합의 합을 계산합니다.
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(visited[i] && visited[j]) {
                            // 집합 A에 포함된 요소의 합
                            sumA += map[i][j];
                        } else if(!visited[i] && !visited[j]) {
                            // 집합 B에 포함된 요소의 합
                            sumB += map[i][j];
                        }
                    }
                }
                
                // 두 집합 간의 차이를 계산합니다.
                int diff = Math.abs(sumA - sumB);
                // 최소 차이를 업데이트합니다.
                min = Math.min(min, diff);
            }
            return;
        }
       
        // 현재 인덱스를 첫 번째 집합에 포함시키는 경우
        visited[index] = true;
        mix(index + 1, count + 1, visited);
         
        // 현재 인덱스를 두 번째 집합에 포함시키는 경우
        visited[index] = false;
        mix(index + 1, count, visited);
    }
}
