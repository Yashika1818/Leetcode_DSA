class Solution {
    public int maxSubArray(int[] nums) {
        int maxtillnow=nums[0];
        int ansmax=nums[0];
        if(nums.length==1)return nums[0];
        //if(nums[0]>=0) maxtillnow=nums[0];
        for(int i=1;i<nums.length;i++){
         //   int prev=maxtillnow;
            if(maxtillnow+nums[i] > nums[i]){
                
                
                maxtillnow=maxtillnow+nums[i];
              
            }else
                maxtillnow=nums[i];
            
               if(maxtillnow>ansmax){
                    ansmax=maxtillnow;
                }
          //  System.out.println(ansmax);
        }
        return ansmax;
    }
}