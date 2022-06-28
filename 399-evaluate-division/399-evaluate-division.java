class Solution {
    class Edge {
        String src;
        String nbr;
        double wt;
        Edge(String src,String nbr,double wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
  public  double ans;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String,ArrayList<Edge>> graph=new HashMap<>();
        int i=0;
        for(List<String> eq:equations){
            String s=eq.get(0);
            String n=eq.get(1);
            double w=values[i];
            i++;
            Edge e=new Edge(s,n,w);
            Edge e2=new Edge (n,s,1/w);
            if(graph.containsKey(s)){
                 ArrayList<Edge> al=graph.get(s);
                al.add(e);
            graph.put(s,al);
            }else{
                  ArrayList<Edge> al=new ArrayList<>();
                al.add(e);
                     al.add(new Edge(s,s,1.0));
            graph.put(s,al);
            }
            
              if(graph.containsKey(n)){
                 ArrayList<Edge> al=graph.get(n);
                
                al.add(e2);
            graph.put(n,al);
            }else{
                  ArrayList<Edge> al=new ArrayList<>();
                       al.add(new Edge(n,n,1.0));
                al.add(e2);
            graph.put(n,al);
            }
           
        }
       //graph done
        
        //call dfs for each query 
        //src || nbr doesnt exist --> -1.0
        // src==dest return 1.0
        double[] arr=new double[queries.size()];
        int cnt=0;
        for(List<String> q:queries){
        String s=q.get(0);
            String d=q.get(1);
         ans=-1.0;
        if( graph.containsKey(s)==false || graph.containsKey(d)==false){
              arr[cnt++]=ans;
            continue;
        }
            if( s.equals(d)){
                    arr[cnt++]=1.0;
            continue;
            }
       HashSet<String> map=new HashSet<>();
        dfs(graph,s,d,1,map);
        arr[cnt++]=ans;
    
    }
        return arr;
    }
     public    void dfs(HashMap<String,ArrayList<Edge>> graph,String s,String d,double prev,HashSet<String> map){
            if(s.equals(d)){
                ans=prev;
                return;
            }
            map.add(s);
            for(Edge e:graph.get(s)){
                if(map.contains(e.nbr))continue;
                dfs(graph,e.nbr,d,prev*e.wt,map);
            }
        }
}