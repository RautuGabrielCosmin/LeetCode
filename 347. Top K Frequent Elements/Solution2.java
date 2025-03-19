class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        int[] freq = new int[max - min + 1];

        for (int n : nums) {
            freq[n - min]++;
        }

        ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];

        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (freqArr[freq[i]] == null) {
                    freqArr[freq[i]] = new ArrayList<Integer>();
                }
                freqArr[freq[i]].add(i + min);
            }
        }
        
        int[] res = new int[k];

        int kk = 0;
        for (int i=freqArr.length-1; i>=0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    res[kk] = freqArr[i].get(j);
                    kk++;

                    if (kk >= k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
  
  public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = 2;
        System.out.println("Example 1: " + Arrays.toString(sol.topKFrequent(nums1, k1)));
        
        // Example 2:
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Example 2: " + Arrays.toString(sol.topKFrequent(nums2, k2)));
    }
}
