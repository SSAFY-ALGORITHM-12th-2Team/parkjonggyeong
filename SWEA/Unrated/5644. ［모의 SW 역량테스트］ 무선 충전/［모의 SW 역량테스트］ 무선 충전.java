import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
  static int dy[] = {-1, 0, 1, 0};
  static int dx[] = {0, 1, 0, -1};
  static int result;

  static class BC {
    Point point;
    int c;
    int p;

    public BC(Point point, int c, int p) {
      this.point = point;
      this.c = c;
      this.p = p;
    }

  }

  static int T, m, a, person1[], person2[], per, max;
  static BC[] bc;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      a = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      person1 = new int[m];
      for (int move = 0; move < m; move++) {
        person1[move] = Integer.parseInt(st.nextToken());
      }
      person2 = new int[m];
      st = new StringTokenizer(br.readLine());
      for (int move = 0; move < m; move++) {
        person2[move] = Integer.parseInt(st.nextToken());
      }
      bc = new BC[a];
      for (int k = 0; k < a; k++) {
        st = new StringTokenizer(br.readLine());
        bc[k] = (new BC(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }
      result = 0;
      run();
      System.out.println("#" + t + " " + result);
    }
  }

  private static void run() {
    // a의 초기값
    Point user1 = new Point(1, 1);

    Point user2 = new Point(10, 10);

    check(user1, user2);

    for (int i = 0; i < m; i++) {
      move(person1[i], user1);
      // System.out.println(user1.x + ", " + user1.y);
      move(person2[i], user2);
      check(user1, user2);
    }
  }

  private static void check(Point user1, Point user2) {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();


    for (int i = 0; i < a; i++) {
      if (bc[i].c >= (Math.abs(bc[i].point.x - user1.x) + Math.abs(bc[i].point.y - user1.y))) {
        list1.add(i);
      }
    }
    for (int i = 0; i < a; i++) {
      if (bc[i].c >= (Math.abs(bc[i].point.x - user2.x) + Math.abs(bc[i].point.y - user2.y))) {
        list2.add(i);
      }
    }
    max = 0;
    if (!list1.isEmpty() && !list2.isEmpty()) {
      for (int i = 0; i < list1.size(); i++) {
        for (int j = 0; j < list2.size(); j++) {
          per = 0;
          if (list1.get(i).equals( list2.get(j))) {
            per = bc[list1.get(i)].p;
          } else {
            per += bc[list1.get(i)].p;
            per += bc[list2.get(j)].p;
          }
                    max = Math.max(max, per);
        }

      }
    }

    else if (!list1.isEmpty()) {
      for (int i = 0; i < list1.size(); i++) {
        max = Math.max(max, bc[list1.get(i)].p);
      }
    } else if (!list2.isEmpty()) {
      for (int i = 0; i < list2.size(); i++) {
        max = Math.max(max, bc[list2.get(i)].p);
      }
    }
    result += max;
  }

  public static void move(int go, Point user) {
    switch (go) {
      case 1:

        user.y = user.y + dy[0];
        break;
      case 2:
        user.x = user.x + dx[1];

        break;
      case 3:
             user.y = user.y + dy[2];
        break;
      case 4:
        user.x = user.x + dx[3];

        break;
      case 0:
        break;
    }
  }
}
