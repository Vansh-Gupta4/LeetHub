class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        char[] str = s.toCharArray();
        while(i<j){
            if(isVowel(str[i]) && isVowel(str[j])){
                swap(str,i++,j--);
            } 
            if(!isVowel(str[i])){
              i++;  
            } 
            if(!isVowel(str[j])){
              j--;  
            } 
        }
        return String.valueOf(str);
    }
    
    void swap(char[] str,int i, int j){
        char temp = str[i];
        str[i]= str[j];
        str[j]=temp;
    }
    
    boolean isVowel(char x){
        x = Character.toLowerCase(x);
        if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') return true;
        return false;
    }
    
}