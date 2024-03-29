class Solution {
    public int minPatches(int[] nums, int n) {
        long miss=1;
        int i=0;
        int cnt=0;
        while(miss<=n){
            if(i<nums.length && miss>=nums[i]){
                miss+=nums[i];
                i++;
            }else{
                miss+=miss;
                cnt++;
            }
        }
        return cnt;
    }
}