class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Integer,Character> map=new HashMap<>();
        for(int i=0,j=0;i<key.length();i++){
            if(key.charAt(i)!=' ' && !map.containsKey(key.charAt(i)-'a')){
                map.put(key.charAt(i)-'a',(char)(j+97));
                j++;
            } 
        }
        String ans="";
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)!=' '){
                ans+=map.get(message.charAt(i)-'a');
            }else{
                ans+=" ";
            } 
        }
        return ans;
    }
}