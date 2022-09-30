class Solution {
    static class Building implements Comparable<Building>{
        int x;
        boolean isStart;
        int height;
        @Override
        public int compareTo(Building o){
            if(this.x != o.x)
                return this.x - o.x;
            else {
                return(this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Building[] bld = new Building[buildings.length*2];
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        for(int[] building: buildings){
            bld[index] = new Building();
            bld[index].x = building[0];
            bld[index].isStart = true;
            bld[index].height = building[2];
            
            bld[index+1] = new Building();
            bld[index+1].x = building[1];
            bld[index+1].isStart = false;
            bld[index+1].height = building[2];
            
            index+=2;
        }
        
        Arrays.sort(bld);
        
        int prevMaxHeight = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        
        for(Building b:bld){
            if(b.isStart){
                map.compute(b.height, (key, value) -> {
                    if(value!=null)
                        return value+1;
                    return 1;
                });
            } else{
                map.compute(b.height, (key, value) -> {
                    if(value==1)
                        return null;
                    return value-1;
                });
            }
            
            int currMaxHeight = map.lastKey();
            if(currMaxHeight!=prevMaxHeight){
                ArrayList<Integer> keyPoints = new ArrayList<>();
                keyPoints.add(b.x);
                keyPoints.add(currMaxHeight);
                res.add(keyPoints);
                prevMaxHeight = currMaxHeight;
            }
        }
        return res;
    }
}