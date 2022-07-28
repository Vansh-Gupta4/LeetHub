class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length()!=t.length()){
            return false;
        }
        int [] characters=new int[26];
        for (char ch : s.toCharArray()) {
            characters[ch - 'a']++; //
        }
        for (char ch : t.toCharArray()) {
            characters[ch - 'a']--; //
        }
        for (int count:characters) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}