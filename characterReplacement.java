import java.util.HashMap;
import java.util.Map;

public class characterReplacement {
    public static void main(String[] args) {
        String st="AABABBA";
        System.out.println(characterReplacement(st,1));
    }
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Array to count character frequencies
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            count[s.charAt(right) - 'A']++; // Increment count for current character
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']); // Update max frequency

            if ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--; // Decrement count for left character
                left++; // Move left pointer
            }

            maxLen = Math.max(maxLen, right - left + 1); // Update max length
            right++; // Move right pointer
        }

        return maxLen;
    }
}
