class Solution {
    public int splitArray(int[] nums, int m) {
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        if(nums.length==m){  //matlab fir harr din ek ek package jaayega and max weight hi max capacity of ship honi chaiye
            return max;
        }
        int lo=max;
        int hi=sum;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(isPossible(nums,mid,m)==true){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
     public static boolean isPossible(int[] nums,int mid,int m){
        int d=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                d++;
                sum=nums[i];
            }
        }
        if(d<=m){
            return true;
        }else{
            return false;
        }
    }
}