class Solution {
    public String multiply(String nums1, String nums2) {
        if(nums1.equals("0") || nums2.equals("0")){
            return "0";
        }
        
        int l1=nums1.length();
        int l2=nums2.length();
        int [] res=new int[l1+l2];
        
        int i=l2-1;
        int pf=0;  //pf=powerfactor
        while(i>=0){
            int ival=nums2.charAt(i)-'0';
            i--;
            
            int j=l1-1;
            int k=res.length-1-pf;
            int carry=0;
            
            while(j>=0 || carry!=0){
                int jval= j>=0 ? nums1.charAt(j) -'0' : 0;
                j--;
                
                int prod=ival * jval + carry + res[k];
                
                res[k]=prod%10;
                carry=prod/10;
                k--;
            }
            pf++;
        }
        
//         management to remove leading zeroes from answer
        String str="";
        boolean flag=false;
        for(int val:res){
            if(val==0 && flag==false){
//                 matlab leading zeroes h
                continue;
            }else{
                flag=true;
                str+=val;
            }
        }
        return str;
    }
}