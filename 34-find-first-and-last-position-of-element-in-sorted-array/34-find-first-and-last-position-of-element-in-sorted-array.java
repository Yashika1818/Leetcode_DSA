class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=-1;
        int end=-1;
        int[] ans=new int[2];
        if(nums.length==0){
            ans[0]=start;
            ans[1]=end;
            return ans;
        }
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi && (start==-1 || end==-1)){
            int mid=(lo+hi)/2;
            if(nums[mid]==target){
                if(nums[hi]==target){
                    end=hi;
                }else{
                    hi--;
                }
                
                if(nums[lo]==target)start=lo;
                else
                    lo++;
                
            }else if(nums[mid]<target)
                lo=mid+1;
            else
                hi=mid-1;
        }
        ans[0]=start;
        ans[1]=end;
        return ans;
    }
}
