class Solution {
    String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word:words){
           set.add(getCode(word)); 
        }
        return set.size();
    }
    
    public String getCode(String str){
         StringBuilder sb = new StringBuilder();
        for(char ch:str.toCharArray()){
            int index=ch-'a';
            String code=codes[index];
            sb.append(code);
        }
        return sb.toString();
    } 
}