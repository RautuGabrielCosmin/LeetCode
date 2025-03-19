class Solution {
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (pivot >= y) {
                y *= 10;
            }
            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
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
