import java.util.HashSet;

public class Solution2{
    
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
        set.add(num);
        }
        return false;
    }
    
    public static void main(String []args){
        Solution2 sol = new Solution2();
        int[]nums = {1,2,3,1};
        int[]nums1 = {1,2,3,4,5,6,7,8,9};
        boolean out = sol.containsDuplicate(nums);
        boolean out1 = sol.containsDuplicate(nums1);
        System.out.println(out);
        System.out.println(out1); 
    }
}
