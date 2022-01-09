class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int pointer1=0;
        int pointer2=0;
        while(pointer1<nums.length){
            if(nums[pointer1]%2==0){
                int temp=nums[pointer1];
                nums[pointer1]=nums[pointer2];
                nums[pointer2]=temp;
                pointer2++;
                pointer1++;
            }else{
                pointer1++;
            }
        }
        return nums;
        
    }
   
}