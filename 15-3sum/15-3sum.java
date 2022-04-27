class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length==0){
             List<List<Integer>> ans=new ArrayList<List<Integer>>();
            return ans;
        }
        if(nums.length<3){
           List<List<Integer>> ans=new ArrayList<List<Integer>>();
            return ans;
        }
        Arrays.sort(nums);
        int sum=0;
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            sum=0-nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                if(start>i+1 && nums[start]==nums[start-1])
                {
                    start++;
                    continue;
                }
                if(end< nums.length-1 && nums[end]==nums[end+1]){
                    end--;
                    continue;
                }
            if(nums[start]+nums[end] < sum ){
                start++;
            }else if(nums[start]+nums[end] > sum ){
                end--;
            }else{
                List<Integer> l=new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[start]);
                l.add(nums[end]);
                ans.add(l);
                start++;
                end--;
            }
        }
    }
        return ans;
    }
    
}