class Solution {
    public String reverseWords(String s) {
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=' '){
                int j=i;
                while(j+1<arr.length && arr[j+1]!=' '){
                    j++;
                }
                reverse(arr,i,j);
                i=j;
            }
        }
          return new String(arr);
    }
    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}