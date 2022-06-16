class Solution {
    public int numRabbits(int[] answers) {
        if(answers.length == 0){
            return 0;  
        } 
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        
        //For each rabbits answer
        for(int i=0; i<answers.length;i++){
            if(answers[i] == 0 ){
                sum += 1;
                continue;
            }
            if(!map.containsKey(answers[i])){
                //If we haven't accounted for this rabbit color then account for the one telling us
                // as well as the one that rabbit says is that color.
                map.put(answers[i], 0);
                sum += (answers[i] + 1);
                
            }else{
                map.put(answers[i], map.get(answers[i]) + 1);
                //if there are k of each color then they are all present, remove them to allow the change to account for others.
                if(map.get(answers[i]) == answers[i]){ 
                    map.remove(answers[i]);
                }
            }
            
        }
        return sum;
    }
}