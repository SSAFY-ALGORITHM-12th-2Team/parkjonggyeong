import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String n;      
    static String bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        bomb = br.readLine();

        String result = removeBombs(n, bomb);

        if (result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }
    }

    private static String removeBombs(String n, String bomb) {
        StringBuilder sb = new StringBuilder(); 
        int bombLength = bomb.length();        

        for (char c : n.toCharArray()) {
            sb.append(c); 

          
            if (sb.length() >= bombLength &&
                    sb.substring(sb.length() - bombLength).equals(bomb)) {
               
                sb.delete(sb.length() - bombLength, sb.length());
            }
        }

        return sb.toString(); 
    }
}
