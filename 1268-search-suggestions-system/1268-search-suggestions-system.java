class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 1; i <= searchWord.length(); i++){
            String prefix = searchWord.substring(0, i);
            List<String> tmp = new ArrayList<>();
            for(String s: products){
                if(s.startsWith(prefix)){
                    tmp.add(s);
                    if(tmp.size() == 3) break;
                }
            }
            result.add(tmp);
        }
        return result;
    }
}