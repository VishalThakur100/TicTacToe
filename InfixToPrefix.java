import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        System.out.println(infixToPrefix("(A–B/C)*(A/K-L)"));
    }
    public static String reverse(String st) {
        int start = 0;
        int end = st.length() - 1;
        char[] str = st.toCharArray();
        while (start < end) {
            char ch = str[end];
            str[end] = str[start];
            str[start] = ch;
            start++;
            end--;
        }
        for (int i = 0; i < str.length; i++) {
            if(str[i]=='('){
                str[i]=')';
            } else if (str[i]==')') {
                str[i]='(';
            }
        }
        String res = new String(str);
        return res;
    }

    public static String infixToPrefix(String st) {
        String res=reverse(st);
        Stack<Character> stack = new Stack<>();
        String ans = "";
        int i = 0;
        while (i < res.length()) {
            char ch = res.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                ans = ans + ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans = ans + stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && Prece(ch) < Prece(stack.peek())) {
                    ans = ans + stack.pop();
                }
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        System.out.println(ans);
        String response=reverse(ans);
        return response;


    }

    public static int Prece(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }
}
