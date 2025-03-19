import java.util.Arrays;

class Solution{
    public String largestNumber(int[] nums){
        // Convert int array to String array for easy comparison
        String[] numStrs = new String[nums.length];
        for(int i =0; i<nums.length; i++){
            numStrs[i] = String.valueOf(nums[i]);
        }
        
        // Sort the array using a custom comparator with lambda expression
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        
        // If the largest number is "0", return "0"
        if(numStrs[0].equals("0")){
            return "0";
        }
        
        // Build the largest number by concatenating the sorted strings
        StringBuilder ans = new StringBuilder();
        for(String numStr : numStrs){
            ans.append(numStr);
        }
        return ans.toString();
    }
    
    public static void main(String[] args){
        Solution s = new Solution();
        
        // Example 1
        int[] nums1 = {10,2};
        String output1 = s.largestNumber(nums1);
        System.out.println("Example 1 Output: " + output1); // Expected: "210"
        
        // Example 2
        int[] nums2 = {3,30,34,5,9};
        String output2 = s.largestNumber(nums2);
        System.out.println("Example 2 Output: " + output2); // Expected: "9534330"
        
        // Additional Test Cases
        
        // Test Case 3: All zeros
        int[] nums3 = {0,0,0};
        String output3 = s.largestNumber(nums3);
        System.out.println("Test Case 3 Output: " + output3); // Expected: "0"
        
        // Test Case 4: Single element
        int[] nums4 = {1};
        String output4 = s.largestNumber(nums4);
        System.out.println("Test Case 4 Output: " + output4); // Expected: "1"
        
        // Test Case 5: Mixed numbers with similar prefixes
        int[] nums5 = {121,12};
        String output5 = s.largestNumber(nums5);
        System.out.println("Test Case 5 Output: " + output5); // Expected: "12121"
    }
}
