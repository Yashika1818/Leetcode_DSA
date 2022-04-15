import java.util.Arrays;
class Solution {
    //we can't directly implement merge sort here bcoz if left[i]>right[j] , we do inv+ nd j++, i.e we have included all the ith after that in inv+ but in this case we do inv+ only when left[i]>(2*right[j]) this is satisfied , it means all the ith elements after the curr i value are considered nd we are moving to j++ to check for next j with the curr i but this is not the case, suppose left[i]!>(2*right[j]) for current ith but for next ith element , it is poss for this jth but due to increment in this jth , we are ignoring this case and hence this algo is wrong.
    public int reversePairs(int[] nums) {
        // for(int num:nums){
        // System.out.println(num);
        // }
        long[] numf=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            numf[i]=(long)nums[i];
        }
        return mergeSortAndCount(numf,0,nums.length-1);
        
    }
    public int mergeAndCount(long[] nums,int l,int m,int r){
        long[] left=Arrays.copyOfRange(nums,l,m+1);
        long[] right=Arrays.copyOfRange(nums,m+1,r+1);
        int i=0,j=0,k=l;
        int inv=0;
        
         while(i<left.length && j<right.length){
            if(left[i]<=(2*right[j]))i++;
            else if(left[i]>2*right[j])
            {
               inv+=left.length-i;
                j++;
                
            }
        }
        i=0;
        j=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j])nums[k++]=left[i++];
            else if(left[i]>right[j])
            {
              
                nums[k++]=right[j++];
               
            }
        }
        
        while(i<left.length){
            nums[k++]=left[i++];
        }
        while(j<right.length){
            nums[k++]=right[j++];
        }
      
        
        return inv;
    }
    public int mergeSortAndCount(long[] nums,int l,int r){
        int count=0;
        if(l<r){
            int m=(l+r)/2;
            //left
            count+=mergeSortAndCount(nums,l,m);
            count+=mergeSortAndCount(nums,m+1,r);
            count+=mergeAndCount(nums,l,m,r);
        }
        return count;
    }
}