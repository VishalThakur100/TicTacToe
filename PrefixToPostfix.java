import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String s="*-A/BC-/AKL";
        System.out.println(prefixToPostfix(s));
    }

    private static String prefixToPostfix(String s) {
        int i=s.length()-1;
        Stack<String> stack=new Stack<String>();
        while(i>=0){
            char ch=s.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                stack.push(String.valueOf(ch));
            }else{
                String s1=stack.pop();
                String s2=stack.pop();
                stack.push(s1+s2+ch);
            }
            i--;
        }
        return stack.pop();
    }
}
