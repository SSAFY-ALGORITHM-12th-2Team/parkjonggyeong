import java.util.*;

class Solution {
    static String users[];
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        Map<String, List<String>> mine = new HashMap<>();
        Map<String, Integer> dec = new HashMap<>();
        
        for(String id : id_list){
            mine.put(id, new ArrayList<>());
            dec.put(id, 0);
        }
        
        for(String r : report){
            String[] users = r.split(" ");
            String me = users[0];
            String you = users[1];
            if (!mine.get(me).contains(you)) {
                mine.get(me).add(you);
                dec.put(you, dec.get(you) + 1);
            }
            
        }
        List<String> stopUser = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dec.entrySet()) {
            if (entry.getValue() >= k) {
                stopUser.add(entry.getKey());
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            int count = 0;
            for (String reportedUser : mine.get(user)) {
                if (stopUser.contains(reportedUser)) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
       
    
}
