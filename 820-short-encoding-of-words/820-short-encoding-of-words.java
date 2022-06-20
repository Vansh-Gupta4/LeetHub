class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        String res="";
        if(words.length==0){
            return 0;
        }
        res=res+words[0]+"#";
      
        for(int i=1;i<words.length;i++){
            if(res.contains(words[i]+"#")){
                continue;
            }else{
                res=res+words[i]+"#";
            }
               
        }
                 System.out.println(res);
        return res.length();
    }
}