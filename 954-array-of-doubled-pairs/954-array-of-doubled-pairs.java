class Solution {
    public boolean canReorderDoubled(int[] arr) {
         int target;
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        for(int el: map.keySet()){
            if(map.get(el)==0){
                continue;
            }
            if(el<0){
                target=el/2;
            }else{
                target=el*2;
            }
            
            //odd and -ve check
            if(el<0 && el%2!=0){
                return false;
            }
            
            if(map.get(el) > map.getOrDefault(target,0)){
                return false;
            }
            map.put(target,map.get(target)-map.get(el));
        }
        return true;
    }
}