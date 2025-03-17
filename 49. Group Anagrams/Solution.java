import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output1 = sol.groupAnagrams(input1);
        System.out.println("Example 1:");
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + output1);
        
        // Example 2
        String[] input2 = {""};
        List<List<String>> output2 = sol.groupAnagrams(input2);
        System.out.println("\nExample 2:");
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + output2);
        
        // Example 3
        String[] input3 = {"a"};
        List<List<String>> output3 = sol.groupAnagrams(input3);
        System.out.println("\nExample 3:");
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("Output: " + output3);
    }
}
