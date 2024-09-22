import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] space;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 좌표 변화
    static int[] dy = {0, 0, -1, 1};
    
    static class Shark {
        int x, y, size, eaten;
        
        Shark(int x, int y, int size, int eaten) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eaten = eaten;
        }
    }
    
    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y; // y좌표 오름차순 (가장 왼쪽 우선)
                }
                return this.x - o.x; // x좌표 오름차순 (가장 위쪽 우선)
            }
            return this.dist - o.dist; // 거리 오름차순
        }
    }
    
    public static int bfs(Shark shark) {
        Queue<Shark> queue = new LinkedList<>();
        queue.offer(shark);
        visited[shark.x][shark.y] = true;
        
        List<Fish> fishList = new ArrayList<>();
        int time = 0;
        
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            
            while (qSize-- > 0) {
                Shark cur = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        
                        // 아기 상어가 지나갈 수 있는 조건: 공간이 비었거나 자신의 크기와 같거나 작은 물고기가 있는 칸
                        if (space[nx][ny] <= shark.size) {
                            queue.offer(new Shark(nx, ny, cur.size, cur.eaten));
                            
                            // 먹을 수 있는 물고기(자신보다 작은 물고기)가 있는 칸
                            if (space[nx][ny] > 0 && space[nx][ny] < shark.size) {
                                fishList.add(new Fish(nx, ny, time + 1)); // 거리를 함께 저장
                            }
                        }
                    }
                }
            }
            
            // BFS 탐색 한 번 완료 (한 시간 경과)
            time++;
            
            // 먹을 수 있는 물고기 리스트가 비어있지 않으면, 가장 가까운 물고기를 먹으러 이동
            if (!fishList.isEmpty()) {
                Collections.sort(fishList); // 우선순위 정렬
                Fish target = fishList.get(0);
                
                // 아기 상어 위치 및 상태 업데이트
                shark.x = target.x;
                shark.y = target.y;
                shark.eaten++;
                
                if (shark.eaten == shark.size) {
                    shark.size++;
                    shark.eaten = 0; // 크기가 커지면 먹은 물고기 수 초기화
                }
                
                space[target.x][target.y] = 0; // 물고기를 먹었으니 빈 칸으로 갱신
                return time; // 걸린 시간 반환
            }
        }
        
        return 0; // 더 이상 먹을 물고기가 없으면 0 반환
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        
        Shark shark = null;
        
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(line[j]);
                if (space[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0); // 아기 상어 초기화
                    space[i][j] = 0; // 아기 상어 위치는 빈 칸으로 초기화
                }
            }
        }
        
        int totalTime = 0;
        
        while (true) {
            visited = new boolean[N][N];
            int time = bfs(shark);
            
            if (time == 0) break; // 더 이상 먹을 물고기가 없으면 종료
            
            totalTime += time;
        }
        
        System.out.println(totalTime);
    }
}
