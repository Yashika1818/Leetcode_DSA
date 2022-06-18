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
    TreeNode node=null;
    public void find(TreeNode root,int x){
        if(root==null)return;
        if(root.val==x){
            node=root;
        }
        find(root.left,x);
        find(root.right,x);
    }
    
    public int count(TreeNode node){
        if(node==null)return 0;
        
        int l=count(node.left);
        int r=count(node.right);
        return l+r+1;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root,x);
   int c1=count(node.left);
int c2=count(node.right);
        int total=count(root);
        int c3=total-c1-c2-1;
        int maxi=Math.max(c1,Math.max(c2,c3));
        if(maxi<=(total-1)/2)return false;
        
        return true;
    }
}