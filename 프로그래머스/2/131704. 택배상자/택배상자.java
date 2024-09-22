import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] ass = new int [order.length + 1];
        for(int i = 0; i < order.length; i++){
            ass[order[i]] = i;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        int box = 0;
        
        for(int i = 1; i <= order.length; i++){
            if(ass[i] == box){
               box++; 
            }else{
                stack.push(ass[i]);
            }
            while(!stack.isEmpty()){
                if(stack.peek() == box){
                    stack.pop();
                    box++;    
                }else{
                    break;
                }
                
            }
        }
        
        return box;
    }
}