class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        char[] arr=new char[n+2];
//         Step1-> Add dummy dominoes
        arr[0]='L';
        arr[n+1]='R';
//         Step2-> Array formm karliya
        for(int i=1;i<arr.length-1;i++){
            arr[i]=dominoes.charAt(i-1);
        }
//         Step3->Segments divide karliye
        int j=0;
        int k=1;
        while(k<arr.length){
            while(arr[k]=='.'){  //jaise hi yeh loop ruka...segment mil gya
                k++;
            }
            if(k-j>1){
               SolveSegment(arr,j,k);   
            }
            // To find next segment
            j=k;
            k++;
        }
//         Step4->Convert to string
        //method 1(as string is immutabele..therefore it increases TC...therefore TLE occurs)
        // String res="";
        // for(int i=1;i<arr.length-1;i++){
        //     res+=arr[i];
        // }
        //Method 2(stringBuilder)
        StringBuilder res=new StringBuilder();
         for(int i=1;i<arr.length-1;i++){
            res.append(arr[i]);
        }
        return res.toString();
    }
    public static void SolveSegment(char[] arr, int i,int j){
        if(arr[i]=='L' && arr[j]=='L'){        //make all dots to L   
            for(int k=i+1;k<j;k++){
                arr[k]='L';
            }
        }else if(arr[i]=='R' && arr[j]=='R'){        // make all dots to R  
            for(int k=i+1;k<j;k++){
                arr[k]='R';
            }
        }else if(arr[i]=='L' && arr[j]=='R'){
        //     Nothing to do        
        }else{//    solve acc to count of dots    
            int diff=j-i;
            int mid=(i+j)/2;
            if(diff%2==0){  //means count of dots are odd
                for(int k=i+1;k<mid;k++){
                    arr[k]='R';
                }
                for(int k=mid+1;k<j;k++){
                    arr[k]='L';
                }
            }else{      //means count of dots are even
                for(int k=i+1;k <= mid;k++){
                    arr[k]='R';
                }
                for(int k=mid+1;k<j;k++){
                    arr[k]='L';
                }
            }
        }
    }
}