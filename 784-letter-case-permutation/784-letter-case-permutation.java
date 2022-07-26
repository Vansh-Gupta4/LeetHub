class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<String>();
        String op="";
        permute(s,op,ans);
        return ans;
    }
    public static void permute(String ip,String op, List<String> ans ){
        if(ip.length()==0){
            ans.add(op);
            return;
        }
        if(Character.isAlphabetic(ip.charAt(0))){
            String op1=op;
            String op2=op;
            op1+=ip.substring(0,1).toLowerCase();
			op2+=ip.substring(0,1).toUpperCase();
            permute(ip.substring(1),op1,ans);
            permute(ip.substring(1),op2,ans);
        }else{
            String op1=op;
            op1+=ip.substring(0,1);
            permute(ip.substring(1),op1,ans);
        }
    }
}