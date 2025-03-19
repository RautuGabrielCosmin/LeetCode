class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Arrays.sort(nums);
		Map<Integer,List<Integer>> map=new HashMap<>();
		List<Integer> list=new ArrayList<>();
	
		int count=1;
		for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
            	if(!list.contains(count))list.add(count);
                if(!map.containsKey(count)) {
                	map.put(count,new ArrayList<>());
                }
                map.get(count).add(nums[i-1]);
                count=0;
            }
            count++;
        }
		if(!list.contains(count))list.add(count);
		if(!map.containsKey(count)) {
        	map.put(count,new ArrayList<>());
        }
		map.get(count).add(nums[nums.length-1]);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		int[] arr=new int[k];
		int i=0;
		for(int num:list) {
			for(int l:map.get(num)) {
				arr[i++]=l;
				if(i==k) {
					break;
				}
			}
			if(i==k) {
				break;
			}
		}
        return arr;
    }
}
