class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int len=0;
        int maxLen=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                len=1;
                while(set.contains(num+1)){
                    num=num+1;
                    len=len+1;
                }
                maxLen=Math.max(maxLen,len);
            }
            
        }
        
   
        return maxLen;
    }
}