class Solution {
    public int splitArray(int[] nums, int m) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
            sum+=nums[i];
        }
        if(m==nums.length)return maxi;
        int start=maxi;
        int end=sum;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPoss(mid,m,nums)==true){
                end=mid-1;
            }else
                start=mid+1;
        }
        return start;
    }
    
    public boolean isPoss(int target,int k,int[] nums){
        int cnt=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>target){
                cnt++;
                sum=nums[i];
            }
        }
       //if(sum>target)cnt++;
        
        if(cnt<=k)return true;
        return false;
        
    }
}