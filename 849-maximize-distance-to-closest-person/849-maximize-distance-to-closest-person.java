class Solution {
    public int maxDistToClosest(int[] seats) {
//         BRUTE FORCE
        int n=seats.length;
        int[] leftD=new int[n];
        int[] rightD=new int [n];
        int left=1;
        int right=1;
        int last=-1;
        int first=-1;
        boolean flag=true;
        for(int i=0;i<n;i++){
            if(seats[i]==1){
               leftD[i]=0; 
                left=1;
                last=i;
                if(flag==true){
                    first=i;
                    flag=false;
                }
            }else{
                leftD[i]=left;
                left++;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1){
               rightD[i]=0; 
                right=1;
            }else{
                rightD[i]=right;
                right++;
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
          max=Math.max(max,Math.min(leftD[i],rightD[i]));
        }
        if(seats[n-1]==0){
            max=Math.max(max,n-last-1);
        }
         if(seats[0]==0){
            max=Math.max(max,first);
        }
        
        return max;
    }
}