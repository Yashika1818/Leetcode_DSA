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
    public List<Double> averageOfLevels(TreeNode root) {
       
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Double> ans=new ArrayList<>();
         if(root==null)return ans;
        while(q.size()>0){
            int s=q.size();
            Double answer=0.0;
            for(int i=0;i<s;i++){
            TreeNode rem=q.remove();
            answer+=(double)rem.val;
            if(rem.left!=null)q.add(rem.left);
            if(rem.right!=null)q.add(rem.right);
            
        }
            ans.add(answer/s);
    }
        return ans;
}
}