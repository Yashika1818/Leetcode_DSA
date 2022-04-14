class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=n-1;
        int i=m-1;
        int k=n+m-1;
       // if(m==1 && nums2.length==0)return;
       // if(nums1.length==0 && nums2.length==1)nums1
       while(j>=0 && i>=0){
        if(nums1[i]>nums2[j]){
            nums1[k--]=nums1[i--];
        }else
            nums1[k--]=nums2[j--];
           
        }
        //for i<=0
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
            
    }
}