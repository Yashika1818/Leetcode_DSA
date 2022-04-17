class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],true);
        }
        int maxlen=0;
        for(int key:hm.keySet()){
            if(hm.containsKey(key-1))continue;
            else{
                int count=1;
                while(hm.containsKey(key+1)){
                    count++;
                    key=key+1;
                }
                if(count>maxlen)maxlen=count;
            }
        }
        return maxlen;
    }
}