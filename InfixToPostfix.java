import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String st = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(st));
    }

    public static String infixToPostfix(String st) {
        // Your code here
        Stack<Character> stack = new Stack<>();
        String ans = "";
        int i = 0;
        while (i < st.length()) {
            char ch = st.charAt(i);
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
                while (!stack.isEmpty() && Prece(ch) <= Prece(stack.peek())) {
                    ans = ans + stack.pop();
                }
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }

    public static int Prece(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}
