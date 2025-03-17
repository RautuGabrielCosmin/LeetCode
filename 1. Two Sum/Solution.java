import java.util.Arrays;

public class Solution{

    public int[] TwoSum(int[] nums, int target){
        int[] arr = new int[2];
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        for(int i = 1; i < nums.length; i ++){
            for(int j = i; j < nums.length; j ++){
                if(nums[j] + nums[j - i] == target){
                    arr[0] = j;
                    arr[1] = j-i;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String []args){
        Solution sol = new Solution();
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] out = sol.TwoSum(arr, target);
        System.out.println(Arrays.toString(out));
    }
}
