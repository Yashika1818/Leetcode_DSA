class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for( ;i>=1;i--){
            if(nums[i-1]<nums[i]){
                int min=nums[i];
                int minidx=i;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]<min && nums[j]>nums[i-1]){
                        min=nums[j];
                        minidx=j;
                    }
                }
                
                int temp=nums[i-1];
                nums[i-1]=min;
                nums[minidx]=temp;
                break;
            }
            
            
        }
        
        Arrays.sort(nums,i,nums.length);
    }
}
