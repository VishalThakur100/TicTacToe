import java.util.HashMap;
import java.util.Map;

public class binarySubarraysWithSum {
    public static void main(String[] args) {
        int[] arr={1,0,1,0,1};
        System.out.println( numSubarraysWithSum(arr,2));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - goal)) {
                count += prefixSumCount.get(sum - goal);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
