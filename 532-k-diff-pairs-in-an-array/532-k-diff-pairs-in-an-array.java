class Solution {
   public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
       int i=0;
       int j=1;
       int count=0;
       while(i<nums.length && j<nums.length){
           if(Math.abs(nums[i]-nums[j])==k){
               count++;
               i++;
               j++;
               while(j<nums.length && nums[j]==nums[j-1]){ //to avoid duplicates
                   j++;
               }
           }else if(Math.abs(nums[i]-nums[j])>k){
               i++;
               if(i==j){
                   j++;
               }
           }else{
               j++;
           }
       }
       return count;
    }
}