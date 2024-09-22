class Solution {
    static boolean v[];
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }
    private void dfs(int depth, int pee, int[][] dungeon){
        for(int i =0; i < dungeon.length; i++){
            if(!v[i] && dungeon[i][0] <= pee){
                v[i] = true;
                dfs(depth + 1, pee - dungeon[i][1], dungeon);
                v[i] = false;
            }
            answer = Math.max(answer, depth);
        }
    }
}