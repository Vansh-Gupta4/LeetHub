class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int i=0;
        int j=arr[0].length-1;
        while(i<arr.length && j>=0){
            if(target==arr[i][j]){
                return true;
            }else if(target<arr[i][j]){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}