class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        int[] rd = new int[n];
        int[] rp = new int[n];
        
        for(int i =0; i < n; i++){
            rd[i] = deliveries[n - 1 - i];
            rp[i] = pickups[n - 1 - i];
        }
        long answer = 0;
        int pick = 0;
        int del = 0;
        
        for(int i =0; i < n; i++){
            pick += rp[i];
            del += rd[i];
            
            while(del > 0 || pick > 0){
                del -= cap;
                pick -= cap;
                answer += (n - i) * 2;
            }
        }
        
        
        return answer;
    }
}