class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length() || p.length()==0){
            return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<Integer>();
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> pmap=new HashMap<>();
        
        for(int i=0;i<p.length();i++){  //p ka freq map
            char ch=p.charAt(i);
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        }
        
        for(int i=0;i<p.length();i++){  //first windom ka freq map
            char ch=s.charAt(i);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
        }
        
        if (smap.equals(pmap)) {
            ans.add(0);
        }
        

        for (int i = p.length(); i < s.length(); i++){
            
            char chAcquire=s.charAt(i);
            smap.put(chAcquire,smap.getOrDefault(chAcquire,0)+1);
            
            
            char chRelease=s.charAt(i - p.length());
            int chReleaseCount = smap.get(chRelease);
            if(chReleaseCount==1){
                smap.remove(chRelease);
            }else{
                smap.put(chRelease,chReleaseCount-1);
            }
            if(smap.equals(pmap)) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}