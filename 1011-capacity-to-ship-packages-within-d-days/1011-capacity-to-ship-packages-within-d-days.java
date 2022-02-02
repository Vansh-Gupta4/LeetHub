class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            max=Math.max(max,weights[i]);
        }
        if(weights.length==days){  //matlab fir harr din ek ek package jaayega and max weight hi max capacity of ship honi chaiye
            return max;
        }
        int lo=max;
        int hi=sum;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(isPossible(weights,mid,days)==true){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] wt,int mid,int days){
        int d=1;
        int sum=0;
        for(int i=0;i<wt.length;i++){
            sum+=wt[i];
            if(sum>mid){
                d++;
                sum=wt[i];
            }
        }
        if(d<=days){
            return true;
        }else{
            return false;
        }
    }
}