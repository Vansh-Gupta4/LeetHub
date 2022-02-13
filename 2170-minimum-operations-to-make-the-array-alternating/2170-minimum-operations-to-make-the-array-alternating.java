class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int[] freqEven=new int[100001];
        int[] freqOdd=new int[100001];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                freqEven[nums[i]]++;                
            }else{
               freqOdd[nums[i]]++;
            }       
            max=Math.max(max,nums[i]);
        }
        int firstMaxEven=0,freqFirstMaxEven=0;
        int firstMaxOdd=0,freqFirstMaxOdd=0;
        
        int secondMaxEven=0,freqsecondMaxEven=0;
        int secondMaxOdd=0,freqsecondMaxOdd=0;
        
        for(int i=1;i<=max;i++){
            
            if(freqEven[i]>=freqFirstMaxEven){
                secondMaxEven=firstMaxEven;
                freqsecondMaxEven=freqFirstMaxEven;
                freqFirstMaxEven=freqEven[i];
                firstMaxEven=i;
                
            }else if(freqEven[i]>freqsecondMaxEven){
                
                freqsecondMaxEven=freqEven[i];
                secondMaxEven=i;
            }
                        
            if(freqOdd[i]>=freqFirstMaxOdd){
                secondMaxOdd=firstMaxOdd;
                freqsecondMaxOdd=freqFirstMaxOdd;
                freqFirstMaxOdd=freqOdd[i];
                firstMaxOdd=i;
                
            }else if(freqOdd[i]>freqsecondMaxOdd){
                
                freqsecondMaxOdd=freqOdd[i];
                secondMaxOdd=i;
            }
            
            
        }
        if(firstMaxEven!=firstMaxOdd){
            return n-freqFirstMaxEven-freqFirstMaxOdd;
        }
        return Math.min((n-freqFirstMaxEven-freqsecondMaxOdd),(n-freqFirstMaxOdd-freqsecondMaxEven));
    }
}