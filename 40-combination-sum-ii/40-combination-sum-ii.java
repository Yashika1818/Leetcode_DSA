class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<Integer> asf=new ArrayList<>();
            List<List<Integer>> ans=new ArrayList<List<Integer>>();
        helper(candidates,target,0,asf,ans);
        return ans;
        
    }
    public void helper(int[] candidates,int target,int idx,List<Integer> asf,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<Integer>(asf));
            return;
        }
        if(idx==candidates.length || target<0){
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1])continue;
            target-=candidates[i];
           asf.add(candidates[i]);
            helper(candidates,target,i+1,asf,ans);
             asf.remove(asf.size()-1);
             target+=candidates[i];
        }
    }
}