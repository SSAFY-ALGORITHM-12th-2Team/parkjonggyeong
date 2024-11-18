import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String newK = changeK(n, k);
        
        // 0을 기준으로 분리한 후, 빈 문자열을 건너뛰도록 처리
        String[] sosus = newK.split("0");
        for (String sosu : sosus) {
            if (sosu.length() > 0) {
                    long num = Long.parseLong(sosu); 
                    if (isPrime(num)) {
                        answer++;
                    } 
            }
        }
        
        return answer;
    }

    // n을 k진수로 변환하는 함수
    private String changeK(int n, int k) {
        if (n == 0) return "0"; 
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    private boolean isPrime(long sosu) {
        if (sosu <= 1) return false;
        for (int i = 2; i <= Math.sqrt(sosu); i++) {
            if (sosu % i == 0) {
                return false;
            }
        }
        return true;
    }
}
