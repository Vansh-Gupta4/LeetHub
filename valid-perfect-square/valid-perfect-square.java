class Solution {
    public boolean isPerfectSquare(int num) {
        int i;
        int rem = num%10;
        if(rem == 2 || rem == 3 || rem == 7 || rem == 8){   //Any number which ends with either 2, 3, 7, 8 will not be a perfect square.
             return false;  
        }
        for(i=1; i*i<num; i++){
        }
            return (i*i == num);
    }
}