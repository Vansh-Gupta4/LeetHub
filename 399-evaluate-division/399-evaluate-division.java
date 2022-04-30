class Solution {
    double dfs(HashMap<String,HashMap<String,Double>>adj,String a,String b,HashSet<String>s){
        s.add(a);
        double res=-1.0,val=-1.0;
        for(Map.Entry<String,Double>entry:adj.get(a).entrySet()){
            if(b.equals(entry.getKey())) return entry.getValue();
            if(!s.contains(entry.getKey()))
                val=dfs(adj,entry.getKey(),b,s);
            if(val!=-1.0){ 
                res=entry.getValue()*val;
                break;
            }
        }
        return res;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n=equations.size(),m=queries.size();
        double res[]=new double[m];
        HashMap<String,HashMap<String,Double>>adj=new HashMap<>();
        for(int i=0;i<n;++i){
            String f=equations.get(i).get(0);
            String s=equations.get(i).get(1);
            if(f.equals(s)) continue;
            adj.putIfAbsent(f,new HashMap<>());
            adj.putIfAbsent(s,new HashMap<>());
            adj.get(f).put(s,values[i]);
            adj.get(s).put(f,1/values[i]);
        }
        for(int i=0;i<m;++i){
            HashSet<String>s=new HashSet<>();
            if(!adj.containsKey(queries.get(i).get(0)) || !adj.containsKey(queries.get(i).get(1))) res[i]=-1.0;
            else if(queries.get(i).get(0).equals(queries.get(i).get(1))) res[i]=1.0;
            else res[i]=dfs(adj,queries.get(i).get(0),queries.get(i).get(1),s);
        }
        return res;
    }
}