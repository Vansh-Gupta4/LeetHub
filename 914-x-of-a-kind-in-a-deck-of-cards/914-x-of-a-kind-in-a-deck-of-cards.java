class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<deck.length;i++){
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }
        int ans=0;
        for(int i:map.values()){
            ans = gcd(i, ans);
        }
        if(ans>1){
            return true;
        }else{
            return false;
        }
    }
    
     public int gcd(int a, int b) {
         if(b==0){
             return a;
         }
        return gcd(b, a % b);
    }
}