//we will think this ques in opposite direction, instead of increasing n-1 elements by 1 each time to make all equal--> decrement 1 element each time to make all equal
class Solution {
    public int minMoves(int[] nums) {
        
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            mini=Math.min(mini,nums[i]);
        }
        int moves=0;
        for(int i=0;i<nums.length;i++){
            moves+=nums[i]-mini;
        }
        return moves;

    }
}