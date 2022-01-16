class Solution {
    public boolean uniqueOccurrences(int[] arr) {
          Map <Integer, Integer> map = new HashMap(); // Set hashMap in order to assign keys and values to the given array.
        
        HashSet <Integer> set = new HashSet(); // Set HashSet in order to check unique occurrences of array values.
                
        for(int uniqElement : arr){ // Check each element in the array for it's uniqness.
            if(map.containsKey(uniqElement)){ // If the element is already found..
                map.put(uniqElement, map.get(uniqElement)+1); //update its quantity.
            }else{
                map.put(uniqElement, 1); // Else add it as a new element.
            }
        }
		
        for(int element : map.values()){ // When the process of adding is done, foreach the map's values and add them to the HashSet beacuse we only need the value of each key.
        
            set.add(element);
        }
        
        if(set.size() == map.size()){
            // Iterating over this set requires time proportional to the sum of the HashSet instance's size (the number of elements), 
		                            //so if the size of the HashSet equals to the size of HashMap, and knowing that HashMap keeps only uniqe keys, we can deduce that all of the occrrences are uniqe.
            return true;
        }else{
            return false;
        }
    }
}