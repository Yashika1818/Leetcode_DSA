class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.add(i);
        }
        int cnt=1;
        while(cnt<=k){
            if(cnt==k)return pq.peek();
            pq.remove();
            cnt+=1;
            
        }
        
        return -1;
    }
}