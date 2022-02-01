class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3=new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
            nums3[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            nums3[i+nums1.length]=nums2[i];
        }
        Arrays.sort(nums3);
        // for(int i=0;i<nums3.length;i++){
        //    System.out.print(nums3[i]+" ");
        // }
        double ans=0;
        if(nums3.length%2==0){
            ans=(double)(nums3[(nums3.length)/2]+nums3[(nums3.length)/2-1])/2;
        }else{
            ans=nums3[(nums3.length)/2];
        }
        
        return ans;
    }
}