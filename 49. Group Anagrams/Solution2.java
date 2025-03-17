import java.util.*;

public class Solution{

    public List<List<String>> GroupAnagrams(String[] strs){
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();

        int[] arr = new int[26];

        for(String s : strs){
            Arrays.fill(arr, 0);
            for(char c : s.toCharArray()){
                arr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(arr[i]);
            }
            String key = sb.toString();

            if(map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
