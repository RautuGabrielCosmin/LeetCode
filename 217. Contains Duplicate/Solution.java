public class Solution{
    
    public boolean containsDuplicate(int[] nums){
        int aux;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i - 1]){
                return true;
            }
            aux = nums[i];
            for(int j = i - 2; j >= 0; j --){
                if(nums[j] == aux){
                    return true;
                }    
            }
            nums[i] = nums[i - 1];
            nums[i - 1] = aux;
        }
        return false;
    }
    
    public static void main(String []args){
        Solution sol = new Solution();
        int[]nums = {1,2,3,1};
        int[]nums1 = {1,2,3,4,5,6,7,8,9};
        boolean out = sol.containsDuplicate(nums);
        boolean out1 = sol.containsDuplicate(nums1);
        System.out.println(out);
        System.out.println(out1); 
    }
}
