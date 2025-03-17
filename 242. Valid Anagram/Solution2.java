
public class Solution{

    public boolean validAnagram(String s, String t)throws IndexOutOfBoundsException{
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i ++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int count : arr){
            if(count !=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String []args){
        Solution sol = new Solution();
        String s = "mui";
        String t = "mui";
        boolean output = sol.validAnagram(s, t);
        System.out.println(output);

    }
}
