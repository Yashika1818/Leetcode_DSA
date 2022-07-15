class Solution {
    public int nextGreaterElement(int n) {
       
        String str1 = Integer.toString(n);
        int[] arr=new int[str1.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=str1.charAt(i)-'0';
        }
        int j=arr.length-1;
        int i=arr.length-2;
        boolean flag=false;
        while(i>=0 && j>=0){
            
            if(arr[i]<arr[j]){
                flag=true;
                break;
            }
            j--;
            i--;
        }
        if(flag==false)return -1;
        j=str1.length()-1;
        
        while(i<j){
            if(arr[j]>arr[i]){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                break;
            }
            j--;
        }
         long ans=0;
       Arrays.sort(arr,i+1,arr.length);
        for(int s=0;s<arr.length;s++){
            ans=ans*10+arr[s];
        }
        //if ans becomes greater than Integer.MAX_VALUE , then it becomes negative
        return ans>Integer.MAX_VALUE ? -1 : (int)ans;
    }
}