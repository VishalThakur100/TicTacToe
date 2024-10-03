import java.util.HashMap;

public class LongestSubStringWRepeatingChar {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int maxLength=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(right))>=left){
                    left=map.get(s.charAt(right))+1;
                }
            }
            map.put(s.charAt(right),right);
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}
