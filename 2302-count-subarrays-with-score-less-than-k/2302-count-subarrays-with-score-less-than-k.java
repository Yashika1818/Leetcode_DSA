class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0;
        int j=0;
        long count=0;
        long sum=0;
       while(j<nums.length){
           if(nums[j]<k){
               count++;  
                 sum+=nums[j];
           }  else{
               sum=0;
               j++;
               i=j;
               continue;
           }
          
           
           while((sum)*(j-i+1)>=k){
               sum-=nums[i];
               i++;
           }
               if(j>i && ((sum)*(j-i+1))<k ){
          
               count+=j-i;
               }
           j++;
           
       }
     
        return count;
    }
}