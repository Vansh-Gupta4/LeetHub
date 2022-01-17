class Solution {
    public int reachNumber(int n) {
         n = Math.abs(n);
        int jumps=1;
        int sum=0;
        while(sum<n){
            sum+=jumps;
            jumps++;
        }
        if((sum-n)%2==0){
            return jumps-1;
        }else if((sum+jumps-n)%2==0){
            return jumps;
        }else{
            return jumps+1;
        }
    }
}