class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            
            int idx=nums[i];
            if(idx<0)idx=-idx;
            if(nums[idx]<0){
                return idx;
            }
            nums[idx]=-nums[idx];
        }
        return -1;
    }
    
}