//width is sorted in asc order , therefore we need not to look it now
//envelope with same width should have ht in desc order so that it doesnot interfere in lis --> [3,3] [3,4] --> if we look after ht only we will consider 3 4 as a part of lis but this is wrong as 3 3 cant be fitted in 3 4 
//therefore we need to sort as 3 4 , 3 3 so that 4 3 doesnt become the part of lis and one out of them can be considered.
//now we just need to find the longest increasing subsequence in case of ht 
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] arr1,int arr2[]){
                if(arr1[0]==arr2[0]){
                    return arr2[1]-arr1[1];
                }else
                    return arr1[0]-arr2[0];
            }
            
            
        });
        
        int dp[]=new int[envelopes.length];
        int len=0;
        for(int[] env: envelopes){
            int index=Arrays.binarySearch(dp,0,len,env[1]);
            if(index<0){
                index=-(index+1);
            }
            dp[index]=env[1];
            if(index==len)len++;
        }
        return len;
    }
}