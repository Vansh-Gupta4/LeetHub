class Solution {
    public int lengthOfLongestSubstring(String S) {
        int length = 0;
        HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
        int left = 0,right=0;
        int n=S.length();
        while (right<n){ 
            char rightCh=S.charAt(right);
            if (map.containsKey(rightCh)){ 
                left=Math.max(left,map.get(rightCh) + 1);
            }
            map.put(rightCh,right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}