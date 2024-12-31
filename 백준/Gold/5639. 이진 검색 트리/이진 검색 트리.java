import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            if(line.equals("")){
                break;
            }
            input.add(Integer.parseInt(line));
        }
        postorder(0, input.size() - 1);

    }

    private static void postorder(int start, int end) {
        if (start > end) {
            return;
        }
        int root = input.get(start);
        int mid = end + 1;
        for (int i = start + 1; i <= end; i++) {
            if (input.get(i) > root) {
                mid = i;
                break;
            }
        }
        postorder(start + 1, mid - 1);
        postorder(mid, end);

        System.out.println(root);
    }


}