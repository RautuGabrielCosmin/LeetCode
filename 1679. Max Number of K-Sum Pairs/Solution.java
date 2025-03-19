class Solution {
    public int maxOperations(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=k)
            nums[i]=0;
        }
        int l =0, r=nums.length-1;
        int ans =0;
        Arrays.sort(nums);
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum == k){
                l++;
                r--;
                ans++;
            }
            else if(sum>k)
            r--;
            else
            l++;
        }
        return ans;
    }
}
