class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int left= mid-1 >=0 ? (((nums[mid]!=nums[mid-1])==true) ?1 :0) : 1;
            int right=mid+1<nums.length ? (((nums[mid]!=nums[mid+1])==true) ?1 :0) :1;
            if(left==1 && right==1) {
                return nums[mid];
            }else if(mid%2==0){
                if(mid-1>=0 && nums[mid-1]==nums[mid])hi=mid-1;
                else
                    lo=mid+1;
            }else{
                if(mid-1>=0 && nums[mid-1]==nums[mid])lo=mid+1;
                else
                    hi=mid-1;
            }

        }
        return -1;
    }
}