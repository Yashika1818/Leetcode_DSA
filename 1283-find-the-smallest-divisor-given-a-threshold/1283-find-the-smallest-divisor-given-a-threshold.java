class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
      Arrays.sort(nums);
      int maxi=nums[nums.length-1];
      int start=0,end=0;
      if(nums.length<=threshold){
           start=1;
           end=maxi;
        
      }else{
           start=maxi+1;
           end =(int)1e6;
          
      }
      while(start<=end){
              int mid=start+(end-start)/2;
               if(check(mid,nums,threshold)==true){
                 //  System.out.println(1);
                   end=mid-1;
               }else
                   start=mid+1;
      }
        
        return start;
          
    }
    public boolean check(int mid,int[] nums,int th){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            double d=(double)nums[i]/mid;
            if(d%1==0){
                sum+=d;
            }else
                sum+=(int)d+1;
        }
        if(sum<=th)return true;
        return false;
    }
}