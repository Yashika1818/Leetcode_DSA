class Solution {
    //as least number of buses have asked --> bfs
    class Pair{
        int bus;
        int cnt;
        Pair(int bus,int cnt){
            this.bus=bus;
            this.cnt=cnt;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)return 0;
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int bus=0;bus<routes.length;bus++){
            for(int stop:routes[bus]){
                if(hm.containsKey(stop)){
                    ArrayList<Integer> al=hm.get(stop);
                    al.add(bus);
                    hm.put(stop,al);
                }else{
                    ArrayList<Integer> al=new ArrayList<>();
                    al.add(bus);
                    hm.put(stop,al);
                }
            }
        }
        boolean[] visited=new boolean[routes.length];
        ArrayList<Integer> sourcebus=hm.get(source);
        Queue<Pair> q=new LinkedList<>();
        for(int s:sourcebus){
            q.add(new Pair(s,1));
        }
        while(q.size()>0){
            //remove
            Pair rem=q.remove();
            int b=rem.bus;
            //mark*
            if(visited[b]==true)continue;
            else
                visited[b]=true;
            //work
            for(int i:routes[b]){
            if(i==target)return rem.cnt;
            }
            
            //add*
            for(int stops:routes[b]){
                for(int buses:hm.get(stops)){
                    if(visited[buses]==false){
                        q.add(new Pair(buses,rem.cnt+1));
                    }
                }
            }
            
        }
        
        return -1;
    }
}