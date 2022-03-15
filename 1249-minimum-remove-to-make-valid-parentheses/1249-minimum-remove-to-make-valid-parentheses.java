class Solution {
    public String minRemoveToMakeValid(String s) {
        char [] chars=s.toCharArray();
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<chars.length;i++){
            if(s.charAt(i)=='('){
             st.push(i);
            }else if(s.charAt(i)==')'){
               if(st.size()==0){
                   chars[i]='.';
                   
               }else{
                   st.pop();
               }
            }
        }
      
        while(st.size()>0){
            chars[st.pop()]='.';
        }
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            if(c!='.'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}