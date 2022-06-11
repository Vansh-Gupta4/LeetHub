class Solution {
    public int subarraySum(int[] nums, int target) {
        int count=0;
        HashMap <Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int RemainingSum=sum-target;
            if(map.containsKey(RemainingSum)){
                count+=map.get(RemainingSum);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}