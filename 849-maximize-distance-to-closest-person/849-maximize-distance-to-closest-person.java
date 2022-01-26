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
        
        //leftDist array banaya
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
        
        //rightDist array banaya
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1){
               rightD[i]=0; 
                right=1;
            }else{
                rightD[i]=right;
                right++;
            }
        }
        //ek aur baar traverse karke max nikala
        int max=0;
        for(int i=0;i<n;i++){
          max=Math.max(max,Math.min(leftD[i],rightD[i]));
        }
        
        if(seats[n-1]==0){   //last mai 0 wala case handled
            max=Math.max(max,n-last-1);
        }
        
         if(seats[0]==0){   //starting mai 0 wala case handled
            max=Math.max(max,first);
        }
        
        return max;
    }
}