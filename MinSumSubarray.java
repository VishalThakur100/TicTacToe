import java.util.Arrays;
import java.util.Stack;

public class MinSumSubarray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
//        System.out.println(Arrays.toString(nextSmallestLeft(arr)));
//        System.out.println(Arrays.toString(nextSmallestRight(arr)));
    }

    private static int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int[] NSR = nextSmallestRight(arr);
        int[] NSL = nextSmallestLeft(arr);
        for (int i = 0; i < arr.length; i++) {
            int nsl=(i-NSL[i]);
            int nsr=(NSR[i]-i);
            ans += nsl * nsr;
        }
        return ans;
    }

    private static int[] nextSmallestLeft(int[] arr) {
        int[] num = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            num[i] = stack.isEmpty() ? -1 :stack.peek();
            stack.push(i);
        }
        return num;
    }

    private static int[] nextSmallestRight(int[] arr) {
        int n=arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] num = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            num[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return num;
    }
}
