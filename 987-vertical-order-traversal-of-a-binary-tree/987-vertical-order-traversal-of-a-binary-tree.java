/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int w; //width
        int d; //depth
        
        Pair(TreeNode node,int w,int d){
            this.node=node;
            this.w=w;
            this.d=d;
        }
        
        public int compareTo(Pair other){
            if(this.d == other.d)return this.node.val-other.node.val;
            else{
                return this.d-other.d;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Pair>> hm=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,1));
        int lw=Integer.MAX_VALUE;
        int uw=Integer.MIN_VALUE;
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(hm.containsKey(rem.w)){
                ArrayList<Pair> al=hm.get(rem.w);
                al.add(rem);
                hm.put(rem.w,al);
            }else{
                ArrayList<Pair> al=new ArrayList<>();
                al.add(rem);
                hm.put(rem.w,al);
            }
            lw=Math.min(rem.w,lw);
            uw=Math.max(rem.w,uw);
            if(rem.node.left!=null){
                q.add(new Pair(rem.node.left,rem.w-1,rem.d+1));
            }
            if(rem.node.right!=null){
                q.add(new Pair(rem.node.right,rem.w+1,rem.d+1));
            }
            
            
        }
      
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=lw;i<=uw;i++){
            ArrayList<Pair> unsorted=hm.get(i);
            Collections.sort(unsorted);
            List<Integer> al=new ArrayList<>();
            for(Pair p:unsorted){
                al.add(p.node.val);
            }
            ans.add(al);
        }
        
        return ans;
        
    }
}