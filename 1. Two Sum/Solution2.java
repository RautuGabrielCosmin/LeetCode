import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution{

    public int[] TwoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            int result = target - nums[i];

            if(map.containsKey(result)){
                return new int[]{map.get(result), i};
            }
        map.put(nums[i],i);
        }
    return new int[] {};
    }

    public static void main(String []args){
        Solution sol = new Solution();
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] out = sol.TwoSum(arr, target);
        System.out.println(Arrays.toString(out));
    }
}
