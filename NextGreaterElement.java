import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        long[] num = {1, 3, 2, 4};
        System.out.println(Arrays.toString(nextLargerElement(num, num.length)));
    }
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        int i = n - 1;
        Stack<Integer> stack = new Stack<>();
        long[] num = new long[arr.length];
        while (i >= 0) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            num[i]=stack.isEmpty()?-1:arr[stack.peek()];
            stack.push(i);
            i--;
        }
        return num;
    }
}