import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && resultList.size() < k; i--) {
            if (buckets[i] != null) {
                resultList.addAll(buckets[i]);
            }
        }
        resultList = resultList.subList(0, k);
      
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = 2;
        System.out.println("Example 1: " + Arrays.toString(sol.topKFrequent(nums1, k1)));
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Example 2: " + Arrays.toString(sol.topKFrequent(nums2, k2)));
    }
}
