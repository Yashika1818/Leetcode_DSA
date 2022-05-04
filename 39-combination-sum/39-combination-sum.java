class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> asf=new ArrayList<>();
        helper(candidates,target,asf,0,ans);
        return ans;
    }
    public   void   helper(int[] candidates,int target,List<Integer> asf,int idx,List<List<Integer>> ans){
         if(target==0){
            ans.add(new ArrayList<Integer>(asf));
             return;
        } 
        if(idx==candidates.length || target<0){
           return;
        }
       
        
        helper(candidates,target,asf,idx+1,ans);
        if(target>0){
            idx=idx;
             asf.add(candidates[idx]);
            target=target-candidates[idx];
               helper(candidates,target,asf,idx,ans);
      if(asf.size()>0)  asf.remove(asf.size()-1);
            target+=candidates[idx];
        }else{
            idx++;
              helper(candidates,target,asf,idx,ans);
        }
   
     
        return ;
    }
}