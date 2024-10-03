import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(arr, target)));
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int required=target-nums[i];
            if(hashMap.containsKey(required)){
                return new int[]{hashMap.get(required),i};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }

//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//
//        }
//        return new int[]{-1,-1};
//    }
}
