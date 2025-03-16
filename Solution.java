public class Solution{

    public boolean containsDuplicate(int[] nums){
        int temp;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i - 1] == nums[i])
                return true;
        
        temp = nums[i];
            for(int j = i - 2; j >=0; j ++){
                    if(nums[j] == temp)
                        return true;
                }
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
        }
        return false;
    }


    public static void main(String [] args){
        Solution sol = new Solution();
        int[] nums = {1,2,3,1};
        boolean out = sol.containsDuplicate(nums);
        System.out.println(out);
    }
}