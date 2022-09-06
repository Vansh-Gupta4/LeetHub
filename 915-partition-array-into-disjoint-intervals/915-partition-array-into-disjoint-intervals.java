class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int Leftmax=nums[0];
        int currMax=nums[0];
        
        int pos=0;
        for(int i=1;i<nums.length;i++){
             currMax=Math.max(nums[i],currMax);
             if(Leftmax>nums[i]){
                pos=i;
                 Leftmax=currMax;
            }
        } 
       
       return pos+1;
    }
}