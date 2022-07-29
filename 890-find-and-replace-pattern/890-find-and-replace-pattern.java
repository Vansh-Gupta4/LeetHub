// TC:-O(n*k)
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List <String> ans=new ArrayList<String>();
        for(String word:words){
            if(matches(word,pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
    public static boolean matches(String word,String pattern){
        char[] wordPattern=new char[26];
        char[] patPattern=new char[26];
        for(int i=0;i<word.length();i++){
            char wordChar=word.charAt(i);
            char patternChar=pattern.charAt(i);
            
            if(wordPattern[wordChar-'a']==0){
                wordPattern[wordChar-'a']=patternChar;
            }
            if(patPattern[patternChar-'a']==0){
                patPattern[patternChar-'a']=wordChar;
            }
            
            if(patPattern[patternChar-'a']!=wordChar || wordPattern[wordChar-'a'] !=patternChar){
                return false;
            }
           
        }
         return true;
    }
}