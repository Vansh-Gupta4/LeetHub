class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        
        HashMap<Character,Integer> map2=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){  //t ka freq map
            char ch=t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        
        int matchCount=0;
        int DMC=t.length();  //DMC=Desiered Match Count
        
        HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        int i=-1;
        int j=-1;
        while(true){
            boolean f1=false;
            boolean f2=false;
//             acquire 
            while(i<s.length()-1 && matchCount<DMC){
                i++;
                char ch=s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
//agar sahi banda collect kiya toh match count increase kardo
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){ 
                    matchCount++;
                }
                f1=true;
            }
            
//             collect answers and then release
            while(j<i && matchCount==DMC){  //Humare paas answer h par ab uss answer ko chota banane ki koshish kar rhe h 
                String PotenialAns=s.substring(j+1,i+1);
                
                if(ans.length()==0 || PotenialAns.length()<ans.length()){  //collect ans
                    ans=PotenialAns;
                }
                j++;
                char ch=s.charAt(j);
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }
                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){ 
                    matchCount--;
                }
                f2=true;
            }
            if(f1==false && f2==false){
                break;
            }
        }
        return ans;
    }
}