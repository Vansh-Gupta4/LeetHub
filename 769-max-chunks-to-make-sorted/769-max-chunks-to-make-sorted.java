class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar=0;
        int count=0;
        for(int i=0;i<arr.length;i++){      
            maxSoFar=Math.max(arr[i],maxSoFar);  
            if(maxSoFar==i){
                count++;
            }
        }
        return count;
    }
}