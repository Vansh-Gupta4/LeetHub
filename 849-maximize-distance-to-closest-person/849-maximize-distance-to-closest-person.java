class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int recentOne=-1;    
        int maxDist=0;
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                if(recentOne==-1){   //i.e. Case 1
                    maxDist=i;
                }else{    //ie Case 2
                    maxDist=Math.max(maxDist,(i-recentOne)/2);
                }
                recentOne=i;
            }
        }
        
        if(seats[n-1]==0){   //i.e. Vase 3
            maxDist=Math.max(maxDist,n-recentOne-1);
        }
        
        return maxDist;
    }
}