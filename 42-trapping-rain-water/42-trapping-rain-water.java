class Solution {
    public int trap(int[] height) {
        //TWO POINTER APPROACH 
        //INTUITION : IF WE GO LEFT TO RIGHT AND L < R THEN WATER IS TAPPED BECOZ OF L AND WE LOOK FOR LEFTMAX
        //BUT IF WE GO FROM RIGHT TO LEFT AND R < L THEN WATER IS TAPPED BECOZ OF R AND WE LOOK FOR RIGHTMAX
        //THAT'S WHY TO GO THRO BOTH THE SITUATIONS, WE ARE KEEPING TRACK FROM BOTH SIDES SIMULTANEOUSLY.
        int left=0,leftmax=0,rightmax=0,count=0;
        int right=height.length-1;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=leftmax)leftmax=height[left];//if equal also then at that point no water trap will occur bcz leftmax-height[i]==0
                else{
                    count+=leftmax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightmax)rightmax=height[right];
                else
                    count+=rightmax-height[right];
                right--;
            }
        }
        return count;
    }
}