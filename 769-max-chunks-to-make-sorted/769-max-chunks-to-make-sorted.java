class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(maxSoFar<arr[i]){
                maxSoFar=arr[i];
            }
            if(maxSoFar==i){
                count++;
            }
        }
        return count;
    }
}