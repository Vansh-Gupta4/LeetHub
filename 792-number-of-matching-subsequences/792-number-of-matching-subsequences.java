class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        Map<Character, List<Node>> map = new HashMap<>();
        
        for (String word: words){
            char ch = word.charAt(0);
            map.putIfAbsent(ch, new LinkedList<>());
            map.get(ch).add(new Node(word,0));
        }
           
        for (char c: s.toCharArray()) {
            
            if(!map.containsKey(c)) continue;
    
            List<Node> list = map.get(c);
            map.put(c, new LinkedList<>());
            
            for (Node node: list) {
                node.index++;
                if (node.index == node.str.length()) {
                    res++;
                } else {
                    char ch = node.str.charAt(node.index);
                    map.putIfAbsent(ch, new LinkedList<>());
                    map.get(ch).add(node);
                }
            }
        }
        return res;
    }
    
    class Node{
        String str;
        int index;
        Node(String s,int idx){
            str = s;
            index = idx;
        }
    }
}