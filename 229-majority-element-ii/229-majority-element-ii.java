class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int num1=-1;
        int num2=-1;
        int c1=0,c2=0;
        for(int num:nums){
            if(num==num1)c1++;
            else if(num==num2)c2++;
            else if(c1==0){
                num1=num;
                c1=1;
            }else if(c2==0){
                num2=num;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }
        
        c1=0;
        c2=0;
        for(int num:nums){
            if(num==num1)c1++;
            else if(num==num2)c2++;
        }
        List<Integer> al=new ArrayList<>();
        if(c1>(nums.length/3))
            al.add(num1);
        if(c2>(nums.length/3))
            al.add(num2);
        
        return al;
    }
}