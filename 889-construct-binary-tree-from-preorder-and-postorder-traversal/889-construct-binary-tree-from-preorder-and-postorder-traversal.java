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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }
        TreeNode node=helper(hm,preorder,0,preorder.length-1,0,postorder.length-1);
        return node;
    }
    
    public TreeNode helper(HashMap<Integer,Integer> map,int[] pre,int lo,int hi,int postlo,int posthi){
        if(lo>hi || postlo>posthi)return null; //this is the case for geenral binary tree having 1 child only.
        
        TreeNode node=new TreeNode(pre[lo]);
         if(lo+1<=hi){       //this is the codition when lo != hi , lo==hi when both of its child is null so by default right nd left will be null , this if condition is useless for that node i.e. leaf.
             
       // this condition is also for pre[lo+1] becz null is not present in pre array to extract .
        int j=map.get(pre[lo+1]);
        int h=j-postlo+1;
        //send left from pre array as well as post array
        node.left=helper(map,pre,lo+1,lo+h,postlo,j);
        // send right from pre array as well as post array
        node.right=helper(map,pre,lo+h+1,hi,j+1,posthi-1);
        
     }
        return node;
        
}
}