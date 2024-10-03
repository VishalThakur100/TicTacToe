import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr={1,3,-3,1,0,5,2,7,6};
        int k=3;
        System.out.println(Arrays.toString(slidingWindowMaximum(arr,k)));
    }

    private static int[] slidingWindowMaximum(int[] arr, int k) {

        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements as they won't be the maximum
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current element's index
            deque.offerLast(i);

            // Add the maximum of the current window to the result
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result.stream().mapToInt(Integer ::intValue ).toArray();
    }
}
