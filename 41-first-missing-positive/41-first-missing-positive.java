class Solution {
    public int firstMissingPositive(int[] nums) {
//  Step 1-> Mark element which are out of range and check if 1 is present
        boolean IsOnePresent=false;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                IsOnePresent=true;
            }
            if(nums[i]<1 || n < nums[i]){
                nums[i]=1;
            }
        }
        if(IsOnePresent==false){
            return 1;
        }
        
//         Step 2-> Map elements with index
        for(int i=0;i<n;i++){
            int indx=Math.abs(nums[i]);
            nums[indx-1] = -Math.abs(nums[indx-1]);
        }
        
//         Step 3-> Find out missing number
        for(int i=0;i<n;i++){
           if(nums[i]>0){
               return i+1;
           }
        }
        
        return n+1; //agar saare elements present h toh n+1 is answer 
    }
}