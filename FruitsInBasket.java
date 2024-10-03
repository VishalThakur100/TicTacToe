import java.util.HashMap;

public class FruitsInBasket {
    public static void main(String[] args) {
        Integer[] arr = {3, 1, 2, 2, 2, 2};
        System.out.println(totalFruits(arr));
    }

    public static int totalFruits(Integer[] arr) {
        // code here
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int maxLen = 0;
        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            if (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}
