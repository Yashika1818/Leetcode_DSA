class Solution {
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        int[] ind=new int[nums.length];
        ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ind[i]=i;
        }

     //   int[] tmp=new int[nums.length];
       mergeSort(nums,ind,0,nums.length-1);
        List<Integer> al=new ArrayList<>();
        for(int a:ans){
            al.add(a);
        }
        return al;
    }
    
    
    public void mergeSort(int[] arr,int[] ind,int lo,int hi){
       
        
        if(lo<hi){
            int mid=(lo+hi)/2;
            mergeSort(arr,ind,lo,mid);
           mergeSort(arr,ind,mid+1,hi);
           merge(arr,ind,lo,mid,mid+1,hi);
        }
        
        return;
    }
    
    public void merge(int[] arr,int[] ind,int lo1,int hi1,int lo2,int hi2){
        
        int i=lo1;
        int j=lo2;
    int rightcount = 0;    	
       int[] tmp=new int[hi2-lo1+1];
        int k=0;
        while(i<=hi1 && j<=hi2){
            if(arr[ind[i]] <= arr[ind[j]]){
               tmp[k]= ind[i];
               // System.out.println(1);
                ans[ind[i]]+=rightcount;
                k++;
             i++;
            }else{
                rightcount++;
                tmp[k++]=ind[j++];
            
            }
        }
        
         while(i <= hi1){
        tmp[k] = ind[i];
              ans[ind[i]]+=rightcount;
             i++;
             k++;
         }

    while(j <= hi2)
        tmp[k++] = ind[j++];

    for(i = lo1 ; i <= hi2; i++)
        ind[i] = tmp[i-lo1];
        
        return;
    }
    
  
}