class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1,prev=nums[0],i=1,j=1;
        
        while(i<nums.length){
            if(prev==nums[i]){
                i++;
            }else{
                prev=nums[i];
                nums[j]=nums[i];
                j++;
                count++;
                i++;
            }
        }
        return count;
    }
}