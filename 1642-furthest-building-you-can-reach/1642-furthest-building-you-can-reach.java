class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //max heap
        //it help to get the previous laegest jump taken by using bricks
        PriorityQueue<Integer> jumpsTaken = new PriorityQueue<Integer>((a, b) -> (b - a));
        
        for(int i = 0; i < heights.length - 1; i++){
            int jump = heights[i + 1] - heights[i];
            
            //+ve mean, here we have to use ladder or bricks to move in next building
            if(jump > 0){
                
                //just add jump
                jumpsTaken.add(jump);
                
                //remove bricks, as much needed for this jump
                bricks -= jump;
                
                //-ve bricks, means we are using more as available
                //to fix, we have to user the ladder, where we have maximum brick
                if(bricks < 0){
                    
                    //check ladder is avaivle  
                    if(ladders <= 0) return i;
                    
                    //use a ladder
                    ladders--;
                    
                    //get the maximum jump, which done by bricks
                    int lastMaxJump = jumpsTaken.remove();
                   
                    //now restore the bricks
                    bricks += lastMaxJump;
                    
                }
            }
        }
        
        return heights.length - 1;
    }
}