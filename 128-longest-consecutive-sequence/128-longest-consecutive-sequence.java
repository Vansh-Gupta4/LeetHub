class Solution {
   public static int longestConsecutive(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }
        int longestStreak = 0;
        
        for(int num : nums){
            if(!hashSet.contains(num-1)){
               int currNum=num;
                int currStreak=1;
                while(hashSet.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }
                longestStreak=Math.max(longestStreak,currStreak); 
            }else {
                continue;
            }
        }
        return longestStreak;
    }
}