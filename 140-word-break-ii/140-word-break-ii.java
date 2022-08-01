class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new ArrayList<String>();
        String ans="";
        int n=s.length();
        wordBreakUtil(n, s, wordDict, ans,res);
        return res;
    }
    
  public static void wordBreakUtil(int n, String s, List<String> dict, String ans,List<String> res){
    for(int i = 1; i <= n; i++){
 
      // Extract substring from 0 to i in prefix
      String prefix=s.substring(0, i);
 
      // If dictionary contains this prefix, then
      // we check for remaining string. Otherwise
      // we ignore this prefix 
      if(dict.contains(prefix)){  // If no more elements are there, print it
        if(i == n){   // Add this element to previous prefix
            ans += prefix;
            res.add(ans);
            return;
        }
        wordBreakUtil(n - i, s.substring(i,n), dict, ans+prefix+" ",res);
      }
    }
  }
}