class Solution {
    public List<Integer> spiralOrder(int[][] matrix){ 
        ArrayList<Integer> list=new ArrayList<Integer>();
        int minc=0;
        int minr=0;
        int maxr=matrix.length-1;
        int maxc=matrix[0].length-1;
        int count=0;
        int totalElement=(matrix.length)*(matrix[0].length);
        System.out.println(totalElement);
        while(count<totalElement){
            
            //             top wall
            for(int i=minr,j=minc;j<=maxc && count<totalElement;j++){
                list.add(matrix[i][j]);
                count++;
            }
            minr++;
            
            //             right wall
            for(int i=minr,j=maxc;i<=maxr && count<totalElement;i++){
                list.add(matrix[i][j]);
                count++;
            }
            maxc--;
            
            //             bottom wall
            for(int i=maxr,j=maxc;j>=minc && count<totalElement;j--){
                list.add(matrix[i][j]);
                count++;
            }
            maxr--;
            
            //             left wall
            for(int i=maxr,j=minc;i>=minr && count<totalElement;i--){
                list.add(matrix[i][j]);
                count++;
            }
            minc++;
            
        }
    return list;
    }
}