class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int lo=1;
        int hi=max;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(nums,mid,threshold)==true){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
     return ans;
    }
    public static boolean isPossible(int nums[], int k, int h){
        int sum = 0;
        for(int num : nums){
            int div = num / k;
            sum += div;
            if(num % k != 0) sum++;
        }
        return sum <= h;
    }
}