class Solution {
    class Pair{
        int curr;
        int step;
        Pair(int curr,int step){
            this.curr=curr;
            this.step=step;
        }
    }
    public int snakesAndLadders(int[][] board) {
          if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }   
        int n=board.length;
        int m=board[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(1,0));
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        int steps=0;
        while(q.size()>0){
            Pair rem=q.remove();
        if(rem.curr==n*m)return rem.step;
        for(int d=1;d<=6 && d+rem.curr<=n*m;d++){
            int pos[]=generate(d+rem.curr,board);
            int next=board[pos[0]][pos[1]]==-1 ? d+rem.curr : board[pos[0]][pos[1]];
            if(set.contains(next)==false){
                set.add(next);
                q.add(new Pair(next,rem.step+1));
            }
            
        }
          
            
            
            
            }
        return -1;
    }
    public int[] generate(int val,int[][] board){
        int n=board.length;
        int x=n-1 -(val-1)/n;
        int y=(val-1)%n;
        if(x%2==n%2){
            y=n-1-y;
            
        }else{
            y=y;
        }
        
       int ans[]=new int[2];
        ans[0]=x;
        ans[1]=y;
        return ans;
    }
}


 // public int[] getCoordinate(int n, int rows, int cols) {
 //        int r = rows - 1 - (n - 1) / cols;
 //        int c = (n - 1) % cols;
 //        if (r % 2 == rows % 2) {
 //            return new int[]{r, cols - 1 - c};
 //        } else {
 //            return new int[]{r, c};
 //        }
 //    }

 // if (r % 2 == rows % 2) {
 //            return new int[]{r, cols - 1 - c};
 //        } else {
 //            return new int[]{r, c};
 //        }