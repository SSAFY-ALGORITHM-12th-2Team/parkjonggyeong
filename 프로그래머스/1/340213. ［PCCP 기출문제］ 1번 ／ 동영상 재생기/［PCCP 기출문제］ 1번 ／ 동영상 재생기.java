import java.util.*;
class Solution {
    public String solution(String video_len, String ipos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int total = Integer.parseInt(video_len.split(":")[0])* 60 + Integer.parseInt(video_len.split(":")[1]);
        int pos = Integer.parseInt(ipos.split(":")[0])* 60 + Integer.parseInt(ipos.split(":")[1]);
        int start = Integer.parseInt(op_start.split(":")[0])* 60 + Integer.parseInt(op_start.split(":")[1]);
        int end = Integer.parseInt(op_end.split(":")[0])* 60 + Integer.parseInt(op_end.split(":")[1]);
        
        if(start <= pos && end >= pos){
            pos = end;
        }
        for(int i =0; i < commands.length; i++){
            if(commands[i].equals("prev")){
                pos -= 10;
                if(pos < 10){
                    pos = 0;
                }
            }else{
                pos += 10;
                if(total - pos < 10){
                    pos = total;
                }
            }
             if(start <= pos && end >= pos){
            pos = end;
        }
        }
        answer = String.format("%02d:%02d", pos / 60, pos % 60);
        return answer;
    }
}