class Solution {
    public int lengthOfLongestSubstring(String S) {
        if(S.length()==0){
            return 0;
        }
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < S.length(); r++){ // outer loop for traversing the string
            char ch=S.charAt(r);
            if (set.contains(ch)){ //if duplicate element is found
                while (l < r && set.contains(ch)) {
                    set.remove(S.charAt(l));
                    l++;
                }
            }
            set.add(ch);
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
}