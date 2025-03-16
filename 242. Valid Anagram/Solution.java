import java.util.Arrays;

public class Solution{

    public boolean validAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2)) return true;
        return false;
    }

    public static void main(String []args){
        Solution sol = new Solution();
        String s = "MUI";
        String t = "M`";
        boolean output = sol.validAnagram(s, t);
        System.out.println(output);

    }
}
