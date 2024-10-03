import java.util.Stack;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr={3,1,2,5};
        System.out.println( sumSubarrayMax(arr));
    }
    public static int sumSubarrayMax(int[] arr) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        int[] NLR = nextLargestRight(arr);
        int[] NLL = nextLargestLeft(arr);
        for (int i = 0; i < arr.length; i++) {
            long nsl = i - NLL[i];
            long nsr = NLR[i] - i;
            ans = (ans + (nsl * nsr * arr[i]) % MOD) % MOD;
        }
        return (int) ans;
    }

    private static int[] nextLargestLeft(int[] arr) {
        int[] num = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            num[i] = stack.isEmpty() ? -1 :stack.peek();
            stack.push(i);
        }
        return num;
    }

    private static int[] nextLargestRight(int[] arr) {
        int n=arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] num = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            num[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return num;
    }
}
