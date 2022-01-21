class Solution {
    public int maxProduct(int[] arr) {
        int minprod = arr[0],maxprod = arr[0],result = arr[0],choice1,choice2;
    
    for(int i=1;i<arr.length;i++) {
        choice1=minprod*arr[i];
        choice2=maxprod*arr[i];
        minprod = Math.min(arr[i],Math.min(choice1,choice2));
        maxprod = Math.max(arr[i],Math.max(choice1,choice2));
        
        result = Math.max(result,maxprod);
    }
    return result;
    }
}