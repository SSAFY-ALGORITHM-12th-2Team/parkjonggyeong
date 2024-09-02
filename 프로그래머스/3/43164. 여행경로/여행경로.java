import java.util.*;

class Solution {
    static String[] list;
    static int n;
    static boolean v[];
    static List<String> result;
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        v = new boolean[n];
        list = new String[n + 1];
        result = new LinkedList<String>();
       
        
        list[0] = "ICN";
        dfs(0,"ICN","ICN", tickets);
        Collections.sort(result);
        return result.get(0).split(" ");
    }
    
    public void dfs(int depth, String start,String path,String[][] tickets){
        
        if(depth == n){
            result.add(path);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!v[i] && start.equals(tickets[i][0])){
                 
                v[i] = true;
                list[depth + 1] = tickets[i][1]; 
                dfs(depth + 1, tickets[i][1],path + " " + tickets[i][1], tickets);
                v[i] = false;  
            }    
        }
    }
}