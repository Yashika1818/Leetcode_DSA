class Solution {
    public boolean search(int[] nums, int target) {
            int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target)return true;
            if(nums[lo]<nums[mid] ){
                if(target>=nums[lo] && target<=nums[mid]){
                    hi=mid-1;
                     
                }else{
                    lo=mid+1;
                     
                }
            }else if(nums[lo] > nums[mid]){
                if(target>=nums[mid] && target<=nums[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                } 
            }else{
                // 1 0 1 1 1 
                // l   m   h
                // or
                // 1 1 1 1 2 1
                // as in this case mid ==hi==lo we cant get where we need to move, so we will just decrease our bs space by doing lo++;
              lo++;
            }
        }
        return false;
    
    }
}