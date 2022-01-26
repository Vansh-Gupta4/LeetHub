class Solution {
    public int findKthLargest(int[] arr, int k) {
        return quickSelect(arr,0,arr.length - 1,arr.length -k );
    }
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot=arr[hi];
        int pivotIndex=partition(arr,pivot,lo,hi);
        if (k>pivotIndex){
            return quickSelect(arr,pivotIndex+1,hi,k);
        }else if (k<pivotIndex){
            return quickSelect(arr, lo, pivotIndex-1, k);
        }else {
            return arr[pivotIndex];
        }
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
    
    return (j - 1);
  }
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}