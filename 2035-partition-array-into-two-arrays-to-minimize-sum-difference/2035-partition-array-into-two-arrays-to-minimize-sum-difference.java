class Solution {
    public static int minDiff;
    public int minimumDifference(int[] nums) {
        int n=nums.length/2;
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        minDiff=Integer.MAX_VALUE;
        HashMap<Integer,ArrayList<Integer>> left=new HashMap<>();
        recursion(nums,0,0,0,left,n);
        HashMap<Integer,ArrayList<Integer>> right=new HashMap<>();
        recursion(nums,0,0,n,right,nums.length);
        
        for(ArrayList<Integer> l:left.values()){
            Collections.sort(l);
        }
        for(ArrayList<Integer> r:right.values()){
            Collections.sort(r);
        }
        int leftsum=0;
        for(int i=0;i<n;i++){
            leftsum+=nums[i];
        }
        int rightsum=0;
        for(int i=n;i<nums.length;i++){
            rightsum+=nums[i];
        }
        minDiff=Math.abs(leftsum-rightsum);
        for(int cnt=1;cnt<=n;cnt++){
            ArrayList<Integer> l=left.get(cnt);
            ArrayList<Integer> r=right.get(n-cnt);
            if(r!=null){
                int i=0,j=r.size()-1;
                int target=totalSum/2;
                while(i<l.size() && j>=0){
                          minDiff=Math.min(minDiff,Math.abs(totalSum-2*(l.get(i)+r.get(j))));
                    if(l.get(i)+r.get(j) >target){
                        j--;
                    }else{
                        i++;
                    }
              
                }
            }
        }
        
        
        return minDiff;
    }
    public void recursion(int[] nums,int count,int currsum,int idx,HashMap<Integer,ArrayList<Integer>> left,int end){
        if(count!=0 && left.containsKey(count)){
            left.get(count).add(currsum);
        }else if(count!=0){
            ArrayList<Integer> l=new ArrayList<>();
            l.add(currsum);
            left.put(count,l);
        }
        if(idx==end)return;
        recursion(nums,count+1,currsum+nums[idx],idx+1,left,end);
        recursion(nums,count,currsum,idx+1,left,end);
        return;
        
    }
}