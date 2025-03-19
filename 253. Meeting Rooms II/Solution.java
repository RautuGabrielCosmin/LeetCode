class Solution {
    public static void radixSort(int[] array) {
        int max = getMax(array); // Find the maximum value to know the number of digits
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Output array for sorting
        int[] count = new int[10]; // There are 10 possible digits (0 to 9)

        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Update count[i] so it contains the actual position of the digit in the output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copy the output array back to the original array
        System.arraycopy(output, 0, array, 0, n);
    }
    
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        radixSort(start);
        radixSort(end);

        int maxRooms = 0;
        for (int idxStart = 0, idxEnd = 0; idxStart < intervals.length; idxStart++) {
            if (start[idxStart] < end[idxEnd]) {
                maxRooms++;
            } else {
                idxEnd++;
            }
        }
        return maxRooms;
    }
}
/*
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int usedRooms = 0;
        for (int idxStart = 0, idxEnd = 0; idxStart < intervals.length; idxStart++){
                if (startTimes[idxStart] < endTimes[idxEnd]){
                    usedRooms++;
                } else{
                    idxEnd++;
                }
        }
        return usedRooms;
    }
}
---------------------------------------------------------------------------------
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] arr = new int[n];
        int[] dep = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = intervals[i][0];
            dep[i] = intervals[i][1];
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int l=0;
        int r=0;
        int cnt =0;
        int ans =0;
        while(l<n && r<n){
            if(arr[l]<dep[r]){
                cnt++;
                l++;
            }else{
                cnt--;
                r++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;        
    }
}
----------------------------------------------------------------------------------------

*/
