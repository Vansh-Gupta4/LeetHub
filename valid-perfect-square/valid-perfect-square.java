class Solution {
    public boolean isPerfectSquare(int num) {
         int rem = num%10;
        if(rem == 2 || rem == 3 || rem == 7 || rem == 8){   //Any number which ends with either 2, 3, 7, 8 will not be a perfect square.
             return false;  
        }
        for(int i=1;i<=num;i++){
            if(i*i==num){
                return true;
            }
        }
        return false;
    }
}