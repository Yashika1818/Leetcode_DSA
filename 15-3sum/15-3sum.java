class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // if(nums.length==0){
        //      List<List<Integer>> ans=new ArrayList<List<Integer>>();
        //     return ans;
        // }
        // if(nums.length<3){
        //    List<List<Integer>> ans=new ArrayList<List<Integer>>();
        //     return ans;
        // }
        Arrays.sort(nums);
        int sum=0;
        List<List<Integer>> ans=new LinkedList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            sum=0-nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                //WE NEED NOT TO APPLY THESE CONDITIONS FOR EVERY ITERATION
                //BCZ WE ARE DOING SO TO REMOVE DUPLICATES, ANS IS CREATED WHEN ELSE CONDITION IS EXECUTED , THEREFORE WE CAN ONLY WRITE THESE COONDITION IN ELSE .
                // if(start>i+1 && nums[start]==nums[start-1])
                // {
                //     start++;
                //     continue;
                // }
                // if(end< nums.length-1 && nums[end]==nums[end+1]){
                //     end--;
                //     continue;
                // }
            if(nums[start]+nums[end] < sum ){
                start++;
            }else if(nums[start]+nums[end] > sum ){
                end--;
            }else{
                ans.add(Arrays.asList(nums[i],nums[start],nums[end]));
                // List<Integer> l=new ArrayList<>();
                // l.add(nums[i]);
                // l.add(nums[start]);
                // l.add(nums[end]);
                // ans.add(l);
                while(start<end && nums[start]==nums[start+1])start++; //jaise e start>end hojaega kuch krne ki need nhi hai.
                while(start<end && nums[end]==nums[end-1])end--;
                start++;
                end--;
            }
        }
    }
        return ans;
    }
    
}