//Optimized form using PQ of TC : (log K)
class Solution {
    class Pair implements Comparable<Pair>{
        int idx;
        int val;
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
        
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public int maxResult(int[] nums, int k) {
       
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        pq.add(new Pair(nums.length-1,nums[nums.length-1]));
      
        int max=nums[0];
        for(int i=nums.length-2;i>=0;i--){
            while(pq.peek().idx > i+k){ // if peek val is outside the window then keep popping out
                pq.poll();
            }
            max=pq.peek().val+nums[i];
            pq.add(new Pair(i,max));
             
        }
        
        return max;
    }

}