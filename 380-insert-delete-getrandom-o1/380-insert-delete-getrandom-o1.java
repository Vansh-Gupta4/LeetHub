class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        r=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int removeIdx=map.get(val);
        map.remove(val);  //map se remove
        
        if(removeIdx==list.size()-1){  //agar last ele of list remove karna h toh
            list.remove(list.size()-1);
            return true;
        }
        
        //otherwise, overwrite the value
        list.set(removeIdx,list.get(list.size()-1));
        //and remove last element
        list.remove(list.size()-1);
        //map mai update kardo
        map.put(list.get(removeIdx),removeIdx);
        return true;
        
    }
    
    public int getRandom() {
        int randomIdx = r.nextInt(list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */