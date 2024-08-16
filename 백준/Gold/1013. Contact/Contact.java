
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		String reg =  "(100+1+|01)+";
		
		String[] num = new String[T];
		for(int t = 0; t  <T; t++ ) {
			num[t] = br.readLine();
			if(num[t].matches(reg)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		}
	
}
