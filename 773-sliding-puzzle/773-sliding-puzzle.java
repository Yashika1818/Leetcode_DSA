class Solution {
    //for visited board --> we need to convert board into string , so that we can push that string into hashset and then we can get the visited ones
    
    class Pair{
        String config;
        int level;
        Pair(String config,int level){
            this.config=config;
            this.level=level;
        }
    }
    public int slidingPuzzle(int[][] board) {
        HashSet<String> set=new HashSet<>();
        ArrayDeque<Pair> q=new ArrayDeque<>();
        String conf=generateConfig(board);
        q.add(new Pair(conf,0));
        while(q.size()>0){
            Pair rem=q.remove();
            
            if(set.contains(rem.config))continue;
            set.add(rem.config);
            
            if(rem.config.equals("123450")){
                return rem.level;
            }
            
            int[][] dir={
                {1,3} ,{0,2,4}, {1,5} ,{0,4} ,{1,3,5},{2,4}
            };
            
            int idx=rem.config.indexOf('0');
            
            for(int i:dir[idx]){
                String nconfig=swap(rem.config,i,idx);
                if(set.contains(nconfig)==false){
                    q.add(new Pair(nconfig,rem.level+1));
                }
            }
        }
        
        return -1;
        
    }
    
    public String generateConfig(int[][] board){
        String s="";
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //char c=(char)board[i][j]-'0';
                s+=board[i][j]+"";
            }
        }
        return s;
    }
    
    public static String swap(String conf,int i ,int j){
        StringBuilder str=new StringBuilder(conf);
        char ch=str.charAt(i);
        str.setCharAt(i,conf.charAt(j));
        str.setCharAt(j,ch);
        return str.toString();
    }
}