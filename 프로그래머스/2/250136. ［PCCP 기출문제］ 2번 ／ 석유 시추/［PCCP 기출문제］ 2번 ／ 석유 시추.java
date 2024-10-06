import java.util.*;
import java.awt.Point;
class Solution {
    static int n, m, cnt;
    static int[] oil;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        oil = new int[m];
        boolean[][] v = new boolean[n][m];
        
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !v[i][j]){
     bfs(land, v, i, j);            
                }
                
            }
        }
        for(int i = 0; i < m; i++){
            answer = Math.max(answer, oil[i]);
        }
        return answer;
    }
    public void bfs(int[][] land, boolean[][] v, int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        v[x][y] = true;
        
        cnt = 1;
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            Point p = q.poll();
            set.add(p.y);
            
            for(int d = 0; d < 4; d++){
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !v[nr][nc]&& land[nr][nc] == 1){
    q.add(new Point(nr,nc));
                    v[nr][nc] = true;
                    cnt++;
                }
            }
        }
        for(int idx : set){
            oil[idx] += cnt;
        }
    }
}