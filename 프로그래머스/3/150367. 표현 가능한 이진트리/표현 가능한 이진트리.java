import java.util.*;
import java.lang.*;
class Solution {
    static boolean b[];
    static int len, result;
    public int[] solution(long[] numbers){
        int[] answer = new int[numbers.length];
        int i =0;
        for(long number : numbers){
            String binary = Long.toBinaryString(number); 
            int h = 0;
            while((int) Math.pow(2, h) - 1 < binary.length()){
                h++;
               
            }
            len = (int) Math.pow(2, h) - 1 ;
            b = new boolean[len];
            int cnt = len - binary.length();
            for(int j = 0; j < binary.length(); j++){
                b[cnt + j] = binary.charAt(j) != '0';
            }
            
            result = 1;
            dfs(0, len - 1, false);
            answer[i] = result;
            i++;
        }
       
        return answer;
    }
    public static void dfs(int start, int end, boolean check){
        int mid = (start + end)/ 2;
        if(b[mid] && check){
            result = 0;
            return;
        }
        
        if(start != end){
   
            dfs(start, mid-1, !b[mid]);
            dfs(mid+1, end, !b[mid]); 
        }
    }
}