import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
  static int n, m, inDegree[];
  static List<Integer>[] wins;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    wins = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      wins[i] = new ArrayList<>();
    }
    inDegree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int winTeam = Integer.parseInt(st.nextToken());
      int loseTeam = Integer.parseInt(st.nextToken());
      wins[winTeam].add(loseTeam);
      inDegree[loseTeam]++;
    }
    bfs();
  }

  private static void bfs() {
    int only = 0;
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }
    Queue<Integer> result = new LinkedList<>();
    while(!q.isEmpty()){
      if(q.size() > 1){
        only = 1;
      }
      int p = q.poll();
      result.add(p);

      for (int i = 0; i < wins[p].size(); i++) {
        int temp = wins[p].get(i);
        inDegree[temp]--;
        if(inDegree[temp] == 0){
          q.add(temp);
        }
      }


    }
    for (int res : result){
      System.out.println(res);
    }
    System.out.println(only);
  }
}