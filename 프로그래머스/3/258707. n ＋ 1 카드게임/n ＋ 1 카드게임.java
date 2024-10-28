import java.util.*;

class Solution {

    public int solution(int coins, int[] cards) {
        int rounds = 0;
        int n = cards.length;
        int cardIndex = n / 3;

        Set<Integer> mainSet = new HashSet<>(); 
        Set<Integer> newSet = new HashSet<>();  

        // 첫 카드들 주어진 개수만큼 추가
        for (int i = 0; i < cardIndex; i++) {
            mainSet.add(cards[i]);
        }

        int targetSum = n + 1;

        while (true) {
            rounds++; // 한 라운드 추가

            // 카드가 더 이상 남아있지 않으면 종료
            if (cardIndex >= n) {
                break;
            }

            // 새로운 카드들을 newSet에 추가
            newSet.add(cards[cardIndex]);
            newSet.add(cards[cardIndex + 1]);
            cardIndex += 2;

            boolean matched = false;

            // 1. 코인을 사용하지 않고 targetSum을 만족하는 경우
            for (int num : mainSet) {
                if (mainSet.contains(targetSum - num)) {
                    mainSet.remove(num);
                    mainSet.remove(targetSum - num);
                    matched = true;
                    break;
                }
            }

            // 2. 코인 하나를 사용하여 targetSum을 만족하는 경우
            if (!matched && coins >= 1) {
                for (int num : mainSet) {
                    if (newSet.contains(targetSum - num)) {
                        mainSet.remove(num);
                        newSet.remove(targetSum - num);
                        coins--;
                        matched = true;
                        break;
                    }
                }
            }

            // 3. 코인 두 개를 사용하여 targetSum을 만족하는 경우
            if (!matched && coins >= 2) {
                for (int num : newSet) {
                    if (newSet.contains(targetSum - num)) {
                        newSet.remove(num);
                        newSet.remove(targetSum - num);
                        coins -= 2;
                        matched = true;
                        break;
                    }
                }
            }

            // 4. targetSum을 만족하지 못할 경우 종료
            if (!matched) {
                break;
            }
        }
        return rounds;
    }
}
