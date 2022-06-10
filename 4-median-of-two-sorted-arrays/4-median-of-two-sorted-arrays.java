//we need not to exactly sort and merge the array to get the median 
//we just want to know the partition of left and right in both the arrays
//try to work on array with smaller size to have smaller search space and better complexity
//we take lo and hi of smaller array and find out cut1 =(lo+hi)/2;
//cut1 is the partition of smaller array
//now we take cut2=(n1+n2+1)/2-cut1 --> parition of array 2
//Look for l1 , l2 (ending pts of left halves of both arrays ) and r1 ,r2(starting pts of right halves of both arrays )
//l1 --> nums1[cut1-1]  l2 --> nums2[cut2-1] 
// if cut1==0  then l1 --> MIN 
//if cut2==0 then l2--> MIN
// Considering 3 conditions:
    // 1. l1<=r2 && l2<=r1  --> valid 
    //   find median 
    //     median in case of even --> max(l1,l2)+min(r1,r2) /2
    //                       odd  --> max(l1,l2)
    // 2. if l1>r2
    //    then we need to decrease l1 therefore we need to shift left hence
    //    hi=cut1-1;
    // 3. if l2 > r1
    //    then we need to decrease l2 and increase l1 therefore we need to shift right
    //     lo=cut1+1
        
class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) return findMedianSortedArrays(nums2,nums1);
        
        int n1=nums1.length;
        int n2=nums2.length;
        // min partition from array1 is 0 i.e no element and max partition from array1 is n1 i.e all elements from    array1
        int lo=0,hi=n1; 
        while(lo<=hi){
            int cut1=(lo+hi)/2;
            int cut2=(n1+n2+1)/2 - cut1;
            
            int l1=( cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1]);
            int l2= ( cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1]);
            int r1=(cut1==n1 ? Integer.MAX_VALUE : nums1[cut1]);
            int r2=(cut2==n2 ? Integer.MAX_VALUE : nums2[cut2]);
            if(l1<=r2 && l2<=r1){
               if((n1+n2)% 2==0) return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else
                    return (double)(Math.max(l1,l2));
            }else if(l1 > r2){
                hi= cut1-1;
                
            }else{
                lo=cut1+1;
            }
        }
        return -1;
    }
    
}