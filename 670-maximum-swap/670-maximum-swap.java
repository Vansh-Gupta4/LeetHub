class Solution {
    public int maximumSwap(int num) {
        char[] arr=Integer.toString(num).toCharArray();
        
//         Step1. prepare last index of digit
         int[] buckets = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int digit=arr[i] - '0';
            buckets[digit] = i;
        }
        
//         step2. figure out posn for swapping
        boolean flag=false;
        for (int i = 0; i < arr.length; i++) {
            int digit=arr[i] - '0';
            for (int k = 9; k > digit; k--) {
                if (buckets[k] > i) {
//                     then swap and break
                    swap(arr,i,buckets[k]);
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                break;
            }
        }
        
        return Integer.valueOf(new String(arr));
    }
    public static void swap(char[] arr, int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}