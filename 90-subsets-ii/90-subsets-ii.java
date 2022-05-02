class Solution {
    public void helper(int[] nums,int idx,List<List<Integer>> ans,ArrayList<Integer> ds){
// ans.add(ds); it is incorrect as ds arraylist has a unique reference and whenever we are adding ds again nd again to ans al . it is always refering to the same al ds and hence each al in ans will be same and at last , every element is removed from ds hence all the empty al will be present in ans .
        //by always deep copying  ds to new al, is giving new references , hence modification done to ds wont change the copied al .
         ans.add(new ArrayList<>(ds));
        
            
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i-1]==nums[i])continue;
            ds.add(nums[i]);
            helper(nums,i+1,ans,ds);
            ds.remove(ds.size()-1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
         helper(nums,0,ans,new ArrayList<>());
        return ans;
    }
}