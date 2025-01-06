import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        String infix = br.readLine();

        String postfix = change(infix);

        System.out.println(postfix);
    }

    private static String change(String infix) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && op(st.peek()) >= op(c)) {
                    sb.append(st.pop());
                }
                st.push(c);

            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    static int op(char oper) {
        switch (oper) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;

            case '(':
                return 0;
            default:
                return -1;
        }
    }
}
