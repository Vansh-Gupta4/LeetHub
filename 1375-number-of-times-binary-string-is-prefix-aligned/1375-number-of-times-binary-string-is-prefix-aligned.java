class Solution {
    public int numTimesAllBlue(int[] light) {
        int rightMost=-1;
        int count=0;
        for(int i=0;i<light.length;i++){
            if(light[i]>rightMost){
                rightMost=light[i];
            }
            if(rightMost==i+1){
                count++;
            }
        }
        return count;
    }
}