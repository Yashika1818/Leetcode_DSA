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
    int count=0;//this needs to be globally declared as it cant be passed bcz of static nature
    public int pathSum(TreeNode root, int targetSum) {
       // approach : subarray target sum --> hashmap for psum and freq
        // if we pass hashmap to helper fn , then we are passing reference
        // but if we pass an integer then that is static its value at every call is not reflected to other call
        if(root==null)return 0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        //pass the prefixsum as root.val bcz value of root is also included
        helper(root,root.val,targetSum,hm);
        return count;
    }
    
    public void helper(TreeNode root, int psum,int tar,HashMap<Integer,Integer> hm){
        if(root==null){
          return;  
        }
        
        int diff=psum-tar;
        if(hm.containsKey(diff)){
            count+=hm.get(diff);
        }
            // hm.put(diff,hm.get(diff)+1);
            
       if(hm.containsKey(psum)){
           hm.put(psum,hm.get(psum)+1);
       }else
            hm.put(psum,1);
        
     // System.out.println(psum);
        if(root.left!=null){
        helper(root.left,psum+root.left.val,tar,hm);
        hm.put(psum+root.left.val,hm.get(psum+root.left.val)-1);
        
        }
    //    psum-=root.val;
        if(root.right!=null){
        helper(root.right,psum+root.right.val,tar,hm);
         hm.put(psum+root.right.val,hm.get(psum+root.right.val)-1);
        }
    }
}