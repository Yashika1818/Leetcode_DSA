class Solution {
    public void sortColors(int[] nums) {
        int zend=-1;
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(nums[i]==2){
                swap(i,j,nums);
                j--;
            }else if(nums[i]==1)i++;
            else
            {
                swap(zend+1,i,nums);
                i++;
                zend++;
                
            }
        }
        return ;
    }
    public void swap(int a,int b,int[] nums){
        int x=nums[a];
        nums[a]=nums[b];
        nums[b]=x;
        return;
    }
}