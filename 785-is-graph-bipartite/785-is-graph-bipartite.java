class Solution {  //DFS soln
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];	
        for(int i=0;i<colors.length;i++){
            colors[i]=-1;
        }
				
        for (int i = 0; i < n; i++) {   //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == -1) {
                if(!validColor(graph,i,colors)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int node, int[] color) {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=1;
        
        while(!q.isEmpty()){
            int current=q.poll();
            for(int c:graph[current]){
                if(color[c]==-1){
                    color[c]=1-color[current];
                    q.add(c);
                }else if(color[c]==color[current]){
                    return false;
                }
            }
        }
        return true;
    }
}