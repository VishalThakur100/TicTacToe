import java.util.Stack;

public class ValidMinParenthesis {
    public static void main(String[] args) {
        String st="))())(";
//        System.out.println(checkMinValidParent(st));
        System.out.println(checkMinValidParent(st));
    }

    public static int checkMinValidParent(String st){
        Stack<Character> stack=new Stack<>();
        for(char ch:st.toCharArray()){
            if(ch==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                       stack.pop();
                }
                else {
                   stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }
        }

        return stack.size();

    }

}

