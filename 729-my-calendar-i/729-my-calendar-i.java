class MyCalendar {
    class Pair{
        int s;
        int e;
        Pair(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
    ArrayList<Pair> al;
    public MyCalendar() {
        al=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(al.size()==0){
            al.add(new Pair(start,end));
            return true;
        }
        for(int i=0;i<al.size();i++){
            if(al.get(i).s==start )return false;
            if(al.get(i).e==end)return false;
            if(end<al.get(i).s)continue;
            if(al.get(i).s>start && al.get(i).s<end)return false;
            if(al.get(i).s<start && al.get(i).e>start)return false;
            if(al.get(i).e>end && al.get(i).s>end)return false;
        }
        al.add(new Pair(start,end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */