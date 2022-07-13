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
    public List<List<Integer>> levelOrder(TreeNode root) {
     
       
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
           if(root==null)return ans;
         Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> al=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode rem=q.remove();
                al.add(rem.val);
                if(rem.left!=null)q.add(rem.left);
                if(rem.right!=null)q.add(rem.right);
            }
            ans.add(al);
        }
        
        return ans;
    }
}