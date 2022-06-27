class Solution {
    public boolean checkPossibility(int[] nums) {
        
        // 1 4 3 or edge case min se bda e hoga
        // 3 4 2
        // 3 2 3
        int count=0;
        for(int i=1;i<nums.length;i++)
        {
            
            if(nums[i-1]>nums[i]){
                count++;
                if(i==1) nums[i-1]=nums[i];
                if(i>=2 ){
                    if(nums[i-2]>nums[i])
                nums[i]=nums[i-1];
                else 
                    nums[i-1]=nums[i];
                    }
            }
            if(count>1)return false;
        } 
        return true;
    
    }
}