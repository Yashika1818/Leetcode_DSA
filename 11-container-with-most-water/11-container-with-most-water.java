class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=Math.min(height[left],height[right])*(right-left);
        while(left<right){
            
            if(height[left]<height[right]){
                left++;
            }else{//when values are equal , agr koi baad me bdi aa bhi jati hai toh bhi min equal wla hoga,even width kam hoga so area km e ayega and aage km value milti hai to bhi km hoga area bcz width and value dono km
                right--;
            }
            area=Math.max(area,Math.min(height[left],height[right])*(right-left));
        }
        return area;
    }
}