class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si=0;
        int ei=0;
        int n=nums.length;
        int ans=0;
        int prevc=0;
        while(ei<n){
            if(left<=nums[ei] && nums[ei]<=right){
                prevc=ei-si+1;
                ans+=prevc;
            }else if(nums[ei]<left){
                ans+=prevc;
            }else{
                si=ei+1;
                prevc=0;
            }
            ei++;
        }
        return ans;
    }
}