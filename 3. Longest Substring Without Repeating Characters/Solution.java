public class Solution {
    public int lengthOfLongestSubstring(String str) {
        boolean[] map = new boolean[128];
        int left = 0;
        int ans = 0;
        char[] ch = str.toCharArray();
        for (int right = 0; right < str.length(); right++) {
            if (map[ch[right]]) {
                while (left < right && map[ch[right]]) {
                    map[ch[left]] = false;
                    left++;
                }
            }
            map[ch[right]] = true;
            int curr = right - left + 1;
            if (ans < curr)
                ans = curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "abcabcbb";
        int output1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: " + output1);
        System.out.println("Explanation: The answer is \"abc\", with the length of 3.\n");

        // Example 2
        String s2 = "bbbbb";
        int output2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Example 2:");
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Output: " + output2);
        System.out.println("Explanation: The answer is \"b\", with the length of 1.\n");

        // Example 3
        String s3 = "pwwkew";
        int output3 = solution.lengthOfLongestSubstring(s3);
        System.out.println("Example 3:");
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Output: " + output3);
        System.out.println("Explanation: The answer is \"wke\", with the length of 3.");
    }
}
