import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "10";
        System.out.println(removeKdigits(num, 3));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(i) - '0' < stack.peek() - '0') {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        //   remove remaining elements from last if k>0
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
        //   remove leading zeroes
        while (res.length() > 1 && res.charAt(0) == '0') res.deleteCharAt(0);
        return res.length() == 0 ? "0" : res.toString();

    }
}
