public class BalanceString {
    public static void main(String[] args) {
        String str = "())";
//        System.out.println(minInsertions(str));
        System.out.println(minInsertions2(str));
    }

    public static int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++; // Need an opening parenthesis
                }
            }
        }

        // Remaining opening parentheses need closing ones
        insertions += openCount;

        return insertions;
    }

    public static int minInsertions2(String s) {
        // Initialize a counter for the insertions needed and a counter for open parentheses
        int insertionsCount = 0, openParensCount = 0;
        int n = s.length();

        // Iterate through each character in the string
        for (int i = 0; i < n; ++i) {
            char currentChar = s.charAt(i);

            // If we encounter an open parenthesis, we increment the open parentheses count
            if (currentChar == '(') {
                ++openParensCount;
            } else {
                // Check if the next character is also a close parenthesis
                if (i < n - 1 && s.charAt(i + 1) == ')') {
                    // If it is, we move the index ahead since this is a valid pair of close parentheses
                    ++i;
                } else {
                    // If it's not, we need an extra insertion to complete a pair
                    ++insertionsCount;
                }

                // If there are no open parentheses to match, we need an insertion for an open parenthesis
                if (openParensCount == 0) {
                    ++insertionsCount;
                } else {
                    // Otherwise, we found a matching pair, so decrement the open parentheses count
                    --openParensCount;
                }
            }
        }
        insertionsCount += openParensCount << 1;

        // Return the total number of insertions needed to balance the string
        return insertionsCount;
    }
}