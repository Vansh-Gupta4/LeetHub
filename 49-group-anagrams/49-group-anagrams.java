class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList> bigMap=new HashMap<>();
        
        
        for(String str:strs){
            HashMap<Character,Integer> freqMap=new HashMap<>();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
            }
             if(bigMap.containsKey(freqMap)==false){
                 ArrayList<String> list=new ArrayList<>();
                 list.add(str);
                 bigMap.put(freqMap,list);
             }else{
                 ArrayList<String> list = bigMap.get(freqMap);
                 list.add(str);
             }
        }
       
//         preparing ans
        List<List<String>> ans= new ArrayList<>();
        for(List<String> val : bigMap.values()){
            ans.add(val);
        }
        return ans;
    }
}