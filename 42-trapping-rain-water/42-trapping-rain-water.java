class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water=0;
        int l = 0, r = n - 1;
        int maxLeft = 0, maxRight = 0;
        while(l<r){
            if(height[l]<=height[r]){
                if(maxLeft<height[l]){
                    maxLeft=height[l];
                }else{
                    water+=maxLeft-height[l];
                }
                l++;
            }else{
                if(maxRight<height[r]){
                    maxRight=height[r];
                }else{
                    water+=maxRight-height[r];
                }
                r--;
            }
        }
        return water;
    }
}