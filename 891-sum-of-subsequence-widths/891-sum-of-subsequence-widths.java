class Solution {
    public int sumSubseqWidths(int[] nums) {
        long ans=0;
        long mod=1000000007;
        int n=nums.length;
        
        //Pre calculations
        long[] pow=new long[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        
//          Step1->Sort array
        Arrays.sort(nums);
        
//         Step2->Do calc
        for(int i=0;i<nums.length;i++){
            ans=(ans+nums[i]*(pow[i]-pow[n-i-1]))%mod;
        }
        return (int)ans;
    }
}