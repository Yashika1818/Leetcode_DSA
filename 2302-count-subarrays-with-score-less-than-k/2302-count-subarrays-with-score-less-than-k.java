class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i=0;
        int j=0;
        long count=0;
        long sum=0;
       while(j<nums.length){
           if(nums[j]<k){
               count++;
              
           }
           
            sum+=nums[j];
           
           while((sum)*(j-i+1)>=k){
               sum-=nums[i];
               i++;
           }
               if(j>i && ((sum)*(j-i+1))<k ){
            //   System.out.println(i+" "+j);
               count+=j-i;
               }
           j++;
           
       }
        //case when complete array sum is less than k
        // i++;
        // if(j==nums.length && (sum)*(j-i) <k){
        //     while(i!=j-1 && (sum)*(j-i) <k){
        //      //   System.out.println(i+" "+j);
        //        sum-=nums[i];
        //         i++;
        //         count++;
        //     }
        // }
        return count;
    }
}