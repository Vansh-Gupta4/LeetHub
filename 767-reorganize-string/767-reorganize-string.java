class Solution {
    public String reorganizeString(String S) {
         // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        
         //Make a priority queue and build a max heap based on the char count
         PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(map.size(), (entry1,entry2) -> entry2.getValue()-entry1.getValue());
        maxHeap.addAll(map.entrySet());
        
        char[] result = new char[S.length()];
        Map.Entry<Character,Integer> entry = null;
        int count=0;
        char key = '\0';
        //Start building the result with indexes as 0, 2, 4, 6..
        //Once even numbers are exhausted, start it from 1,3,5...
        int index=0;
        while(!maxHeap.isEmpty()) {
            entry = maxHeap.poll();
            count = entry.getValue();
            key = entry.getKey();
            while(count-->0) {
                result[index] = key;
                index += 2;
                if(index>=S.length()) index=1;
            }
        }
        return String.valueOf(result);
    }
}