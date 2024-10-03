import java.util.Stack;

public class SumSubArrayranges {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(subArrayRanges(arr));
    }
    public static int subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
    public static int sumSubarrayMins(int[] arr) {
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

    public static int[] nextSmallestLeft(int[] arr) {
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

    public static int[] nextSmallestRight(int[] arr) {
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

    public static int[] nextLargestLeft(int[] arr) {
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

    public static int[] nextLargestRight(int[] arr) {
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
