class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int lenmax=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1))continue;
            int x=nums[i];
            int count=1;
            while(set.contains(x+1)){
                count++;
                x=x+1;
            }
            lenmax=Math.max(lenmax,count);
        
        }
        return lenmax;
    }
}