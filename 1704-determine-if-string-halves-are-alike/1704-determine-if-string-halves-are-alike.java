class Solution {
    public boolean halvesAreAlike(String s) {
        int firstC=0;
        int secondC=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i<s.length()/2){
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                firstC++;
                }
            }else{
                 if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
               secondC++;
                }
            }
            
        } 
        if(firstC==secondC){
            return true;
        }else{
            return false;
        }
    }
}