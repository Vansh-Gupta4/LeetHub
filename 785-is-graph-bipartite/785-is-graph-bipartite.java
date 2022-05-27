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
        for (int it: graph[node]) {
            if (color[it] == -1) {
                //Color of variable neighbor is the inverted color of variable node
                color[it] = 1 - color[node];

                if (!validColor(graph, it, color)){
                    return false;
                }
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }
}