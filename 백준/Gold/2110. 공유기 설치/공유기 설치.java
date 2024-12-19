import java.util.*;
import java.io.*;

public class Main {
    static int arr[], n, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(bs(c,1, arr[n - 1]));

    }

    private static int bs(int key, int low, int high) {
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            int cnt = 1;
            int  p = 0;
            for(int i = 1; i < n; i++){
                if(arr[i] - arr[p] >= mid){
                    p = i;
                    cnt++;
                }
            }
            if(cnt < key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
                

        }
        return low -1 ;
    }
}

