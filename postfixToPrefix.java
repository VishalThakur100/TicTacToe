import java.util.Stack;

public class postfixToPrefix {
    public static void main(String[] args) {
        String s="ABC/-AK/L-*";
        System.out.println( PostfixToPrefix(s));
    }

    private static String PostfixToPrefix(String s) {
        Stack<String> stack =new Stack<String>();
        int n=s.length();
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                stack.push(String.valueOf(ch));
            }else{
                String s1=stack.pop();
                String s2=stack.pop();
                stack.push(ch+s2+s1);
            }
            i++;
        }
        return stack.pop();
    }
}
