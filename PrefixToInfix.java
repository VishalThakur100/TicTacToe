import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println( prefixToInfix(s));
    }

    private static String prefixToInfix(String s) {
        int i = s.length() - 1;
        Stack<String> stack = new Stack<String>();
        while (i >= 0) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                stack.push(String.valueOf(ch));
            } else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push('(' + s1 + ch + s2 + ')');
            }
            i--;
        }
        return stack.peek();
    }
}
