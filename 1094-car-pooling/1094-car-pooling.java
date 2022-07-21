class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    int[] map=new int[1001];
        // ArrayList<Integer> stops=new ArrayList<>(); we cant take arraylist as from and to can have repeated values 
        TreeSet<Integer> stops=new TreeSet<>();
        for(int[] trip:trips){
            int pass=trip[0];
            int from=trip[1];
            int to=trip[2];
            
            map[from]+=pass;
            map[to]-=pass;
            stops.add(from);
            stops.add(to);
        }
        
        int count=0;
        for(int stop:stops){
            int cnt=map[stop];
            count+=cnt;
            if(count>capacity){
                return false;
            }
        }
        return true;
    }
}