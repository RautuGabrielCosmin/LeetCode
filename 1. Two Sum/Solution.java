import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        int i,j;
        for(i=1;i<nums.length;i++){
            for(j=i;j<nums.length;j++){
                if(nums[j]+nums[j-i]==target){
                    arr[0]=j;
                    arr[1]=j-i;
                    return arr;
                }
            }
        }
        return arr;
    }
    public static void main(String [] args)
    {
        Solution solution = new Solution();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Example 1: Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1));
    }
}
