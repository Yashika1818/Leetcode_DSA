class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        for(int[] row:intervals){
            if(ans.size()==0){
                ArrayList<Integer> al=new ArrayList<>();
                al.add(row[0]);
                al.add(row[1]);
                ans.add(al);
                continue;
            }
            ArrayList<Integer> prev=ans.get(ans.size()-1);
            if(prev.get(1) >= row[0]){
                prev.set(1,Math.max(prev.get(1),row[1]));
            }else{
                ArrayList<Integer> al=new ArrayList<>();
                al.add(row[0]);
                al.add(row[1]);
                ans.add(al);
            }
        }
        int[][] ansarr=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            ansarr[i][0]=ans.get(i).get(0);
             ansarr[i][1]=ans.get(i).get(1);
            
        }
        
        
        return ansarr;
    }
}