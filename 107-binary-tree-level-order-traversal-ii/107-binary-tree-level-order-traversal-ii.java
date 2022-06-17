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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
              List<List<Integer> > ans=new ArrayList<List<Integer>>();
        List<Integer> al=new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> st=new Stack<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
    
       q.add(null);
        
         while(q.size()>0){
            TreeNode rem=q.remove();
            
            st.push(rem);
            if(rem==null){
             if(q.size()>0)   q.add(null);
                continue;
            }
            
           if(rem.right!=null) q.add(rem.right);
           if(rem.left!=null) q.add(rem.left);
        }
  
        while(st.size()>0){
            TreeNode rem=st.pop();
            
            if(rem==null){
           if(al.size()>0)     ans.add(al);
                al=new ArrayList<>();
                continue;
            }
            al.add(rem.val);
        }
        ans.add(al);
        return ans;
    }
}