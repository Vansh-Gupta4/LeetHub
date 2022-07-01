class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int count=0;
        for(int i=0;i<boxTypes.length;i++){
            int numOfBox=boxTypes[i][0];
            int numOfUnits=boxTypes[i][1];
            truckSize-=numOfBox;
            count+=numOfBox*numOfUnits;
            if(truckSize<0){
                count+=truckSize*numOfUnits;
                break;
            }
        }
        return count;
    }
}