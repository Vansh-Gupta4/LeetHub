class Solution {
    public int maximum69Number (int num) {
        String str=Integer.toString(num);
        String ans="";
        boolean check= false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='9'){
                ans=str.substring(0,i)+'9'+str.substring(i+1,str.length());
                check=true;
                 break;
            }
        }
        if(check==false){
            return num;
        }else{
            return Integer.parseInt(ans);
        }
        
    }
}