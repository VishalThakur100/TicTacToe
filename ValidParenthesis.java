import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String st="(){}[";
        System.out.println(checkValid(st));
    }
    public static boolean checkValid(String st) {

        Stack<Character> stack=new Stack<Character>();
        for(char ch:st.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else{
                if(ch==')'){
                    if(stack.isEmpty()|| stack.pop()!='('){
                        return false;
                    }
                }
                else if(ch=='}'){
                    if(stack.isEmpty()|| stack.pop()!='{'){
                        return false;
                    }
                }
                else{
                    if(stack.isEmpty()|| stack.pop()!='['){
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }
}
