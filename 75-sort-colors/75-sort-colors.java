class Solution {
    public void sortColors(int[] nums) {
        int red=0,white=0,blue=nums.length-1;
        while(white<=blue){
            if(nums[white]==0)swap(red++,white++,nums);
            else if(nums[white]==1)white++;
            else{
                swap(white,blue--,nums);
            }
        }
    }
    
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}