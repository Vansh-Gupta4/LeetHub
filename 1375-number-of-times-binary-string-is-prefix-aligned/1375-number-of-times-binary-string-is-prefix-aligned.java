class Solution {
    public int numTimesAllBlue(int[] light) {
        int rightMostBulbThatIsON=-1;
        int count=0;
        for(int i=0;i<light.length;i++){
            //i+1 is no. of bulbs that you turned ON
            if(light[i]>rightMostBulbThatIsON){
                rightMostBulbThatIsON=light[i];
            }
            if(rightMostBulbThatIsON==i+1){
                count++;
            }
        }
        return count;
    }
}