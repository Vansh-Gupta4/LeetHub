class Solution {
    public String reversePrefix(String word, char ch) {
        char[] c = word.toCharArray();
        int right=0;
        for(int i=0;i<word.length();i++){
            if(ch==c[i]){
                right=i;
                break;
            }
        }
        char[] res = new char[word.length()];
        for (int i = 0; i <= right; i++) {
            res[i] = c[right - i];
        }
        for (int i = right + 1; i < word.length(); i++) {
            res[i] = c[i];
        }
        return String.valueOf(res);
    }
}