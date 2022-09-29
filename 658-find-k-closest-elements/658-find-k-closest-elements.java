class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> list  = new ArrayList<>() ;
        
        int start =0 ;
        int end = arr.length-1 ;
        
        while(  (end - start +1  )!= k  ){

            
            if(Math.abs(arr[start]-x) > Math.abs(arr[end]-x)) start++ ;
            else end-- ;
        
        }
        for(int i =start ; i<=end; i++){
            list.add(arr[i]);
            
}
        return list ;
        
    }
}