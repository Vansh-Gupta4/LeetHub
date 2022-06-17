class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=1;
        int count=1;
        for(Integer val : map.keySet()){
            System.out.println(val);
            if(map.containsKey(val+1)){
                count++;
                max=Math.max(max,count);
            }else{
                count=1;
            }
        }
        return max;
    }
}