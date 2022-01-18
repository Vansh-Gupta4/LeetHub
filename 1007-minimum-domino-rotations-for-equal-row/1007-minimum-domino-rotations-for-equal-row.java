class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1=0, count2=0, count3=0, count4=0;
        int nums1=tops[0];
        int nums2=bottoms[0];
        
        for(int i=0;i<tops.length;i++){
//      For Num1
//             count1->Min swapping reqd to make top array as num1
            if(count1!=Integer.MAX_VALUE){
                if(tops[i]==nums1){
//                     do nothing
                }else if(bottoms[i]==nums1){
                    count1++;
                }else{
                    count1=Integer.MAX_VALUE;
                }
            }
            
//             count2->Min swapping reqd to make bottom array as num1
            if(count2!=Integer.MAX_VALUE){
                if(bottoms[i]==nums1){
//                     do nothing
                }else if(tops[i]==nums1){
                    count2++;
                }else{
                    count2=Integer.MAX_VALUE;
                }
            }
            
//        For num2
//             count3->Min swapping reqd to make top array as num2
            if(count3!=Integer.MAX_VALUE){
                if(tops[i]==nums2){
//                     do nothing
                }else if(bottoms[i]==nums2){
                    count3++;
                }else{
                    count3=Integer.MAX_VALUE;
                }
            }
            
//             count4->Min swapping reqd to make bottom array as num2
            if(count4!=Integer.MAX_VALUE){
                if(bottoms[i]==nums2){
//                     do nothing
                }else if(tops[i]==nums2){
                    count4++;
                }else{
                    count4=Integer.MAX_VALUE;
                }
            }
        }
        int res=Math.min(Math.min(count1,count2),Math.min(count3,count4));
        return res==Integer.MAX_VALUE?-1:res;
    }
}