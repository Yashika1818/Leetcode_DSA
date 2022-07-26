class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)return findMedianSortedArrays(nums2,nums1);
        //left half of merged sorted array can have n+m+1/2 elements in case of both odd and even
        //cut1 for array1 can be from 0 to nums1.length --> 0 element to all elements
       int lo=0;
        int n1=nums1.length;
        int n2=nums2.length;
        int hi=nums1.length;
        int lefthalf=(nums1.length+nums2.length+1)/2;
        while(lo<=hi){
            int cut1=(lo+hi)/2;
            int cut2=lefthalf-cut1;
            int l1= cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2= cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1= cut1==nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int r2= cut2==nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1<=r2 && l2<=r1){
             //   System.out.println(1);
                if((n1+n2)%2==0){
                
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else
                    return Math.max(l1,l2);
            }else if(l1>r2){
                hi=cut1-1;
            }else if(l2>r1){
                lo=cut1+1;
            }
            
        }
        return -1;
    }

    
}