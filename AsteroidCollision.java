import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {2,-1,3,-7};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }

    public static int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : arr) {
            boolean destroy = false;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                    destroy = true;
                    break;
                } else {
                    destroy = true;
                    break;
                }
            }
            if (!destroy) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}
