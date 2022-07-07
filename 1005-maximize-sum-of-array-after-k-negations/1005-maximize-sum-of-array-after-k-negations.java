class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
         for(int i=1;i<=k;i++){
             int min=Integer.MAX_VALUE;
             int idx=-1;
             for(int j=0;j<arr.length;j++){
                 if(min>arr[j]){
                    min=arr[j];
                    idx=j;
                }
             }
             if(min==0){
                 break;
             }
             arr[idx]=-arr[idx];
         }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
}