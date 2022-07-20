class Solution {
    public int maximumSwap(int num) {
        // min -> 0 to n-2
        // if a num less than max is before it , than swap
        // 8 7 6 2 3
        // num < max()
        // swap
        // else
        //     i++
        String s= Integer.toString(num);
        char[] ch=s.toCharArray();
       int[] m=new int[s.length()];
        m[s.length()-1]=s.length()-1;
        int maxi=s.length()-1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)-'0'>s.charAt(maxi)-'0'){
                maxi=i;
            }
            m[i]=maxi;
        }
     
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)-'0'<s.charAt(m[i+1])-'0'){
               int idx=m[i+1];
                char temp=ch[idx];
                ch[idx]=ch[i];
                ch[i]=temp;
                break;
            }
        }
        String string = new String(ch);  
        return Integer.parseInt(string);
        
    }
}