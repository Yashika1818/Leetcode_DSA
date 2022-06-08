class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
         int mid=(lo+hi)/2;
            if(mid-1>=0 && nums[mid]==nums[mid-1]){
                if(mid%2!=0){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }else if(mid+1<nums.length && nums[mid]==nums[mid+1]){
                 if(mid%2!=0){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                return nums[mid];
            }
        }
        return -1;
    }
}