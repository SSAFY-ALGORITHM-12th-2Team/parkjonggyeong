import java.util.*;

class Solution {
    // 시간을 분 단위로 변환하는 메소드
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        Map<Integer, Integer> totalTimes = new TreeMap<>();
        Map<Integer, Integer> inTimes = new HashMap<>();

        // 주차 기록을 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            int time = toMinutes(parts[0]);
            int carNumber = Integer.parseInt(parts[1]);
            String status = parts[2];

            if (status.equals("IN")) {
                inTimes.put(carNumber, time); // "IN"일 경우, 입차 시간을 기록
            } else {
                int parkedTime = time - inTimes.get(carNumber); // "OUT"일 경우, 주차 시간을 계산
                totalTimes.put(carNumber, totalTimes.getOrDefault(carNumber, 0) + parkedTime);
                inTimes.remove(carNumber); // 처리된 차량은 "IN" 기록을 제거
            }
        }

        // "IN" 상태로 끝난 차량에 대해서는 23:59에 출차한 것으로 처리
        int endOfDay = toMinutes("23:59");
        for (Map.Entry<Integer, Integer> entry : inTimes.entrySet()) {
            int parkedTime = endOfDay - entry.getValue(); // 23:59까지 주차 시간 계산
            totalTimes.put(entry.getKey(), totalTimes.getOrDefault(entry.getKey(), 0) + parkedTime);
        }

        // 각 차량의 요금을 계산
        List<Integer> result = new ArrayList<>();
        for (int time : totalTimes.values()) {
            if (time <= baseTime) {
                result.add(baseFee); // 기본 시간 이내라면 기본 요금
            } else {
                result.add(baseFee + (int) Math.ceil((double) (time - baseTime) / unitTime) * unitFee); // 초과 시간에 대한 요금 계산
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
