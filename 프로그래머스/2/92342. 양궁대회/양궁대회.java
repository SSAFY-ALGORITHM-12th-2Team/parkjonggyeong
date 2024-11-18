import java.util.*;

class Solution {
    static int totalArrows, maxDifference;
    static int[] currentShot;
    static int[] bestShot = {-1};
    
    public int[] solution(int n, int[] info) {
        totalArrows = n;
        maxDifference = -1;
        currentShot = new int[11];
        search(info, 0, 0);
        return bestShot;
    }
    
    private static void search(int[] apeach, int idx, int used) {
        if(idx == 11) {
            if(used == totalArrows) {
                int apeachScore = 0, lionScore = 0;
                for(int i = 0; i < 11; i++) {
                    if(apeach[i] == 0 && currentShot[i] == 0) continue;
                    if(apeach[i] >= currentShot[i]) apeachScore += 10 - i;
                    else lionScore += 10 - i;
                }
                if(lionScore > apeachScore) {
                    int diff = lionScore - apeachScore;
                    if(diff > maxDifference) {
                        maxDifference = diff;
                        bestShot = currentShot.clone();
                    }
                    else if(diff == maxDifference) {
                        for(int i = 10; i >= 0; i--) {
                            if(bestShot[i] < currentShot[i]) {
                                bestShot = currentShot.clone();
                                break;
                            }
                            else if(bestShot[i] > currentShot[i]) break;
                        }
                    }
                }
            }
            return;
        }
        
        if(apeach[idx] == 0) {
            search(apeach, idx + 1, used);
        }
        
        if(used + apeach[idx] + 1 <= totalArrows) {
            currentShot[idx] = apeach[idx] + 1;
            search(apeach, idx + 1, used + apeach[idx] + 1);
            currentShot[idx] = 0;
        }
        
        if(apeach[idx] != 0) {
            for(int i = 0; i <= apeach[idx]; i++) {
                currentShot[idx] = i;
                search(apeach, idx + 1, used + i);
                currentShot[idx] = 0;
            }
        }
    }
}
