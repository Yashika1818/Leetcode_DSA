class Solution {
    public int subarraysDivByK(int[] nums, int k) {
     
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);//remainder zero means completely divisible . therefore, 1 such case is handled initially.
        int psum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            psum+=nums[i];
            int rem=psum%k;
            //negative rem occurs in case of negative num
               //we need only positive remainder , dividend = divisor*quotient + rem is the general cond
            //but if we get dividend = divisor*quotient - rem now add nd sub divisor 
            // dividend= divisor*quotient-divisor + (divisor - rem)
            if(rem<0)rem=k+rem;
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
                hm.put(rem,hm.get(rem)+1);
            }else{
                hm.put(rem,1);
            }
        }
        return count;
    }
}