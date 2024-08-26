import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    // 변수 선언
    static int T, n, m, map[][], max, k;
    static List<Point> h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 수 입력
        T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스에 대해 처리
        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            
            // n (맵 크기)과 m (집 한 채의 수익) 입력
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            // 집 위치를 저장할 리스트 초기화
            h = new LinkedList<>();
            
            // 맵 초기화
            map = new int[n][n];
            
            // 맵 정보 입력 및 집의 위치를 리스트에 저장
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        h.add(new Point(i, j)); // 집이 있는 위치를 리스트에 추가
                    }
                }
            }
            
            // 최대 집 수를 저장할 변수 초기화
            max = 0;
            
            // k는 운영 범위, n + 2부터 1까지 감소시키면서 실행
            for (int k = n + 2; k > 0; k--) {
                
                // 맵의 모든 좌표에 대해 반복
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int cnt = 0; // 현재 중심에서 커버할 수 있는 집의 수
                        
                        // 모든 집에 대해 거리 계산
                        for (int l = 0; l < h.size(); l++) {
                            // 현재 좌표 (i, j)와 각 집의 맨해튼 거리 계산
                            if (Math.abs(h.get(l).x - i) + Math.abs(h.get(l).y - j) < k) {
                                cnt++; // 커버 범위 내에 있으면 집 수 증가
                            }
                        }
                        
                        // 수익이 운영 비용보다 크거나 같은지 확인
                        if (cnt * m >= (k * k + (k - 1) * (k - 1))) {
                            // 더 많은 집을 커버할 수 있다면 max 값 갱신
                            if (max < cnt) {
                                max = cnt;
                            }
                        }
                    }
                }
            }
            // 결과 출력
            System.out.println("#" + t + " " + max);
        }
    }
}

// (m * 집 수) >= 운용비용(k * k + (k - 1) * (k - 1))이면 최대 커버 가능한 집 수를 max에 저장
