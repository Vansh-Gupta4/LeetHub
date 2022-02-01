class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int lo=matrix[0][0];
        int hi=matrix[n-1][n-1];
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            int count=LessThanEqual(matrix,mid);
            
            if(count<k){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;
    }
    
    public int LessThanEqual(int[][] matrix, int x){
        int cnt = 0, N=matrix.length, i=N-1, j=0;
        //start with bottom left
        while (i >= 0 && j<N){
            if(matrix[i][j]>x){
                i--;
            }else{
               cnt = cnt + i + 1;
               j++;
            }
        }    
        return cnt;
    }
}