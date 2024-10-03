import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String s = "ab*c+";
        System.out.println(postfixToInfix(s));
    }

    private static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                stack.push(String.valueOf(ch));
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push('(' + s2 + ch + s1 + ')');
            }
            i++;
        }
        return stack.peek();
    }
}
