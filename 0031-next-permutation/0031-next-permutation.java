import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {

        boolean flag=false;
        int i=nums.length-1;
        for(i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                flag=true;
                break;
            }
        }
        if(flag==false){
            reverse(nums);
        }else{
            swap(i-1,nums);//swap with just greater
            Arrays.sort(nums,i,nums.length);
        }
       // 2 4 3
        return ;
            
    }
    public void swap(int idx,int[] nums){
        int swapper=idx+1;
        for(int i=idx+1;i<nums.length;i++){
            if((nums[i]>nums[idx])&& (nums[i]<=nums[swapper])){
                swapper=i;
            }
        }
        int x=nums[idx];
        nums[idx]=nums[swapper];
        nums[swapper]=x;
        return;
    }
    public void reverse(int[] nums){
        int j=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i>=j)break;
            int x=nums[i];
            int y=nums[j];
            nums[i]=y;
            nums[j]=x;
            j--;
        }
        return;
    }
}