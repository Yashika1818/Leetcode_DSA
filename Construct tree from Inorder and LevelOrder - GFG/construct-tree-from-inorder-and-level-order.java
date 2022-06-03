// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here\
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<level.length;i++){
            hm.put(level[i],i);
        }
        
        return helper(hm,inord,0,inord.length-1);
        
    }
    Node helper(HashMap<Integer,Integer> hm,int[] inord,int lo,int hi){
        if(lo>hi)return null;
        int minidx=lo; //index in inorder for minimum index of level order in a particular range
        for(int i=lo;i<=hi;i++){
            if(hm.get(inord[i])<hm.get(inord[minidx])){
                minidx=i;
            }
        }
        Node node=new Node(inord[minidx]);
        node.left=helper(hm,inord,lo,minidx-1);
        node.right=helper(hm,inord,minidx+1,hi);
        return node;
    }
   
}


