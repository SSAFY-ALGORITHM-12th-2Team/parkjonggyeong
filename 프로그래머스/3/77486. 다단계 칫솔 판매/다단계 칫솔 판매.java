import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<String, String> parent = new HashMap<>();
    private Map<String, Integer> income = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i].equals("-") ? null : referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            distributeIncome(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = income.getOrDefault(enroll[i], 0);
        }

        return result;
    }

    private void distributeIncome(String seller, int totalSales) {
        if (seller == null || totalSales < 1) return;

        int commission = totalSales / 10;
        int profit = totalSales - commission;

        income.put(seller, income.getOrDefault(seller, 0) + profit);

        distributeIncome(parent.get(seller), commission);
    }
}